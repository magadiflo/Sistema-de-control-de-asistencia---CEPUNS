package com.empresa.proyecto.entidad;

public class AsistenciaDetalleBE {

    private int identAsistenciaDetalle;
    private AsistenciaBE asistencia;
    private AlumnoBE alumno;
    private ParametroBE estadoAsistencia;
    private String observacion;

    public AsistenciaDetalleBE() {
        asistencia = new AsistenciaBE();
        alumno = new AlumnoBE();
        estadoAsistencia = new ParametroBE();

    }

    public int getIdentAsistenciaDetalle() {
        return identAsistenciaDetalle;
    }

    public void setIdentAsistenciaDetalle(int identAsistenciaDetalle) {
        this.identAsistenciaDetalle = identAsistenciaDetalle;
    }

    public AsistenciaBE getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(AsistenciaBE asistencia) {
        this.asistencia = asistencia;
    }

    public AlumnoBE getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoBE alumno) {
        this.alumno = alumno;
    }

    public ParametroBE getEstadoAsistencia() {
        return estadoAsistencia;
    }

    public void setEstadoAsistencia(ParametroBE estadoAsistencia) {
        this.estadoAsistencia = estadoAsistencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

}
