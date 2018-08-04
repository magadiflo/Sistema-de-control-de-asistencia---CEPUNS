package com.empresa.proyecto.entidad;

public class UsuarioBE {

    private int identUsuario;
    private PersonaBE identPersona;
    private RolBE identRol;
    private String cuenta;
    private String password;
    private ParametroBE estado;

    public int getIdentUsuario() {
        return identUsuario;
    }

    public void setIdentUsuario(int identUsuario) {
        this.identUsuario = identUsuario;
    }

    public PersonaBE getIdentPersona() {
        return identPersona;
    }

    public void setIdentPersona(PersonaBE identPersona) {
        this.identPersona = identPersona;
    }

    public RolBE getIdentRol() {
        return identRol;
    }

    public void setIdentRol(RolBE identRol) {
        this.identRol = identRol;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ParametroBE getEstado() {
        return estado;
    }

    public void setEstado(ParametroBE estado) {
        this.estado = estado;
    }
    
    
}
