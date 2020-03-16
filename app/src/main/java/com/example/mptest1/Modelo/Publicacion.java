package com.example.mptest1.Modelo;

public class Publicacion {
    // id dueño
    private String mCodigoPropietario;
    private String nNombreProp;
    // id de mascota
    private String mCodigoMascota;
    private String mNombreMascota;
    // fecha
    private String mFechaPublicacion;
    // foto
    private String mfoto;
    // mensaje
    private String mMensajePublicacion;
    // ubicacion
    private String ubicacion;

    private String tipoPublicacion;

    public Publicacion() {
    }

    public Publicacion(String mCodigoPropietario,String mNombreProp, String mCodigoMascota,String mNombrMasco, String mFechaPublicacion, String mfoto, String mMensajePublicacion, String ubicacion ,String mTipoPublicacion) {
        this.mCodigoPropietario = mCodigoPropietario;
        this.nNombreProp = mNombreProp;
        this.mCodigoMascota = mCodigoMascota;
        this .mNombreMascota = mNombrMasco;
        this.mFechaPublicacion = mFechaPublicacion;
        this.mfoto = mfoto;
        this.mMensajePublicacion = mMensajePublicacion;
        this.ubicacion = ubicacion;
        this.tipoPublicacion = mTipoPublicacion;
    }

    public String getnNombreProp() {
        return nNombreProp;
    }

    public void setnNombreProp(String nNombreProp) {
        this.nNombreProp = nNombreProp;
    }

    public String getmNombreMascota() {
        return mNombreMascota;
    }

    public void setmNombreMascota(String mNombreMascota) {
        this.mNombreMascota = mNombreMascota;
    }

    public String getTipoPublicacion() {
        return tipoPublicacion;
    }

    public void setTipoPublicacion(String tipoPublicacion) {
        this.tipoPublicacion = tipoPublicacion;
    }

    public String getmCodigoPropietario() {
        return mCodigoPropietario;
    }

    public void setmCodigoPropietario(String mCodigoPropietario) {
        this.mCodigoPropietario = mCodigoPropietario;
    }

    public String getmCodigoMascota() {
        return mCodigoMascota;
    }

    public void setmCodigoMascota(String mCodigoMascota) {
        this.mCodigoMascota = mCodigoMascota;
    }

    public String getmFechaPublicacion() {
        return mFechaPublicacion;
    }

    public void setmFechaPublicacion(String mFechaPublicacion) {
        this.mFechaPublicacion = mFechaPublicacion;
    }

    public String getMfoto() {
        return mfoto;
    }

    public void setMfoto(String mfoto) {
        this.mfoto = mfoto;
    }

    public String getmMensajePublicacion() {
        return mMensajePublicacion;
    }

    public void setmMensajePublicacion(String mMensajePublicacion) {
        this.mMensajePublicacion = mMensajePublicacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }



}
