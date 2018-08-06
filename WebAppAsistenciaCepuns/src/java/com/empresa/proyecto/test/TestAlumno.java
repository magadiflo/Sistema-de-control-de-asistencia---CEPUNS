/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.test;

import com.empresa.proyecto.entidad.AlumnoBE;
import com.empresa.proyecto.negocio.AlumnoManager;
import com.empresa.proyecto.util.Util;
import com.empresa.proyecto.util.constante.ParametroConstante;

/**
 *
 * @author VICTOR
 */
public class TestAlumno {
    
    public static void test() {
        AlumnoManager alumnoManager = new AlumnoManager();
        int idAlumno = 0;
        int idAlumno2 = 0;
        int idMatriculaEspecialidad = 10;
        //Registrar alumno que ya tiene id dePersona
        AlumnoBE alumno = new AlumnoBE();
        alumno.setCodigo(alumnoManager.generarCodigo(idMatriculaEspecialidad));
        alumno.getPersona().setIdentPersona(4);
        alumno.getMatriculaEspecialidad().setIdentMatriculaEspecialidad(idMatriculaEspecialidad);
        alumno.setApoderado("Juan Robles");
        alumno.setTelefonoContacto("912345678");
        
        idAlumno = alumnoManager.registrar(alumno);
        System.out.println("**************REGISTRO DE ALUMNO 1");
        
        //Registrar alumno que no tiene id de Persona
        AlumnoBE alumno2 = new AlumnoBE();
        alumno2.setCodigo(alumnoManager.generarCodigo(idMatriculaEspecialidad));
        alumno2.getPersona().setIdentPersona(0);
        alumno2.getPersona().getTipoDocumento().setIdentParametroTipo(ParametroConstante.DNI);
        alumno2.getPersona().setDocumento("10203040");
        alumno2.getPersona().setNombres("Fatima ");
        alumno2.getPersona().setPaterno("Lopez");
        alumno2.getPersona().setMaterno("Ramirez");
        alumno2.getPersona().setFechaNacimiento(Util.obtenerDate(10, 12, 1999));
        alumno2.getPersona().setDireccion("Av Peru 123 Chimbote");
        alumno2.getPersona().setTelefono("954123568");
        alumno2.getPersona().setEmail("fatima@gmail.com");
        alumno2.getMatriculaEspecialidad().setIdentMatriculaEspecialidad(idMatriculaEspecialidad);
        alumno2.setApoderado("Joaquin Munoz");
        alumno2.setTelefonoContacto("912345678");
        
        idAlumno2 = alumnoManager.registrar(alumno2);
        
        System.out.println("********REGISTRO DE ALUMNO 2");
    }
    
}
