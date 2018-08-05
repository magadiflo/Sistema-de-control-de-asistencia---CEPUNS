/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.test;

import com.empresa.proyecto.entidad.MatriculaBE;
import com.empresa.proyecto.entidad.MatriculaDiasBE;
import com.empresa.proyecto.entidad.MatriculaEspecialidadBE;
import com.empresa.proyecto.entidad.ProgramacionHorarioBE;
import com.empresa.proyecto.entidad.TurnoBE;
import com.empresa.proyecto.negocio.MatriculaManager;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.constante.ParametroConstante;

/**
 *
 * @author VICTOR
 */
public class TestMatricula {
    
    public static void test() {
        //Test para aperturar ciclo academico
        MatriculaBE matricula = new MatriculaBE();
        matricula.setAnio(2018);//INGRESADO POR EL USUARIO
        matricula.getCiclo().setIdentParametro(ParametroConstante.CICLO_II); //INGRESADO POR EL USUARIO
        matricula.getEstadoMatricula().setIdentParametro(ParametroConstante.ESTADO_ABIERTO); //POR DEFECTO
        matricula.setLimiteFaltasPorcentaje(30);//INGRESADO POR EL USUARIO
        //Fecha de inicio y fecha fin va en el negocio
        matricula.setAsignarPrimerTurnoDefecto(true); //INGRESADO POR EL USUARIO O POR DEFECTO
        
        //Asignar los dia de lunes a viernes (INGRESADO POR EL USUARIO)
        matricula.addMatriculaDia(new MatriculaDiasBE(ParametroConstante.LUNES));
        matricula.addMatriculaDia(new MatriculaDiasBE(ParametroConstante.MARTES));
        matricula.addMatriculaDia(new MatriculaDiasBE(ParametroConstante.MIERCOLES));
        matricula.addMatriculaDia(new MatriculaDiasBE(ParametroConstante.JUEVES));
        matricula.addMatriculaDia(new MatriculaDiasBE(ParametroConstante.VIERNES));
        
        //Asignar las especialidades
        MatriculaEspecialidadBE matriculaEspecialidad = new MatriculaEspecialidadBE();
        matriculaEspecialidad.getEspecialidad().setIdentEspecialidad(1);
        matricula.addMatriculaEspecialidad(matriculaEspecialidad); //INGRESADO POR EL USUARIO
        
        //PROGRAMAR 3 UNIDADES (INGRESADO POR EL USUARIO)
        ProgramacionHorarioBE unidad1 = new ProgramacionHorarioBE();
        unidad1.setUnidad(1);
        unidad1.setFechaInicio(Util.obtenerDate(10, 9, 2018)); //10 setiembre 2018
        unidad1.setFechaFin(Util.obtenerDate(14, 10, 2018));
        matricula.addProgramacionHorario(unidad1);
        
        ProgramacionHorarioBE unidad2 = new ProgramacionHorarioBE();
        unidad2.setUnidad(2);
        unidad2.setFechaInicio(Util.obtenerDate(15, 10, 2018)); //9 setiembre 2018
        unidad2.setFechaFin(Util.obtenerDate(18, 11, 2018));
        matricula.addProgramacionHorario(unidad2);
        
        ProgramacionHorarioBE unidad3 = new ProgramacionHorarioBE();
        unidad3.setUnidad(3);
        unidad3.setFechaInicio(Util.obtenerDate(19, 11, 2018)); //9 setiembre 2018
        unidad3.setFechaFin(Util.obtenerDate(30, 12, 2018));
        matricula.addProgramacionHorario(unidad3);
        
        //ASIGNAR UN TURNO
        TurnoBE turno = new TurnoBE();
        turno.setHoraInicio("08:00");
        turno.setHoraFin("13:00");
        matricula.addTurno(turno);
        
        //REGISTRAR LA MATRICULA
        MatriculaManager matriculaManager = new MatriculaManager();
        int idMatricula = matriculaManager.registrar(matricula);
        
        
        System.out.println("***********FIN REGISTRO MATRICULA*******");
    }
    
}
