package com.example.project2parcial;

public class elemento {
    private String mCreador;
    private String mImgUrl;
    private int mLikes;

    public elemento(String mImgUrl,String mCreador, int mLikes){
        this.mCreador=mCreador;
        this.mImgUrl=mImgUrl;
        this.mLikes=mLikes;
    }

    public String getmCreador() {
        return mCreador;
    }

    public String getmImgUrl() {
        return mImgUrl;
    }

    public int getmLikes() {
        return mLikes;
    }
}
