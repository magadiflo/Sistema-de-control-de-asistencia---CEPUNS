package com.empresa.proyecto.entidad;

public class AlumnoBE {

    private int identAlumno;
    private PersonaBE identPersona;
    private String codigo;
    private MatriculaEspecialidadBE identMatriculaEspecialidad;
    private ParametroBE estadoHabilitado;
    private String apoderado;
    private String telefonoContacto;
    private ParametroBE estado;

    public int getIdentAlumno() {
        return identAlumno;
    }

    public void setIdentAlumno(int identAlumno) {
        this.identAlumno = identAlumno;
    }

    public PersonaBE getIdentPersona() {
        return identPersona;
    }

    public void setIdentPersona(PersonaBE identPersona) {
        this.identPersona = identPersona;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public MatriculaEspecialidadBE getIdentMatriculaEspecialidad() {
        return identMatriculaEspecialidad;
    }

    public void setIdentMatriculaEspecialidad(MatriculaEspecialidadBE identMatriculaEspecialidad) {
        this.identMatriculaEspecialidad = identMatriculaEspecialidad;
    }

    public ParametroBE getEstadoHabilitado() {
        return estadoHabilitado;
    }

    public void setEstadoHabilitado(ParametroBE estadoHabilitado) {
        this.estadoHabilitado = estadoHabilitado;
    }

    public String getApoderado() {
        return apoderado;
    }

    public void setApoderado(String apoderado) {
        this.apoderado = apoderado;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public ParametroBE getEstado() {
        return estado;
    }

    public void setEstado(ParametroBE estado) {
        this.estado = estado;
    }
    
    
}
