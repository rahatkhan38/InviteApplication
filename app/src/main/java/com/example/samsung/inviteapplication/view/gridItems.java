package com.example.samsung.inviteapplication.view;


import com.cunoraz.gifview.library.GifView;

public class gridItems {

    private int gifView;
    private String caption;

    public gridItems(int gifView, String caption) {
        this.gifView = gifView;
        this.caption = caption;
    }

    public int getGifView() {
        return gifView;
    }

    public void setGifView(int gifView) {
        this.gifView = gifView;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
