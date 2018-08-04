package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.InhabilitacionBE;
import java.util.List;

public interface InhabilitacionDao {

    public List<InhabilitacionBE> obtener(InhabilitacionBE inhabilitacion);

    public int registrar(InhabilitacionBE inhabilitacion);

    public boolean actualizar(InhabilitacionBE inhabilitacion);
}
