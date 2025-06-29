package com.pl;

import java.time.LocalDate;//libreria para poder usar fechas

public class Usuario {//creamos la clase Usuario, plantilla para crear un usuario
    //creamos los atributos de la clase, con encapsulacion
    private int id;
    private String nombre;
    private String correo;
    private String contrasena;
    private LocalDate fechaNacimiento;

    //CONSTRUCTOR USUARIO
    public Usuario(String nombre, String correo, String contrasena, LocalDate fechaNacimiento){//creamos constructor de la clase usuario, con parametros: nombre
        this.nombre = nombre;//inicializamos nombre
        this.correo = correo;//inicializamos correo
        this.contrasena = contrasena;//inicializamos contrasena
        this.fechaNacimiento = fechaNacimiento;//inicializamos fecha nacimiento
    }

    //METODOS DE LA CLASE USUARIO

    //-------------------------------------------GETTERS Y SETTERS---------------------------------------//
    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getCorreo(){
        return correo;
    }

    public void setContrasena(String contrasena){
        this.contrasena = contrasena;
    }

    public String getContrasena(){
        return contrasena;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }

}
