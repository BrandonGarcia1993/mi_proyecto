package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras

public class PanelRegistrar extends JPanel{//clase PanelRegistrar con extension a JPanel para crear componentes del panel
    //creacion de atributos de la clase PanelRegistrar globales encapsulados
    private JLabel lblLogo, lblNombre;
    private JTextField txtNombre;
    private JButton btnVolver, btnRegistrar;

    public PanelRegistrar(VentanaPrincipal ventana){//el panel registrar tendra como asociasion ventana principal, con palabra clave ventana para acceder a componentes o metodos de Ventana Principal
        setLayout(null);//la edicion de componentes es personalizable

        //INICIALIZAR COMPONENTES
        lblLogo = new JLabel("PLAY LOG!");//label que contiene el nombre de la aplicacion
        lblNombre = new JLabel("Nombre");//label nombre
        txtNombre = new JTextField();//texto nombre
        btnVolver = new JButton("Volver");//boton volver
        btnRegistrar = new JButton("Registrarme");//boton registrar

        //DIMENSIONES COMPONENTES
        lblLogo.setBounds(270, 150, 320, 50);//dimensiones del label que contiene el nombre de la aplicacion
        lblNombre.setBounds(285, 220, 120, 30);//dimensiones label nombre
        txtNombre.setBounds(365, 220, 160, 30);//dimensiones texto para nombre
        btnVolver.setBounds(275, 300, 120, 30);//dimensiones boton aseptar
        btnRegistrar.setBounds(415, 300, 120, 30);//dimensiones boton volver

        //EDICION COMPONENTES
        lblLogo.setFont(new Font("Arial", Font.BOLD,50));//edicion de las letras del nombre del logo

        //FUNCIONES COMPONENTES
        btnVolver.addActionListener(e -> ventana.cambiarPanel("inicio"));//funcion: nos regresara al panel inicio
        btnRegistrar.addActionListener(e -> JOptionPane.showMessageDialog(null, "Confirmado"));//funcion: usara un metodo agregar usuario, que verificara si el nombre es valido o no!

        //AGREGAR COMPONENTES
        add(lblLogo);//agregamos label logo
        add(lblNombre);//agregamos label nombre
        add(txtNombre);//agregamos texto nombre
        add(btnVolver);//agregamos boton volver
        add(btnRegistrar);//agregamos boton registrar
    }
}
