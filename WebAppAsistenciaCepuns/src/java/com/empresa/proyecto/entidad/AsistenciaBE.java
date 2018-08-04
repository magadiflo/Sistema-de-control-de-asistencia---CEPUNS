package com.empresa.proyecto.entidad;

import java.sql.*;

public class AsistenciaBE {

    private int identAsistencia;
    private ProgramacionHorarioBE programacionHorario;
    private Date fecha;
    private int numeroSemana;
    private ParametroBE dia;
    private TurnoBE turno;

    public AsistenciaBE() {
        programacionHorario = new ProgramacionHorarioBE();
        dia = new ParametroBE();
        turno = new TurnoBE();
    }

    public int getIdentAsistencia() {
        return identAsistencia;
    }

    public void setIdentAsistencia(int identAsistencia) {
        this.identAsistencia = identAsistencia;
    }

    public ProgramacionHorarioBE getProgramacionHorario() {
        return programacionHorario;
    }

    public void setProgramacionHorario(ProgramacionHorarioBE programacionHorario) {
        this.programacionHorario = programacionHorario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroSemana() {
        return numeroSemana;
    }

    public void setNumeroSemana(int numeroSemana) {
        this.numeroSemana = numeroSemana;
    }

    public ParametroBE getDia() {
        return dia;
    }

    public void setDia(ParametroBE dia) {
        this.dia = dia;
    }

    public TurnoBE getTurno() {
        return turno;
    }

    public void setTurno(TurnoBE turno) {
        this.turno = turno;
    }

    
}
