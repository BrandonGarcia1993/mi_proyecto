package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras

public class PanelInicio extends JPanel{//clase PanelInicio con extension a JPanel para crear componentes del panel
    //creacion de atributos de la clase PanelInicio globales encapsulados
    private JLabel lblLogo;
    private JButton btnRegistrar, btnIngresar;

    public PanelInicio(VentanaPrincipal ventana){//el panel inicio tendra como asociasion ventana principal, con palabra clave ventana para acceder a componentes o metodos de Ventana Principal
        setLayout(null);//la edicion de componentes es personalizable

        //INICIALIZAR COMPONENTES
        lblLogo = new JLabel("PLAY LOG!");//label que contiene el nombre de la aplicacion
        btnRegistrar = new JButton("REGISTRAR");//boton registrar
        btnIngresar = new JButton("INGRESAR");//boton ingresar

        //DIMENSIONES COMPONENTES
        lblLogo.setBounds(270, 150, 320, 50);//dimensiones del label que contiene el nombre del logo
        btnRegistrar.setBounds(340, 220, 120, 30);//dimensiones de boton registrar
        btnIngresar.setBounds(340, 260, 120, 30);//dimensiones de boton ingresar

        //EDICION COMPONENTES
        lblLogo.setFont(new Font("Arial", Font.BOLD,50));//edicion de las letras del nombre del logo
        
        //FUNCIONES DE BOTONES
        btnIngresar.addActionListener(e -> ventana.cambiarPanel("ingresar"));//funsion: nos llevara a panel ingresar
        btnRegistrar.addActionListener(e -> ventana.cambiarPanel("registrar"));//funsion: nos llevara a panel registro

        //AGREGAR COMPONENTES
        add(lblLogo);//agregamos el label logo
        add(btnIngresar);//agregamos boton ingresar
        add(btnRegistrar);//agregamos boton registrar
    }

}
