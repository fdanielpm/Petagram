package com.fdanielpm.petagram.restApi.model;

/**
 * Created by Daniel on 15/04/2017.
 */

public class UsuarioResponse {

    private String id;
    private String deviceid;
    private String userid;

    public UsuarioResponse() {
    }

    public UsuarioResponse(String id, String deviceid, String userid) {
        this.id = id;
        this.deviceid = deviceid;
        this.userid = userid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceid() {
        return deviceid;
    }

    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
