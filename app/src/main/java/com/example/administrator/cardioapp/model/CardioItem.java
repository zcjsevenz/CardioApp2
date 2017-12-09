package com.example.administrator.cardioapp.model;

/**
 * Created by Administrator on 9/12/2560.
 */

public class CardioItem {
    public final String title;
    public final String picture;
    public final String detail;

    public CardioItem(String title, String picture, String detail) {
        this.title = title;
        this.picture = picture;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return title;
    }
}


