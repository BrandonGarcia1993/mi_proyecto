package com.pl.dao;

import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) throws SQLException {
        if (ConexionBD.obtenerConexion() != null) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("Conexión fallida.");
        }
    }
}
