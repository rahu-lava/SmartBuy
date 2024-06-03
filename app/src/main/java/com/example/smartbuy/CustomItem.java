package com.example.smartbuy;

public class CustomItem {
    private final String text;
    private final int imageResourceId;

    public CustomItem(String text, int imageResourceId) {
        this.text = text;
        this.imageResourceId = imageResourceId;
    }

    public String getText() {
        return text;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}
