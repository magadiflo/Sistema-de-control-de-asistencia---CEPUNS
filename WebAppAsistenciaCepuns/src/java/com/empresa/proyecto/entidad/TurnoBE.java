package com.empresa.proyecto.entidad;

import java.sql.*;

public class TurnoBE {

    private int identTurno;
    private MatriculaBE matricula;
    private Date horaInicio;
    private Date horaFin;

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

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }
    
    
}
