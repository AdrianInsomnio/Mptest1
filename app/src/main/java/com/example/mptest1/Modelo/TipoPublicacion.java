package com.example.mptest1.Modelo;

public class TipoPublicacion {
    // codigo de tipo
    private String mCodigoTipoPublicacion;
    // nombre de tipo
    private String mNombreTipo;
    // detalle de tipo
    private String mDetalleTipo;
    // puede ser adopcion extravio o aparicion de mascota

    public TipoPublicacion() {
    }

    public String getmCodigoTipoPublicacion() {
        return mCodigoTipoPublicacion;
    }

    public void setmCodigoTipoPublicacion(String mCodigoTipoPublicacion) {
        this.mCodigoTipoPublicacion = mCodigoTipoPublicacion;
    }

    public String getmNombreTipo() {
        return mNombreTipo;
    }

    public void setmNombreTipo(String mNombreTipo) {
        this.mNombreTipo = mNombreTipo;
    }

    public String getmDetalleTipo() {
        return mDetalleTipo;
    }

    public void setmDetalleTipo(String mDetalleTipo) {
        this.mDetalleTipo = mDetalleTipo;
    }
}
