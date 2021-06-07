package com.hakanor.todolist;

import java.io.Serializable;

public class ExampleItem implements Serializable {
    private int mImageResource;
    private String mText1;
    private String mText2;
    public ExampleItem(int imageResource, String text1, String text2) {
        mImageResource = imageResource;
        mText1 = text1;
        mText2 = text2;
    }
    public void changeText1(String text) {
        mText1 = text;
    }
    public int getImageResource() {
        return mImageResource;
    }
    public String getText1() {
        return mText1;
    }
    public String getText2() {
        return mText2;
    }
    public String setText1(String text) {
        this.mText1=text;
        return mText1;
    }
    public String setText2(String text) {
        this.mText2=text;
        return mText2;
    }
}
