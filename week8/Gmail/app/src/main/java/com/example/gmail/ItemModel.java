package com.example.gmail;

public class ItemModel {

    private int avataSRC;
    private String name;
    private String content;

    public ItemModel(int avataSRC, String name, String content) {
        this.avataSRC = avataSRC;
        this.name = name;
        this.content = content;
    }

    public int getAvata() {
        return avataSRC;
    }

    public void setAvata(int avata) {
        this.avataSRC = avata;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
