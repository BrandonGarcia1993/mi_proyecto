package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras

public class PanelPlayLog extends JPanel{//clase PanelPlayLog con extension a JPanel para crear componentes del panel
    //creacion de atributos de la clase PanelPlayLog globales encapsulados
    private JLabel lblLogo;
    private JButton btnMiLista, btnVerJuegos, btnCategoria, btnCalificar, btnBuscar;

    public PanelPlayLog(VentanaPrincipal ventana){//el panel playlog tendra como asociasion ventana principal, con palabra clave ventana para acceder a componentes o metodos de Ventana Principal
        setLayout(null);//la edicion de componentes es personalizable

        //INICIALIZAR COMPONENTES
        lblLogo = new JLabel("PLAY LOG!");//label que contiene el nombre de la aplicacion
        btnMiLista = new JButton("Mi Lista Gamer");//boton mi lista gamer
        btnVerJuegos = new JButton("Ver Juegos");//boton ver juegos
        btnCategoria = new JButton("Categorias");//boton categorias
        btnCalificar = new JButton("Calificar");//boton calificar
        btnBuscar = new JButton("Buscar");//boton buscar

        //DIMENSIONES COMPONENTES
        lblLogo.setBounds(270, 50, 320, 50);//dimensiones del label que contiene el nombre de la aplicacion
        btnMiLista.setBounds(50, 120, 140, 30);//dimensiones boton mi lista gamer
        btnVerJuegos.setBounds(185, 120, 140, 30);//dimensiones boton ver juegos
        btnCategoria.setBounds(320,120,140,30);//dimensiones boton categorias
        btnCalificar.setBounds(455, 120, 140, 30);//dimensiones boton calificar
        btnBuscar.setBounds(590,120,140,30);//dimensiones boton buscar

        //EDICION COMPONENTES
        lblLogo.setFont(new Font("Arial", Font.BOLD,50));//edicion de las letras del nombre del logo

        //FUNCIONES COMPONENTES


        //AGREGAR COMPONENTES
        add(lblLogo);//agregamos label de logo
        add(btnMiLista);//agregamos boton mi lista
        add(btnVerJuegos);//agregamos boton ver juegos
        add(btnCategoria);//agregamos boton categoria
        add(btnCalificar);//agregamos boton calificar
        add(btnBuscar);//agregamos boton buscar

    }
}
