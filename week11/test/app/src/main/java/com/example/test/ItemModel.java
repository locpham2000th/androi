package com.example.test;

public class ItemModel {

    private String title;
    private int avatarResource;
    private boolean isLeft;

    public ItemModel(String title, int avatarResource) {
        this.title = title;
        this.avatarResource = avatarResource;
        isLeft = true;
    }

    public ItemModel(String title, int avatarResource, boolean isLeft) {
        this.title = title;
        this.avatarResource = avatarResource;
        this.isLeft = isLeft;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAvatarResource() {
        return avatarResource;
    }

    public void setAvatarResource(int avatarResource) {
        this.avatarResource = avatarResource;
    }

    public boolean isLeft() {
        return isLeft;
    }

    public void setLeft(boolean left) {
        isLeft = left;
    }
}
