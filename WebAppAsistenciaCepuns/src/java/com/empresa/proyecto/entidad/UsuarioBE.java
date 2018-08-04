package com.empresa.proyecto.entidad;

public class UsuarioBE {

    private int identUsuario;
    private PersonaBE persona;
    private RolBE rol;
    private String cuenta;
    private String password;
    private ParametroBE estado;

    public UsuarioBE() {
        persona = new PersonaBE();
        rol = new RolBE();
        estado = new ParametroBE();
    }

    public int getIdentUsuario() {
        return identUsuario;
    }

    public void setIdentUsuario(int identUsuario) {
        this.identUsuario = identUsuario;
    }

    public PersonaBE getPersona() {
        return persona;
    }

    public void setPersona(PersonaBE persona) {
        this.persona = persona;
    }

    public RolBE getRol() {
        return rol;
    }

    public void setRol(RolBE rol) {
        this.rol = rol;
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
