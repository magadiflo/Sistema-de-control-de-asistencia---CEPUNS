package com.empresa.proyecto.entidad;

import java.sql.*;

public class TurnoBE {

    private int identTurno;
    private MatriculaBE matricula;
    private String horaInicio;
    private String horaFin;

    public TurnoBE() {
        matricula = new MatriculaBE();
    }

    public int getIdentTurno() {
        return identTurno;
    }

    public void setIdentTurno(int identTurno) {
        this.identTurno = identTurno;
    }

    public MatriculaBE getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaBE matricula) {
        this.matricula = matricula;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }
    
    
}
