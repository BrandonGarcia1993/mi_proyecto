package com.pl.dao;

import java.sql.Connection;//conexion a una base de datos
import java.sql.PreparedStatement;//preparar sentencias SQL parametrizadas, para realizar consultas segurasy eficientes
import java.sql.ResultSet;
import java.sql.SQLException;//excepcion, errores en operaciones de base de datos
import com.pl.Usuario;//importamos clase usuario ya que es quien nos pasara los datos ingresados del usuario

public class UsuarioDAO {

    // Método para insertar un usuario en la base de datos
    public static boolean guardar(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, correo, contrasena, fecha_nacimiento) VALUES (?, ?, ?, ?)";

        try (Connection conn = ConexionBD.obtenerConexion();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getContrasena());
            ps.setDate(4, java.sql.Date.valueOf(usuario.getFechaNacimiento()));

            ps.executeUpdate();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    //metodo para buscar usuario por nombre
    public static Usuario buscarPorNombre(String nombre){
        String sql = "SELECT * FROM usuarios WHERE nombre = ?";

        try (Connection conn = ConexionBD.obtenerConexion(); 
            PreparedStatement ps = conn.prepareStatement(sql)){
            
            ps.setString(1, nombre);
            ResultSet rs  = ps.executeQuery();

            if(rs.next()){
                return new Usuario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("correo"),
                    rs.getString("contrasena"),
                    rs.getDate("fecha_nacimiento").toLocalDate()
                    );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // (Más métodos podrían agregarse luego: buscarPorCorreo, eliminar, actualizar, etc.)
}
