package com.example.todo_18;

public class sport {
    private String title;
    private  String info;
    private final int imageResource;

    sport(String title, String info,int imageResource){
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResource() {
        return imageResource;
    }
}
