package com.example.readfile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = MainActivity.this;

        listView = findViewById(R.id.list_view);
        List<String> namefile = new ArrayList<>();

        File fl = new File("/storage/emulated/0/Download/hello");
        Log.v("TAG", "file file la: " + fl.isDirectory());

        String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath();
        File[] files = Environment.getExternalStorageDirectory().listFiles();
        Log.v("TAG", "số phần tử trong file là : " + files.length);
        for(File f : files){
            Log.v("TAG", f.getAbsoluteFile().getAbsolutePath());
            namefile.add(f.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, namefile);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(files[position].isDirectory()){
                    Log.v("TAG", "" + position);
                    Intent intent = new Intent( context , DetailActivity.class);
                    intent.putExtra("name", namefile.get(position));
                    intent.putExtra("path", sdPath + "/" + namefile.get(position));
                    context.startActivities(new Intent[]{intent});
                }else{
                    try {
                        FileInputStream fis = openFileInput(sdPath + "/" + namefile.get(position));
                        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                        String line;
                        StringBuilder builder = new StringBuilder();
                        while ((line = reader.readLine()) != null)
                            builder.append(line + "\n");
                        reader.close();
                        Intent intent = new Intent(context, ContentActivity.class);
                        intent.putExtra("content", builder.toString());
                        context.startActivities(new Intent[]{intent});
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

            }
        });

//        try {
//            String sdPath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android";
////            File[] files = Environment.getExternalStorageDirectory().listFiles();
//            File file = new File(sdPath);
//            File[] files = file.listFiles();
////            Log.v("TAG", "" + file.listFiles());
////            File[] listfiles = new File[]
//            Log.v("TAG", "" + sdPath);
//            for(File f : files){
//                Log.v("TAG", f.getName());
//            }
//            FileInputStream fis = new FileInputStream(sdPath);
//            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
//            String line;
//            StringBuilder builder = new StringBuilder();
//            while ((line = reader.readLine()) != null)
//                builder.append(line + "\n");
//                reader.close();
////                Log.v("TAG", builder.toString());
////            editContent.setText(builder.toString());
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }

        if(Build.VERSION.SDK_INT > 23 ){
            if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                Log.v("TAG", "permission granted");
            else{
                Log.v("TAG", "Permission denied");
                requestPermissions(new String[] {Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1234);
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1234)
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED)
                Log.v("TAG", "Permission granted");
            else
                Log.v("TAG", "Permission denied");
    }
}