package com.empresa.proyecto.entidad;

import java.sql.*;

public class MatriculaBE {

    private int identMatricula;
    private int anio;
    private ParametroBE ciclo;
    private ParametroBE estadoMatricula;
    private int limiteFaltasPorcentaje;
    private Date fechaInicio;
    private Date fechaFin;
    private boolean asignarPrimerTurnoDefecto;
    private ParametroBE estado;

    public int getIdentMatricula() {
        return identMatricula;
    }

    public void setIdentMatricula(int identMatricula) {
        this.identMatricula = identMatricula;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public ParametroBE getCiclo() {
        return ciclo;
    }

    public void setCiclo(ParametroBE ciclo) {
        this.ciclo = ciclo;
    }

    public ParametroBE getEstadoMatricula() {
        return estadoMatricula;
    }

    public void setEstadoMatricula(ParametroBE estadoMatricula) {
        this.estadoMatricula = estadoMatricula;
    }

    public int getLimiteFaltasPorcentaje() {
        return limiteFaltasPorcentaje;
    }

    public void setLimiteFaltasPorcentaje(int limiteFaltasPorcentaje) {
        this.limiteFaltasPorcentaje = limiteFaltasPorcentaje;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isAsignarPrimerTurnoDefecto() {
        return asignarPrimerTurnoDefecto;
    }

    public void setAsignarPrimerTurnoDefecto(boolean asignarPrimerTurnoDefecto) {
        this.asignarPrimerTurnoDefecto = asignarPrimerTurnoDefecto;
    }

    public ParametroBE getEstado() {
        return estado;
    }

    public void setEstado(ParametroBE estado) {
        this.estado = estado;
    }
    
    
}
