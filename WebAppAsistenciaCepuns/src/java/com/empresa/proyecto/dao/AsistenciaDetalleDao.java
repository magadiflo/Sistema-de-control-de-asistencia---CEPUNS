package com.empresa.proyecto.dao;

import com.empresa.proyecto.entidad.AsistenciaBE;
import com.empresa.proyecto.entidad.AsistenciaDetalleBE;
import java.util.List;

public interface AsistenciaDetalleDao {

    public int registrar(AsistenciaDetalleBE asistenciaDetalle);
    public List<AsistenciaDetalleBE> obtener(AsistenciaBE asistencia);
}
