package com.empresa.proyecto.entidad;

public class InhabilitacionBE {

    private int identInhabilitacion;
    private AlumnoBE identAlumno;
    private ParametroBE razon;
    private String observaciones;
    private ParametroBE estado;

    public int getIdentInhabilitacion() {
        return identInhabilitacion;
    }

    public void setIdentInhabilitacion(int identInhabilitacion) {
        this.identInhabilitacion = identInhabilitacion;
    }

    public AlumnoBE getIdentAlumno() {
        return identAlumno;
    }

    public void setIdentAlumno(AlumnoBE identAlumno) {
        this.identAlumno = identAlumno;
    }

    public ParametroBE getRazon() {
        return razon;
    }

    public void setRazon(ParametroBE razon) {
        this.razon = razon;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ParametroBE getEstado() {
        return estado;
    }

    public void setEstado(ParametroBE estado) {
        this.estado = estado;
    }
    
    
}
