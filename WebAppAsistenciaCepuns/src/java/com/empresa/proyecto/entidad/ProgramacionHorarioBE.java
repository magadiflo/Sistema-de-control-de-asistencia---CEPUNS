
package com.empresa.proyecto.entidad;

import java.sql.*;

public class ProgramacionHorarioBE {
    
    private int identProgramacionHorario;
    private MatriculaBE identMatricula;
    private int unidad;
    private ParametroBE estadoUnidad;
    private Date fechaInicio;
    private Date fechaFin;

    public int getIdentProgramacionHorario() {
        return identProgramacionHorario;
    }

    public void setIdentProgramacionHorario(int identProgramacionHorario) {
        this.identProgramacionHorario = identProgramacionHorario;
    }

    public MatriculaBE getIdentMatricula() {
        return identMatricula;
    }

    public void setIdentMatricula(MatriculaBE identMatricula) {
        this.identMatricula = identMatricula;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public ParametroBE getEstadoUnidad() {
        return estadoUnidad;
    }

    public void setEstadoUnidad(ParametroBE estadoUnidad) {
        this.estadoUnidad = estadoUnidad;
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
    
    
}
