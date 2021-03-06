
package com.empresa.proyecto.entidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramacionHorarioBE {
    
    private int identProgramacionHorario;
    private MatriculaBE matricula;
    private int unidad;
    private ParametroBE estadoUnidad;
    private Date fechaInicio;
    private Date fechaFin;

    private List<AsistenciaBE> listAsistencia = null;
    public ProgramacionHorarioBE() {
        matricula = new MatriculaBE();
        estadoUnidad = new ParametroBE();
        listAsistencia = new ArrayList<AsistenciaBE>();
    }

    public int getIdentProgramacionHorario() {
        return identProgramacionHorario;
    }

    public void setIdentProgramacionHorario(int identProgramacionHorario) {
        this.identProgramacionHorario = identProgramacionHorario;
    }

    public MatriculaBE getMatricula() {
        return matricula;
    }

    public void setMatricula(MatriculaBE matricula) {
        this.matricula = matricula;
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

    public List<AsistenciaBE> getListAsistencia() {
        return listAsistencia;
    }

    public void setListAsistencia(List<AsistenciaBE> listAsistencia) {
        this.listAsistencia = listAsistencia;
    }

    public void addAsistencia(AsistenciaBE asistencia){
        listAsistencia.add(asistencia);
    }
    
}
