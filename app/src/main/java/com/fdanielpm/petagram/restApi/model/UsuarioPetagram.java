package com.fdanielpm.petagram.restApi.model;

/**
 * Created by Daniel on 15/04/2017.
 */

public class UsuarioPetagram {

    private String idDispositivo;
    private String idUsuarioInstagram;

    public UsuarioPetagram() {
    }

    public UsuarioPetagram(String idDispositivo, String idUsuarioInstagram) {
        this.idDispositivo = idDispositivo;
        this.idUsuarioInstagram = idUsuarioInstagram;
    }

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getIdUsuarioInstagram() {
        return idUsuarioInstagram;
    }

    public void setIdUsuarioInstagram(String idUsuarioInstagram) {
        this.idUsuarioInstagram = idUsuarioInstagram;
    }
}
