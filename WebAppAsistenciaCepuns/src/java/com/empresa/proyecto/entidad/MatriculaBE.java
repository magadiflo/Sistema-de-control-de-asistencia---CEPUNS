package com.empresa.proyecto.entidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    private List<MatriculaDiasBE> listMatriculaDia = null;
    private List<MatriculaEspecialidadBE> listMatriculaEspecialidad = null;
    private List<ProgramacionHorarioBE> listProgramacionHorario = null;
    private List<TurnoBE> listTurno = null;
    
    public MatriculaBE() {
        ciclo = new ParametroBE();
        estadoMatricula = new ParametroBE();
        estado = new ParametroBE();
        listMatriculaDia = new ArrayList<MatriculaDiasBE>();
        listMatriculaEspecialidad = new ArrayList<MatriculaEspecialidadBE>();
        listProgramacionHorario = new ArrayList<ProgramacionHorarioBE>();
        listTurno = new ArrayList<TurnoBE>();
    }

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

    public List<MatriculaDiasBE> getListMatriculaDia() {
        return listMatriculaDia;
    }

    public void setListMatriculaDia(List<MatriculaDiasBE> listMatriculaDia) {
        this.listMatriculaDia = listMatriculaDia;
    }

    public List<MatriculaEspecialidadBE> getListMatriculaEspecialidad() {
        return listMatriculaEspecialidad;
    }

    public void setListMatriculaEspecialidad(List<MatriculaEspecialidadBE> listMatriculaEspecialidad) {
        this.listMatriculaEspecialidad = listMatriculaEspecialidad;
    }

    public List<ProgramacionHorarioBE> getListProgramacionHorario() {
        return listProgramacionHorario;
    }

    public void setListProgramacionHorario(List<ProgramacionHorarioBE> listProgramacionHorario) {
        this.listProgramacionHorario = listProgramacionHorario;
    }
    
    public List<TurnoBE> getListTurno() {
        return listTurno;
    }

    public void setListTurno(List<TurnoBE> listTurno) {
        this.listTurno = listTurno;
    }

    public void addMatriculaDia(MatriculaDiasBE matriculaDia){
        listMatriculaDia.add(matriculaDia);
    }
    
    public void addMatriculaEspecialidad(MatriculaEspecialidadBE matriculaEspecialidad){
        listMatriculaEspecialidad.add(matriculaEspecialidad);
    }
    
    public void addProgramacionHorario(ProgramacionHorarioBE programacionHorario){
        listProgramacionHorario.add(programacionHorario);
    }

    public void addTurno(TurnoBE turno){
        listTurno.add(turno);
    }
    
    public int getNumeroTurnos(){
        return listTurno.size();
    }
    
    public int getIdPrimerTurno(){
        try {
            int idTurno = listTurno.get(0).getIdentTurno();
            return idTurno;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public List<ParametroBE> obtenerListaDias(){
        return listMatriculaDia.stream().map(x -> x.getDia()).collect(Collectors.toList());
    }
    
}
