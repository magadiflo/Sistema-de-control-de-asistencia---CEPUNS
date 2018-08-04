package com.empresa.proyecto.entidad;

public class AsistenciaDetalleBE {

    private int identAsistenciaDetalle;
    private AsistenciaBE identAsistencia;
    private AlumnoBE identAlumno;
    private ParametroBE estadoAsistencia;
    private String observacion;

    public int getIdentAsistenciaDetalle() {
        return identAsistenciaDetalle;
    }

    public void setIdentAsistenciaDetalle(int identAsistenciaDetalle) {
        this.identAsistenciaDetalle = identAsistenciaDetalle;
    }

    public AsistenciaBE getIdentAsistencia() {
        return identAsistencia;
    }

    public void setIdentAsistencia(AsistenciaBE identAsistencia) {
        this.identAsistencia = identAsistencia;
    }

    public AlumnoBE getIdentAlumno() {
        return identAlumno;
    }

    public void setIdentAlumno(AlumnoBE identAlumno) {
        this.identAlumno = identAlumno;
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
