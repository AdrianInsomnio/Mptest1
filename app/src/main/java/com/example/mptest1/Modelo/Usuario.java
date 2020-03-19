package com.example.mptest1.Modelo;

import java.io.Serializable;
import java.util.HashMap;

public class Usuario implements Serializable {
    private String nombreUsuarioReg ;
    private String nombreReg;
    private String apellidoReg;
    private String emailReg ;
    private String telefonoReg;
    private String urFilePath;

    public String getUrFilePath() {
        return urFilePath;
    }

    public void setUrFilePath(String urFilePath) {
        this.urFilePath = urFilePath;
    }

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

    public Usuario(String nombreUsuarioReg, String nombreReg, String apellidoReg, String emailReg, String telefonoReg,String urFilePath) {
        this.nombreUsuarioReg = nombreUsuarioReg;
        this.nombreReg = nombreReg;
        this.apellidoReg = apellidoReg;
        this.emailReg = emailReg;
        this.telefonoReg = telefonoReg;
        this.urFilePath = urFilePath;
    }
}
