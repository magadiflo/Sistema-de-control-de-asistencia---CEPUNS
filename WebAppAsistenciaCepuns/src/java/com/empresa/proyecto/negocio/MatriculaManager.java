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
import com.empresa.proyecto.dao.TurnoDao;
import com.empresa.proyecto.dao.daoImpl.MatriculaDiasDaoImpl;
import com.empresa.proyecto.dao.daoImpl.MatriculaEspecialidadDaoImpl;
import com.empresa.proyecto.dao.daoImpl.ProgramacionHorarioDaoImpl;
import com.empresa.proyecto.dao.daoImpl.AsistenciaDaoImpl;
import com.empresa.proyecto.dao.daoImpl.TurnoDaoImpl;
import com.empresa.proyecto.entidad.ParametroBE;
import com.empresa.proyecto.entidad.TurnoBE;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.constante.ParametroConstante;
import java.util.List;
/**
 *
 * @author VICTOR
 */
public class MatriculaManager {
    
    private MatriculaDao matriculaDao = null;
    private MatriculaDiasDao matriculaDiasDao = null;
    private MatriculaEspecialidadDao matriculaEspecialidadDao = null;
    private ProgramacionHorarioDao programacionHorarioDao = null;
    private AsistenciaDao asistenciaDao = null;
    private TurnoDao turnoDao = null;
    
    public MatriculaManager(){
        matriculaDao = new MatriculaDaoImpl();
        matriculaDiasDao = new MatriculaDiasDaoImpl();
        matriculaEspecialidadDao = new MatriculaEspecialidadDaoImpl();
        programacionHorarioDao = new ProgramacionHorarioDaoImpl();
        asistenciaDao = new AsistenciaDaoImpl();
        turnoDao = new TurnoDaoImpl();
    }
    
    public void registrar(MatriculaBE matricula){
        int idMatricula = 0;
        int idMatriculaDia = 0;
        int idMatriculaEspecialidad = 0;
        int idProgramacionHorario = 0;
        int idAsistencia = 0;
        int idTurno = 0;
        AsistenciaBE asistencia = null;
        
        
        asignarFechasMatricula(matricula);
        matricula.getEstadoMatricula().setIdentParametro(ParametroConstante.ESTADO_ABIERTO);
        
        idMatricula = matriculaDao.registrar(matricula);
        matricula.setIdentMatricula(idMatricula);
        //TODO: VALIDAR ROLLBACK
        
        //Registrar cada dia que se estudiara en el ciclo
        for(MatriculaDiasBE dias : matricula.getListMatriculaDia()){
            dias.getMatricula().setIdentMatricula(idMatricula);
            idMatriculaDia = matriculaDiasDao.registrar(dias);
            dias.setIdentMatriculaDias(idMatriculaDia);
            //TODO: VALIDAR ROLLBACK
        }
        
        //Registrar cada especialidad que se abrira en el ciclo
        for(MatriculaEspecialidadBE especialidad : matricula.getListMatriculaEspecialidad()){
            especialidad.getMatricula().setIdentMatricula(idMatricula);
            idMatriculaEspecialidad = matriculaEspecialidadDao.registrar(especialidad);
            especialidad.setIdentMatriculaEspecialidad(idMatriculaEspecialidad);
            //TODO: VALIDAR ROLLBACK
        }
        
        //Registrar las unidades del ciclo
        for(ProgramacionHorarioBE unidad : matricula.getListProgramacionHorario()){
            unidad.getMatricula().setIdentMatricula(idMatricula);
            unidad.getEstadoUnidad().setIdentParametro(ParametroConstante.ESTADO_ABIERTO);
            idProgramacionHorario = programacionHorarioDao.registrar(unidad);
            unidad.setIdentProgramacionHorario(idProgramacionHorario);
            //TODO: VALIDAR ROLLBACK
        }
        
        //Registrar los turnos 
        for(TurnoBE turno : matricula.getListTurno()){
            turno.getMatricula().setIdentMatricula(idMatricula);
            idTurno = turnoDao.registrar(turno);
            turno.setIdentTurno(idTurno);
            //TODO: VALIDAR ROLLBACK
        }
        
        if(matricula.getNumeroTurnos() == 1 || matricula.isAsignarPrimerTurnoDefecto()){
            for(ProgramacionHorarioBE unidad : matricula.getListProgramacionHorario()){
                asistencia = new AsistenciaBE();
                asistencia.getProgramacionHorario().setIdentProgramacionHorario(unidad.getIdentProgramacionHorario());
                asistencia.getTurno().setIdentTurno(idTurno);
                idAsistencia = new AsistenciaManager().registrarPorFecha(Util.dateToCalendar(matricula.getFechaInicio()), Util.dateToCalendar(matricula.getFechaFin()), asistencia, matricula.obtenerListaDias());
                //TODO: VALIDAR ROLLBACK
            }
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
