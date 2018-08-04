package com.empresa.proyecto.entidad;

public class AlumnoBE {

    private int identAlumno;
    private PersonaBE persona;
    private String codigo;
    private MatriculaEspecialidadBE matriculaEspecialidad;
    private ParametroBE estadoHabilitado;
    private String apoderado;
    private String telefonoContacto;
    private ParametroBE estado;

    public AlumnoBE(){
        persona = new PersonaBE();
        matriculaEspecialidad = new MatriculaEspecialidadBE();
        estadoHabilitado = new ParametroBE();
        estado = new ParametroBE();
    }
    
    public int getIdentAlumno() {
        return identAlumno;
    }

    public void setIdentAlumno(int identAlumno) {
        this.identAlumno = identAlumno;
    }

    public PersonaBE getPersona() {
        return persona;
    }

    public void setPersona(PersonaBE persona) {
        this.persona = persona;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public MatriculaEspecialidadBE getMatriculaEspecialidad() {
        return matriculaEspecialidad;
    }

    public void setMatriculaEspecialidad(MatriculaEspecialidadBE matriculaEspecialidad) {
        this.matriculaEspecialidad = matriculaEspecialidad;
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
