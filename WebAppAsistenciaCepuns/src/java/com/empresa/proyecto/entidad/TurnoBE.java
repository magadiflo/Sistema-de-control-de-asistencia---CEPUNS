package com.empresa.proyecto.entidad;

import java.sql.*;

public class TurnoBE {

    private int identTurno;
    private MatriculaBE identMatricula;
    private Date horaInicio;
    private Date horaFin;

    public int getIdentTurno() {
        return identTurno;
    }

    public void setIdentTurno(int identTurno) {
        this.identTurno = identTurno;
    }

    public MatriculaBE getIdentMatricula() {
        return identMatricula;
    }

    public void setIdentMatricula(MatriculaBE identMatricula) {
        this.identMatricula = identMatricula;
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
