package com.pl.dao;

import java.sql.Connection;//conexion a una base de datos
import java.sql.DriverManager;//gestionar drivers JDBC
import java.sql.SQLException;//excepcion, errores en operaciones de base de datos

public class ConexionBD {
    //damos los datos que necesitaremos para sincronizar la base de datos y pueda realizar la conexion
    private static final String URL = "jdbc:mysql://localhost:3306/aplaylog";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "kino1993";

    public static Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
    }
}
