
package com.empresa.proyecto.entidad;

public class PermisoBE {
    
    private int identPermiso;
    private RolBE rol;
    private EntidadBE entidad;

    public PermisoBE() {
        rol = new RolBE();
        entidad = new EntidadBE();
    }

    public int getIdentPermiso() {
        return identPermiso;
    }

    public void setIdentPermiso(int identPermiso) {
        this.identPermiso = identPermiso;
    }

    public RolBE getRol() {
        return rol;
    }

    public void setRol(RolBE rol) {
        this.rol = rol;
    }

    public EntidadBE getEntidad() {
        return entidad;
    }

    public void setEntidad(EntidadBE entidad) {
        this.entidad = entidad;
    }
    
    

    
    
    
    
}
