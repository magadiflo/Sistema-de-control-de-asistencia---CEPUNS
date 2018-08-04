package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.EntidadBE;
import java.util.List;

public interface EntidadDao {

    public List<EntidadBE> obtener(EntidadBE entidad);
}
