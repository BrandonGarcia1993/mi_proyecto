package com.pl;

import javax.swing.*;//clase swing para componentes graficos

import com.pl.dao.UsuarioDAO;

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
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));//el cursor adaptara una forma de mano
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));//el cursor adaptara una forma de mano

        //FUNCIONES DE COMPONENTES
        btnVolver.addActionListener(e -> ventana.cambiarPanel("inicio"));//funsion: nos regresara al panel inicio

        btnIngresar.addActionListener(e ->{//funcion: revisara si el nombre ingresado ya se encuentra registrado
            String nombre = txtNombre.getText().trim();

            //segundo: validar que los campos no esten vacios
            if(nombre.isEmpty()){
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
                return;
            }

            Usuario usuario = UsuarioDAO.buscarPorNombre(nombre);//traera el usuario segun el nombre a la clase usuario

            if(usuario != null){//si el usuario existe nos mostrara un mensaje de bienvenida y nos enviara al panel play log
                JOptionPane.showMessageDialog(null, "Bienvenido, " + usuario.getNombre() + "!");
                ventana.cambiarPanel("playlog");
            }else{//de no exisrtir nos dira que los datos son incorrectos
                JOptionPane.showMessageDialog(null, "Nombre incorrecto.");
            }
        });

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
