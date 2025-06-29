package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras

public class PanelIngresar extends JPanel{//clase PanelIngreso con extension a JPanel para crear componentes del panel
    //creacion de atributos de la clase PanelIngreso globales encapsulados
    private JLabel lblNombre, lblContra, lblLogo;
    private JTextField txtNombre, txtContra;
    private JButton btnIngresar, btnVolver;

    public PanelIngresar(VentanaPrincipal ventana){//el panel ingreso tendra como asociasion ventana principal, con palabra clave ventana para acceder a componentes o metodos de Ventana Principal
        setLayout(null);//la edicion de componentes es personalizable

        //INICIALIZAR COMPONENTES
        lblLogo = new JLabel("PLAY LOG!");//label que contiene el nombre de la aplicacion
        lblNombre = new JLabel("Nombre");//label nombre
        lblContra = new JLabel("Contraseña");//label contra
        txtNombre = new JTextField();//texto para nombre
        txtContra = new JTextField("NO USAR POR AHORA!");//texto para contra
        btnVolver = new JButton("Volver");//boton volver
        btnIngresar = new JButton("Aseptar");//boton ingresar

        //DIMENSIONES COMPONENTES
        lblLogo.setBounds(270, 150, 320, 50);//dimensiones del label que contiene el nombre de la aplicacion
        lblNombre.setBounds(285, 220, 120, 30);//dimensiones label nombre
        lblContra.setBounds(285, 260, 120, 30);//dimensiones label contra
        txtNombre.setBounds(365, 220, 160, 30);//dimensiones texto para nombre
        txtContra.setBounds(365, 260, 160, 30);//dimensiones texto para contra
        btnVolver.setBounds(275, 300, 120, 30);//dimensiones boton volver
        btnIngresar.setBounds(415, 300, 120, 30);//dimensiones boton ingresar

        //EDICION DE COMPONENTES
        lblLogo.setFont(new Font("Arial", Font.BOLD,50));//edicion de las letras del nombre del logo

        //FUNCIONES DE COMPONENTES
        btnVolver.addActionListener(e -> ventana.cambiarPanel("inicio"));//funsion: nos regresara al panel inicio
        btnIngresar.addActionListener(e -> ventana.cambiarPanel("playlog"));//funsion: nos lleva al panel playlog

        //AGREGAR COMPONENTES
        add(lblLogo);//agregamos label logo
        add(lblNombre);//agregamos label nombre
        add(lblContra);//agregamos label contra
        add(txtNombre);//agregamos texto nombre
        add(txtContra);//agregamos texto cotra
        add(btnIngresar);//agregamos boton ingresar
        add(btnVolver);//agregamos boton volver
    }
}
