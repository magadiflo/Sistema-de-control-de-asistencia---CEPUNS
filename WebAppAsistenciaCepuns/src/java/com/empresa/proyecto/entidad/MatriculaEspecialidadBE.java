package com.empresa.proyecto.entidad;

public class MatriculaEspecialidadBE {

    private int identMatriculaEspecialidad;
    private MatriculaBE identMatricula;
    private EspecialidadBE identEspecialidad;

    public int getIdentMatriculaEspecialidad() {
        return identMatriculaEspecialidad;
    }

    public void setIdentMatriculaEspecialidad(int identMatriculaEspecialidad) {
        this.identMatriculaEspecialidad = identMatriculaEspecialidad;
    }

    public MatriculaBE getIdentMatricula() {
        return identMatricula;
    }

    public void setIdentMatricula(MatriculaBE identMatricula) {
        this.identMatricula = identMatricula;
    }

    public EspecialidadBE getIdentEspecialidad() {
        return identEspecialidad;
    }

    public void setIdentEspecialidad(EspecialidadBE identEspecialidad) {
        this.identEspecialidad = identEspecialidad;
    }
    
    
}
