package com.fdanielpm.petagram.pojo;

/**
 * Created by Daniel on 05/04/2017.
 */

public class Account {

    private String id;
    private String username;
    private String urlProfilePicture;
    private String fullName;

    public Account() {
    }

    public Account(String id, String username, String urlProfilePicture, String fullName) {
        this.id = id;
        this.username = username;
        this.urlProfilePicture = urlProfilePicture;
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUrlProfilePicture() {
        return urlProfilePicture;
    }

    public void setUrlProfilePicture(String urlProfilePicture) {
        this.urlProfilePicture = urlProfilePicture;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
