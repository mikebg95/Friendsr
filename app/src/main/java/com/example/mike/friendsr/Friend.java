package com.example.mike.friendsr;

import java.io.Serializable;

public class Friend implements Serializable {

    // variables of this class
    private String name, bio;
    private int drawableId;
    private float rating;

    // constructor for this class
    public Friend(String name, String bio, int drawableId) {
        this.name = name;
        this.bio = bio;
        this.drawableId = drawableId;
    }

    // getters for this class
    public String getName() {
        return name;
    }
    public String getBio() {
        return bio;
    }
    public int getDrawableId() {
        return drawableId;
    }
    public float getRating() {
        return rating;
    }
    public void setRating(float rating) {
        this.rating = rating;
    }
}
