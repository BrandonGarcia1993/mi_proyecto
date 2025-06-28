package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras

public class PanelInicio extends JPanel{//clase PanelInicio con extension a JPanel para crear componentes del panel

    public PanelInicio(VentanaPrincipal ventana){//el panel inicio tendra como asociasion ventana principal
        setLayout(null);//la edicion de componentes es personalizable

        //COMPONENTES
        JLabel lblLogo = new JLabel("PLAY LOG!");//label que contiene el nombre de la aplicacion
        JButton btnIngresar = new JButton("INGRESAR");//boton ingresar
        JButton btnRegistrar = new JButton("REGISTRAR");//boton registrar

        //EDICION DE COMPONENTES
        lblLogo.setFont(new Font("Arial", Font.BOLD,50));//edicion de las letras del nombre del logo
        lblLogo.setBounds(270, 150, 320, 50);//dimensiones del label que contiene el nombre del logo
        btnIngresar.setBounds(340, 260, 120, 30);//dimensiones de boton ingresar
        btnRegistrar.setBounds(340, 220, 120, 30);//dimensiones de boton registrar

        //FUNCIONES DE BOTONES
        btnIngresar.addActionListener(e ->JOptionPane.showMessageDialog(null, "Inicio exitoso!"));//funsiones de boton inicio
        btnRegistrar.addActionListener(e ->JOptionPane.showMessageDialog(null, "Registro exitoso!"));//funsiones de boton registrar

        //AGREGAR COMPONENTES
        add(lblLogo);//agregamos el label logo
        add(btnIngresar);//agregamos boton ingresar
        add(btnRegistrar);//agregamos boton registrar
    }

}
