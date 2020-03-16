package com.example.mptest1.Modelo;

import java.util.HashMap;

public class Usuario {
    private String nombreUsuarioReg ;
    private String nombreReg;
    private String apellidoReg;
    private String emailReg ;
    private String telefonoReg;

    public String getNombreUsuarioReg() {
        return nombreUsuarioReg;
    }

    public void setNombreUsuarioReg(String nombreUsuarioReg) {
        this.nombreUsuarioReg = nombreUsuarioReg;
    }

    public String getNombreReg() {
        return nombreReg;
    }

    public void setNombreReg(String nombreReg) {
        this.nombreReg = nombreReg;
    }

    public String getApellidoReg() {
        return apellidoReg;
    }

    public void setApellidoReg(String apellidoReg) {
        this.apellidoReg = apellidoReg;
    }

    public String getEmailReg() {
        return emailReg;
    }

    public void setEmailReg(String emailReg) {
        this.emailReg = emailReg;
    }

    public String getTelefonoReg() {
        return telefonoReg;
    }

    public void setTelefonoReg(String telefonoReg) {
        this.telefonoReg = telefonoReg;
    }

    public Usuario() {
    }

}
