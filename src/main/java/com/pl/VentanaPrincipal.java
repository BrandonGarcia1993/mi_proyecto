package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para algunos elementos como cardlayout
import java.net.URL;

public class VentanaPrincipal extends JFrame{//clase Ventana principal con extension a JFrame para crear nuestra ventana grafica
    //creacion de atributos de la clase Ventana Principal globales encapsulados
    private JPanel PanelContenedor;
    private CardLayout layout; 
    
    public VentanaPrincipal(){//constructor de la Ventana Principal
        
        super("PlayLog");//titulo de nuestra Ventana Principal
        setSize(800,600);//Dimensiones 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//accion al seleccionar el boton x cerrar
        setLocationRelativeTo(null);//metodo que colocara al centro de la pantalla la Ventana Principal
        setResizable(false);//Metodo para  negar la edicion al usuario de la ventana

        // Fondo oscuro para la ventana
        getContentPane().setBackground(new Color(67, 81, 196));

        // Establecer ícono en la ventana principal
        URL iconURL = getClass().getResource("/recursos/poland.png");//busca el icono en el classpath
        if (iconURL != null) {//si existe, lo agrega a la ventana
            ImageIcon icono = new ImageIcon(iconURL);
            setIconImage(icono.getImage());
        } else {//de lo contrario nos imprimira un error
            System.out.println("❌ No se encontró el ícono de la ventana.");
        }

        layout = new CardLayout();//inicializamos el cardlayout que guardara y organizara los paneles
        PanelContenedor = new JPanel(layout);//creamos el panel general, que tendra el layot para agregar los paneles
        PanelContenedor.setOpaque(false); // ¡Importante! Para ver el fondo del JFrame
        
        
        //CREAMOS Y AGREGAMOS PANELES AL CONETENEDOR
        PanelContenedor.add(new PanelInicio(this),"inicio");//agregamos el panel inicio al panel contenedor
        PanelContenedor.add(new PanelIngresar(this), "ingresar");//agregamos el panel ingreso al panel contenedor
        PanelContenedor.add(new PanelPlayLog(this),"playlog");//agregamos el panel playlog al panel contenedor
        PanelContenedor.add(new PanelRegistrar(this),"registrar");//agregamos el panel registrar al panel contenedor

        //ANADIMOS COMPONENTES A LA VENTANA PRINCIPAL
        add(PanelContenedor);//agregamos el panel contenedor
        layout.show(PanelContenedor, "inicio");//damos la instruccion de que muestre el panel inicio como principal
        setVisible(true);//metodo para hacer visible la ventana
    }

    //METODOS DE LA CLASE VENTANA PRINCIPAL
    public void cambiarPanel(String nombrePanel){//METODO cambiarPanel, recibe un parametro de string nombrePanel, que son los que asignamos a cada panel
        layout.show(PanelContenedor, nombrePanel);//nuestro layout se encargara de cambiar de panel, segun el nombrePanel que asignemos en el momento
    }

}
