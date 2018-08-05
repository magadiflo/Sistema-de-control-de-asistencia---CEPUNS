package com.empresa.proyecto.entidad;

public class MatriculaEspecialidadBE {

    private int identMatriculaEspecialidad;
    private MatriculaBE matricula;
    private EspecialidadBE especialidad;

    public MatriculaEspecialidadBE() {
        matricula = new MatriculaBE();
        especialidad = new EspecialidadBE();
    }
    
    public MatriculaEspecialidadBE(int idMatriculaEspecialidad){
        matricula = new MatriculaBE();
        especialidad = new EspecialidadBE();
        this.identMatriculaEspecialidad = idMatriculaEspecialidad;
    }

    public int getIdentMatriculaEspecialidad() {
        return identMatriculaEspecialidad;
    }

    public void setIdentMatriculaEspecialidad(int identMatriculaEspecialidad) {
        this.identMatriculaEspecialidad = identMatriculaEspecialidad;
    }

    public MatriculaBE getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaBE matricula) {
        this.matricula = matricula;
    }

    public EspecialidadBE getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(EspecialidadBE especialidad) {
        this.especialidad = especialidad;
    }

}
