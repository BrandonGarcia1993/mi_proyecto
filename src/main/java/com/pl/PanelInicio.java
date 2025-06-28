package com.pl;

import javax.swing.*;//clase swing para componentes graficos

public class PanelInicio extends JPanel{//clase PanelInicio con extension a JPanel para crear componentes del panel

    public PanelInicio(VentanaPrincipal ventana){//el panel inicio tendra como asociasion ventana principal
        setLayout(null);//la edicion de componentes es personalizable

        //BOTONES PRINCIPALES
        JButton btnIngresar = new JButton("INGRESAR");//boton ingresar
        JButton btnRegistrar = new JButton("REGISTRAR");//boton registrar

        //EDICION DE BOTONES
        btnIngresar.setBounds(340, 260, 120, 30);//dimensiones de boton ingresar
        btnRegistrar.setBounds(340, 220, 120, 30);//dimensiones de boton registrar

        //FUNCIONES DE BOTONES
        btnIngresar.addActionListener(e ->JOptionPane.showMessageDialog(null, "Inicio exitoso!"));//funsiones de boton inicio
        btnRegistrar.addActionListener(e ->JOptionPane.showMessageDialog(null, "Registro exitoso!"));//funsiones de boton registrar

        //AGREGAR COMPONENTES
        add(btnIngresar);//agregamos boton ingresar
        add(btnRegistrar);//agregamos boton registrar
    }

}
