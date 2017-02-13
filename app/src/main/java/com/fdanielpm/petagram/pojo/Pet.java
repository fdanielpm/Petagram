package com.fdanielpm.petagram.pojo;

/**
 * Created by darkp on 5/02/17.
 */

public class Pet {

    private String name;
    private int photo;
    private int likes;

    public Pet(String name, int photo, int likes) {
        this.name = name;
        this.photo = photo;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void likes(){
        likes++;
    }
}
