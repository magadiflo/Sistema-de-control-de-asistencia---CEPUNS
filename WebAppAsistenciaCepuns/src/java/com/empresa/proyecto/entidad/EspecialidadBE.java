package com.empresa.proyecto.entidad;

public class EspecialidadBE {

    private int identEspecialidad;
    private String descripcion;
    private int codigo;
    private ParametroBE estado;

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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ParametroBE getEstado() {
        return estado;
    }

    public void setEstado(ParametroBE estado) {
        this.estado = estado;
    }
    
    
}
