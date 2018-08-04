package com.empresa.proyecto.entidad;

import java.sql.*;

public class MatriculaBE {

    private int IdentMatricula;
    private int Anio;
    private ParametroBE Ciclo;
    private ParametroBE EstadoMatricula;
    private int LimiteFaltasPorcentaje;
    private Date FechaInicio;
    private Date FechaFin;
    private boolean AsignarPrimerTurnoDefecto;
    private ParametroBE Estado;
}
