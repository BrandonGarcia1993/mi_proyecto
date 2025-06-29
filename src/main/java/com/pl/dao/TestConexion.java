package com.pl.dao;

import java.sql.SQLException;//excepcion, errores en operaciones de base de datos

public class TestConexion {
    public static void main(String[] args) throws SQLException {
        //validamos la conexion traendo a prueba el metodo obtenerConexion.
        if (ConexionBD.obtenerConexion() != null) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("Conexión fallida.");
        }
    }
}
