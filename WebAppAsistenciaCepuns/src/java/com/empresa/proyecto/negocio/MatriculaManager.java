/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.negocio;

import com.empresa.proyecto.dao.MatriculaDao;
import com.empresa.proyecto.dao.MatriculaDiasDao;
import com.empresa.proyecto.dao.MatriculaEspecialidadDao;
import com.empresa.proyecto.dao.ProgramacionHorarioDao;
import com.empresa.proyecto.dao.daoImpl.MatriculaDaoImpl;
import com.empresa.proyecto.entidad.MatriculaBE;
import com.empresa.proyecto.entidad.MatriculaDiasBE;
import com.empresa.proyecto.entidad.MatriculaEspecialidadBE;
import com.empresa.proyecto.entidad.ProgramacionHorarioBE;
import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.dao.AsistenciaDao;
import com.empresa.proyecto.dao.daoImpl.MatriculaDiasDaoImpl;
import com.empresa.proyecto.dao.daoImpl.MatriculaEspecialidadDaoImpl;
import com.empresa.proyecto.dao.daoImpl.ProgramacionHorarioDaoImpl;
import com.empresa.proyecto.dao.daoImpl.AsistenciaDaoImpl;
/**
 *
 * @author VICTOR
 */
public class MatriculaManager {
    
    MatriculaDao matriculaDao = null;
    MatriculaDiasDao matriculaDiasDao = null;
    MatriculaEspecialidadDao matriculaEspecialidadDao = null;
    ProgramacionHorarioDao programacionHorarioDao = null;
    AsistenciaDao asistenciaDao = null;
    
    public MatriculaManager(){
        matriculaDao = new MatriculaDaoImpl();
        matriculaDiasDao = new MatriculaDiasDaoImpl();
        matriculaEspecialidadDao = new MatriculaEspecialidadDaoImpl();
        programacionHorarioDao = new ProgramacionHorarioDaoImpl();
        asistenciaDao = new AsistenciaDaoImpl();
    }
    
    public void registrar(MatriculaBE matricula){
        int idMatricula = 0;
        int idMatriculaDia = 0;
        int idMatriculaEspecialidad = 0;
        int idProgramacionHorario = 0;
        int idAsistencia = 0;
        
        
        idMatricula = matriculaDao.registrar(matricula);
        //TODO: VALIDAR ROLLBACK
        
        for(MatriculaDiasBE dias : matricula.getListMatriculaDia()){
            dias.getMatricula().setIdentMatricula(idMatricula);
            idMatriculaDia = matriculaDiasDao.registrar(dias);
            //TODO: VALIDAR ROLLBACK
        }
        
    }
    
    private void asignarFechasMatricula(MatriculaBE matricula){
        int numeroUnidades = matricula.getListProgramacionHorario().size();
        try {
            ProgramacionHorarioBE primeraUnidad = matricula.getListProgramacionHorario().get(0);
            ProgramacionHorarioBE ultimaUnidad = matricula.getListProgramacionHorario().get(numeroUnidades-1);
            matricula.setFechaInicio(primeraUnidad.getFechaInicio());
            matricula.setFechaFin(ultimaUnidad.getFechaFin());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
