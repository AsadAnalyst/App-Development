package com.example.appdevelopment.CardViewExample;


public class MyModel {
    public String name;
    public int totalDownload;
    public int Thumbnail;

    public MyModel(String name, int totalDownload, int thumbnail) {
        this.name = name;
        this.totalDownload = totalDownload;
        Thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalDownload() {
        return totalDownload;
    }

    public void setTotalDownload(int totalDownload) {
        this.totalDownload = totalDownload;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}