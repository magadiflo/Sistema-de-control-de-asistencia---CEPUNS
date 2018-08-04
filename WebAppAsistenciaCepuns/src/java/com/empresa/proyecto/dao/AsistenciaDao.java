package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.AsistenciaBE;
import java.util.List;

public interface AsistenciaDao {

    public List<AsistenciaBE> obtener(AsistenciaBE asistencia);

    public int registrar(AsistenciaBE asistencia);

    public boolean actualizar(AsistenciaBE asistencia);
}
