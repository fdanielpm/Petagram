package com.fdanielpm.petagram.pojo;

/**
 * Created by darkp on 5/02/17.
 */

public class Pet {
    private String id;
    private String name;
    private String urlPhoto;
    private int photo;
    private int likes;

    public Pet(){ }

    public Pet(String id, String name, String urlPhoto, int likes) {
        this.id = id;
        this.name = name;
        this.urlPhoto = urlPhoto;
        this.likes = likes;
    }

    public Pet(String id, String name, int photo, int likes) {
        this.id = id;
        this.name = name;
        this.photo = photo;
        this.likes = likes;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
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
