package com.empresa.proyecto.entidad;

import java.sql.*;

public class PersonaBE {

    private int identPersona;
    private ParametroTipoBE tipoDocumento;
    private String documento;
    private String nombres;
    private String paterno;
    private String materno;
    private Date fechaNacimiento;
    private String direccion;
    private String telefono;
    private String email;

    public PersonaBE() {
        tipoDocumento = new ParametroTipoBE();
    }         
   
    public int getIdentPersona() {
        return identPersona;
    }

    public void setIdentPersona(int identPersona) {
        this.identPersona = identPersona;
    }

    public ParametroTipoBE getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(ParametroTipoBE tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }
    
    
}
