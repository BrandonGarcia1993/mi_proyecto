package com.pl;

import javax.swing.*;//clase swing para componentes graficos

import com.pl.dao.UsuarioDAO;

import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras

public class PanelIngresar extends JPanel{//clase PanelIngreso con extension a JPanel para crear componentes del panel
    //creacion de atributos de la clase PanelIngreso globales encapsulados
    private JLabel lblNombre, lblContra, lblLogo, lblMaster;
    private JTextField txtNombre, txtContra;
    private JButton btnIngresar, btnVolver;
    private JPanel cortina;

    public PanelIngresar(VentanaPrincipal ventana){//el panel ingreso tendra como asociasion ventana principal, con palabra clave ventana para acceder a componentes o metodos de Ventana Principal
        setLayout(null);//la edicion de componentes es personalizable
        setOpaque(false); // para que el fondo del JFrame se vea

        //creacion de CORTINA
        cortina = new JPanel(null);
        cortina.setBounds(200, 0, 400, 600);// dimensiones de la cortina
        cortina.setBackground(Color.WHITE); // Cortina blanca

        //creacion del logo texto PLAY LOG!
        lblLogo = new JLabel("PLAY LOG!");//label que contiene el nombre de la aplicacio
        lblLogo.setBounds(350, 240, 320, 50);//dimensiones del label que contiene el nombre del logo
        lblLogo.setFont(new Font("Arial", Font.BOLD,20));//edicion de las letras del nombre del logo

        //creacion icono MASTER
        ImageIcon master = new ImageIcon(getClass().getResource("/recursos/logoMaster.png"));
        Image masterEscalada = master.getImage().getScaledInstance(220, 270, Image.SCALE_SMOOTH);
        ImageIcon masterFinal = new ImageIcon(masterEscalada);
        lblMaster = new JLabel(masterFinal);
        lblMaster.setBounds(95,20, 220, 270);

        lblNombre = new JLabel("Nombre");//label nombre
        lblNombre.setBounds(285, 300, 120, 30);//dimensiones label nombre

        txtNombre = new JTextField();//texto para nombre
        txtNombre.setBounds(365, 300, 160, 30);//dimensiones texto para nombre

        lblContra = new JLabel("Contraseña");//label contra
        lblContra.setBounds(285, 340, 120, 30);//dimensiones label contra

        txtContra = new JTextField("NO USAR POR AHORA!");//texto para contra
        txtContra.setBounds(365, 340, 160, 30);//dimensiones texto para contra

        btnVolver = new JButton("Volver");//boton volver
        btnVolver.setBounds(275, 390, 120, 30);//dimensiones boton volver
        btnVolver.setCursor(new Cursor(Cursor.HAND_CURSOR));//el cursor adaptara una forma de mano

        btnIngresar = new JButton("Aceptar");//boton ingresar
        btnIngresar.setBounds(415, 390, 120, 30);//dimensiones boton ingresar
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));//el cursor adaptara una forma de mano    

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
        add(cortina);//agregamos la cortina al panel ingreso
        cortina.add(lblMaster);//agregamos el icono master a la cortina
        }
}
