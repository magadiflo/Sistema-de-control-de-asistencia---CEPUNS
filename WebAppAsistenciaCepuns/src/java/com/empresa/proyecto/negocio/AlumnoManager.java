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
import java.util.List;

/**
 *
 * @author VICTOR
 */
public class AlumnoManager {
    
    private AlumnoDao alumnoDao = null;
    private PersonaDao personaDao = null;
    
    public AlumnoManager(){
        //TODO: Factory
        alumnoDao = new AlumnoDaoImpl();
        personaDao = new PersonaDaoImpl();
    }
    
    public List<AlumnoBE> obtener(AlumnoBE alumno){
        return alumnoDao.obtener(alumno);
    }
    
    public int registrar(AlumnoBE alumno){
        int idAlumno = 0;
        
        //Si no tiene registrado sus datos personales
        if(alumno.getPersona().getIdentPersona() == 0){
            alumno.setIdentAlumno(personaDao.registrar(alumno.getPersona()));
        }
        
        idAlumno = alumnoDao.registrar(alumno);
        
        //Validar si hubo algun error en el registro
        if(idAlumno <= 0 || alumno.getPersona().getIdentPersona() <= 0){
            //TODO: ROLLBACK
            return Constante.VALOR_ERROR_TRANSACCION;
        }
        
        return idAlumno;
    }
    
    public int actualizar(AlumnoBE alumno){
        boolean actualizoPersona = personaDao.actualizar(alumno.getPersona());
        boolean actualizoAlumno = alumnoDao.actualizar(alumno);
        
        //Validar si hubo algun error en la actualizacion
        if(!(actualizoPersona && actualizoAlumno)){
            //TODO: ROLLBACK
            return Constante.VALOR_ERROR_TRANSACCION;
        }
        
        return Constante.VALOR_EXITO_TRANSACCION;
    }
    
}
