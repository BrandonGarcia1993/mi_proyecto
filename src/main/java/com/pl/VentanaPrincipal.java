package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para algunos elementos como cardlayout

public class VentanaPrincipal extends JFrame{//clase Ventana principal con extension a JFrame para crear nuestra ventana grafica
    //creacion de atributos de la clase Ventana Principal globales encapsulados
    private JPanel PanelContenedor;
    private CardLayout layout; 

    private JPanel PanelInicio, PanelIngresar, PanelPlayLog, PanelRegistrar;
    
    public VentanaPrincipal(){//constructor de la Ventana Principal
        super("VENTANA PRINCIPAL");//titulo de nuestra Ventana Principal
        setSize(800,600);//Dimensiones 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//accion al seleccionar el boton x cerrar
        setLocationRelativeTo(null);//metodo que colocara al centro de la pantalla la Ventana Principal
        setResizable(false);//Metodo para  negar la edicion al usuario de la ventana

        layout = new CardLayout();//inicializamos el cardlayout que guardara y organizara los paneles
        PanelContenedor = new JPanel(layout);//creamos el panel general, que tendra el layot para agregar los paneles

        //CREAMOS PANELES
        PanelInicio = new PanelInicio(this);//creamos el panel inicio
        PanelIngresar =  new PanelIngresar(this);//creamos el panel ingresar
        PanelPlayLog = new PanelPlayLog(this);//creamos el panel Play Log
        PanelRegistrar = new PanelRegistrar(this);//creamos el panel registrar

        //AGREGAMOS PANELES AL CONETENEDOR
        PanelContenedor.add(PanelInicio,"inicio");//agregamos el panel inicio al panel contenedor
        PanelContenedor.add(PanelIngresar, "ingresar");//agregamos el panel ingreso al panel contenedor
        PanelContenedor.add(PanelPlayLog,"playlog");//agregamos el panel playlog al panel contenedor
        PanelContenedor.add(PanelRegistrar,"registrar");//agregamos el panel registrar al panel contenedor

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
