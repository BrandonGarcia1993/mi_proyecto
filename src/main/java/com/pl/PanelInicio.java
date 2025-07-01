package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras

public class PanelInicio extends JPanel{//clase PanelInicio con extension a JPanel para crear componentes del panel
    //creacion de atributos de la clase PanelInicio globales encapsulados
    private JLabel lblLogo, lblMaster;
    private JButton btnRegistrar, btnIngresar;
    private JPanel cortina;

    public PanelInicio(VentanaPrincipal ventana){//el panel inicio tendra como asociasion ventana principal, con palabra clave ventana para acceder a componentes o metodos de Ventana Principal
        setLayout(null);//la edicion de componentes es personalizable
        setOpaque(false); // para que el fondo del JFrame se vea

        //creacion de CORTINA
        cortina = new JPanel(null);//creamos panel de cortina
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

        //creacion y edicion para BOTON REGISTRAR
        btnRegistrar = new JButton("REGISTRAR");//boton registrar
        btnRegistrar.setBounds(310, 300, 180, 45);//dimensiones de boton registrar
        ImageIcon originalIconR = new ImageIcon(getClass().getResource("/recursos/fingerprint.png"));//guardamos la imagen segun su hubicacion
        Image imagenEscaladaR = originalIconR.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);//escalamos el icono a un tamano mas adecuado
        ImageIcon iconoEscaladoR = new ImageIcon(imagenEscaladaR);//guardamos el nuevo icono ya escalado
        btnRegistrar.setCursor(new Cursor(Cursor.HAND_CURSOR));//el cursor adaptara una forma de mano
        btnRegistrar.setIcon(iconoEscaladoR);//agregamos icono para boton registrar
        btnRegistrar.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del ícono
        btnRegistrar.setIconTextGap(10); // espacio entre ícono y texto

        //creacion y edicion para BOTON INGRESAR
        btnIngresar = new JButton("INGRESAR");//boton ingresar
        btnIngresar.setBounds(310, 370, 180, 45);//dimensiones de boton ingresar
        ImageIcon originalIconI = new ImageIcon(getClass().getResource("/recursos/footprint.png"));//guardamos la imagen segun su hubicacion
        Image imagenEscaladaI = originalIconI.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);//escalamos el icono a un tamano mas adecuado
        ImageIcon iconoEscaladoI = new ImageIcon(imagenEscaladaI);//guardamos el nuevo icono ya escalado
        btnIngresar.setCursor(new Cursor(Cursor.HAND_CURSOR));//el cursor adaptara una forma de mano
        btnIngresar.setIcon(iconoEscaladoI);//agregamos icono para boton registrar
        btnIngresar.setHorizontalTextPosition(SwingConstants.RIGHT); // texto a la derecha del ícono
        btnIngresar.setIconTextGap(10); // espacio entre ícono y texto
        
        //FUNCIONES DE BOTONES
        btnIngresar.addActionListener(e -> ventana.cambiarPanel("ingresar"));//funsion: nos llevara a panel ingresar
        btnRegistrar.addActionListener(e -> ventana.cambiarPanel("registrar"));//funsion: nos llevara a panel registro

        //AGREGAR COMPONENTES  
        add(lblLogo);//agregamos el label logo
        add(btnIngresar);//agregamos boton ingresar
        add(btnRegistrar);//agregamos boton registrar
        add(cortina);//agregamos la cortina al panel inicio
        cortina.add(lblMaster);//agregamos el icono master al panel inicio
    }

}
