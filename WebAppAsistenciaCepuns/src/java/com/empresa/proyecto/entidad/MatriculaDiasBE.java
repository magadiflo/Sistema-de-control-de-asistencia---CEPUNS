package com.empresa.proyecto.entidad;

public class MatriculaDiasBE {

    private int identMatriculaDias;
    private MatriculaBE matricula;
    private ParametroBE dia;

    public MatriculaDiasBE() {
        matricula = new MatriculaBE();
        dia = new ParametroBE();
    }

    public int getIdentMatriculaDias() {
        return identMatriculaDias;
    }

    public void setIdentMatriculaDias(int identMatriculaDias) {
        this.identMatriculaDias = identMatriculaDias;
    }

    public MatriculaBE getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaBE matricula) {
        this.matricula = matricula;
    }

    public ParametroBE getDia() {
        return dia;
    }

    public void setDia(ParametroBE dia) {
        this.dia = dia;
    }

}
