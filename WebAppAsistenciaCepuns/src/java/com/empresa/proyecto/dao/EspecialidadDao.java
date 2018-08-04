package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.EspecialidadBE;
import java.util.List;

public interface EspecialidadDao {

    public List<EspecialidadBE> obtener(EspecialidadBE especialidad);

    public int registrar(EspecialidadBE especialidad);

    public boolean actualizar(EspecialidadBE especialidad);
}
