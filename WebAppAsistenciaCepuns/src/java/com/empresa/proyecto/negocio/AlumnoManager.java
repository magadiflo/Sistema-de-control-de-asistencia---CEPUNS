/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.empresa.proyecto.negocio;

import com.empresa.proyecto.dao.AlumnoDao;
import com.empresa.proyecto.dao.PersonaDao;
import com.empresa.proyecto.dao.daoImpl.AlumnoDaoImpl;
import com.empresa.proyecto.dao.daoImpl.PersonaDaoImpl;
import com.empresa.proyecto.entidad.AlumnoBE;
import com.empresa.proyecto.util.constante.Constante;

/**
 *
 * @author VICTOR
 */
public class AlumnoManager {
    
    AlumnoDao alumnoDao = null;
    PersonaDao personaDao = null;
    
    public AlumnoManager(){
        //TODO: Factory
        alumnoDao = new AlumnoDaoImpl();
        personaDao = new PersonaDaoImpl();
    }
    
    public int registrar(AlumnoBE alumno){
        int idAlumno = 0;
        
        if(alumno.getPersona().getIdentPersona() == 0){
            alumno.setIdentAlumno(personaDao.registrar(alumno.getPersona()));
        }
        
        idAlumno = alumnoDao.registrar(alumno);
        
        if(idAlumno <= 0 || alumno.getPersona().getIdentPersona() <= 0){
            //TODO: ROLLBACK
            return Constante.VALOR_ERROR_TRANSACCION;
        }
        
        return idAlumno;
    }
    
    public int actualizar(AlumnoBE alumno){
        boolean actualizoPersona = personaDao.actualizar(alumno.getPersona());
        boolean actualizoAlumno = alumnoDao.actualizar(alumno);
        
        if(!(actualizoPersona && actualizoAlumno)){
            //TODO: ROLLBACK
            return Constante.VALOR_ERROR_TRANSACCION;
        }
        
        return Constante.VALOR_EXITO_TRANSACCION;
    }
    
}
