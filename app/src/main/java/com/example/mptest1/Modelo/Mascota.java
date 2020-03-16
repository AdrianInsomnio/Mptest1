package com.example.mptest1.Modelo;

public class Mascota {
    //id dueño
    private String mPropietario;
    //nombre
    private  String mNombreMascota;
    //raza
    private String mRazaMascota;
    //color
    private String mColor;
    //edad
    private String FechaNacimiento;

    public Mascota() {
    }

    public Mascota(String mPropietario, String mNombreMascota, String mRazaMascota, String mColor, String fechaNacimiento) {
        this.mPropietario = mPropietario;
        this.mNombreMascota = mNombreMascota;
        this.mRazaMascota = mRazaMascota;
        this.mColor = mColor;
        FechaNacimiento = fechaNacimiento;
    }

    public String getmPropietario() {
        return mPropietario;
    }

    public void setmPropietario(String mPropietario) {
        this.mPropietario = mPropietario;
    }

    public String getmNombreMascota() {
        return mNombreMascota;
    }

    public void setmNombreMascota(String mNombreMascota) {
        this.mNombreMascota = mNombreMascota;
    }

    public String getmRazaMascota() {
        return mRazaMascota;
    }

    public void setmRazaMascota(String mRazaMascota) {
        this.mRazaMascota = mRazaMascota;
    }

    public String getmColor() {
        return mColor;
    }

    public void setmColor(String mColor) {
        this.mColor = mColor;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }
}
