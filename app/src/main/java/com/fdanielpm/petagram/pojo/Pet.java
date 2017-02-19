package com.fdanielpm.petagram.pojo;

/**
 * Created by darkp on 5/02/17.
 */

public class Pet {
    private int id;
    private String name;
    private int photo;
    private int likes;

    public Pet(){ }

    public Pet(int id, String name, int photo, int likes) {
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
