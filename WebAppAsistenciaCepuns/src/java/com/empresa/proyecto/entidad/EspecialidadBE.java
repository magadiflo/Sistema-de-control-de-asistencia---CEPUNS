package com.empresa.proyecto.entidad;

public class EspecialidadBE {

    private int identEspecialidad;
    private String descripcion;
    private String codigo;
    private String facultad;
    private ParametroBE estado;

    public EspecialidadBE() {
        estado = new ParametroBE();
    }
    
    public int getIdentEspecialidad() {
        return identEspecialidad;
    }

    public void setIdentEspecialidad(int identEspecialidad) {
        this.identEspecialidad = identEspecialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ParametroBE getEstado() {
        return estado;
    }

    public void setEstado(ParametroBE estado) {
        this.estado = estado;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }
    
}
