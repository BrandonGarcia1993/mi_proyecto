package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras

public class PanelRegistrar extends JPanel{//clase PanelRegistrar con extension a JPanel para crear componentes del panel
    //creacion de atributos de la clase PanelRegistrar globales encapsulados
    private JLabel lblLogo, lblNombre, lblCorreo, lblContrasena, lblFechaNacimiento;
    private JTextField txtNombre, txtCorreo, txtContrasena, txtFechaNacimiento;
    private JButton btnVolver, btnRegistrar;

    public PanelRegistrar(VentanaPrincipal ventana){//el panel registrar tendra como asociasion ventana principal, con palabra clave ventana para acceder a componentes o metodos de Ventana Principal
        setLayout(null);//la edicion de componentes es personalizable

        //INICIALIZAR COMPONENTES
        lblLogo = new JLabel("PLAY LOG!");//label que contiene el nombre de la aplicacion
        lblNombre = new JLabel("Nombre");//label nombre
        txtNombre = new JTextField();//texto nombre
        lblCorreo = new JLabel("Correo");//label correo
        txtCorreo = new JTextField();//texto correo
        lblContrasena = new JLabel("Contraseña");//label contrasena
        txtContrasena = new JTextField();//texto contrasena
        lblFechaNacimiento = new JLabel("Fecha de Nac.");//label fecha de nacimiento
        txtFechaNacimiento = new JTextField();//texto fecha de nacimiento
        btnVolver = new JButton("Volver");//boton volver
        btnRegistrar = new JButton("Registrarme");//boton registrar

        //DIMENSIONES COMPONENTES
        lblLogo.setBounds(270, 150, 320, 50);//dimensiones del label que contiene el nombre de la aplicacion
        lblNombre.setBounds(285, 220, 160, 30);//dimensiones label nombre
        txtNombre.setBounds(365, 220, 160, 30);//dimensiones texto para nombre
        lblCorreo.setBounds(285, 250, 160, 30);//dimensiones label correo
        txtCorreo.setBounds(365, 250, 160, 30);//dimensiones texto correo
        lblContrasena.setBounds(285, 280, 160, 30);//dimensiones label contrasena
        txtContrasena.setBounds(365, 280, 160, 30);//dimensiones texto contrasena
        lblFechaNacimiento.setBounds(285, 310, 160, 30);//dimensiones label fecha de nacimiento
        txtFechaNacimiento.setBounds(365, 310, 160, 30);//dimensiones texto fecha de nacimiento
        btnVolver.setBounds(275, 360, 120, 30);//dimensiones boton aseptar
        btnRegistrar.setBounds(415, 360, 120, 30);//dimensiones boton volver

        //EDICION COMPONENTES
        lblLogo.setFont(new Font("Arial", Font.BOLD,50));//edicion de las letras del nombre del logo

        //FUNCIONES COMPONENTES
        btnVolver.addActionListener(e -> ventana.cambiarPanel("inicio"));//funcion: nos regresara al panel inicio
        btnRegistrar.addActionListener(e -> JOptionPane.showMessageDialog(null, "Confirmado"));//funcion: usara un metodo agregar usuario, que verificara si el nombre es valido o no!

        //AGREGAR COMPONENTES
        add(lblLogo);//agregamos label logo
        add(lblNombre);//agregamos label nombre
        add(txtNombre);//agregamos texto nombre
        add(lblCorreo);//agregamos label correo
        add(txtCorreo);//agregamos texto correo
        add(lblContrasena);//agregamos label contrasena
        add(txtContrasena);//agregamos texto contrasena
        add(lblFechaNacimiento);//agregamos label fecha de nacimiento
        add(txtFechaNacimiento);//agregamos texto fecha de nacimiento
        add(btnVolver);//agregamos boton volver
        add(btnRegistrar);//agregamos boton registrar
    }
}
