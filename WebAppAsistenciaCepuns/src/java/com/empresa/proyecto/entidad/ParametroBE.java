package com.empresa.proyecto.entidad;

public class ParametroBE {

    private int identParametro;
    private ParametroTipoBE parametroTipo;
    private String descripcion;

    public int getIdentParametro() {
        return identParametro;
    }

    public void setIdentParametro(int identParametro) {
        this.identParametro = identParametro;
    }

    public ParametroTipoBE getParametroTipo() {
        return parametroTipo;
    }

    public void setParametroTipo(ParametroTipoBE parametroTipo) {
        this.parametroTipo = parametroTipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
