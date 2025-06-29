package com.pl;

public class Usuario {//creamos la clase Usuario, plantilla para crear un usuario
    //creamos los atributos de la clase, con encapsulacion
    private String nombre;

    //CONSTRUCTOR USUARIO
    public Usuario(String nombre){//creamos constructor de la clase usuario, con parametros: nombre
        this.nombre = nombre;//inicializamos nombre
    }

    //METODOS DE LA CLASE USUARIO
    public void setNombre(String nombre){//metodo set para insertar el nombre y asi se pueda inicializar
        this.nombre = nombre;
    }

    public String getNombre(){//metodo get para obtener el nombre del usuario
        return nombre;
    }

}
