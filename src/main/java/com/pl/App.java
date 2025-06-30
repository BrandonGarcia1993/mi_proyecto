package com.pl;

//librerias importantes para usar FLATLAF
import com.formdev.flatlaf.*;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class App 
{
    public static void main( String[] args ){

        //codigo para que usemos el tema FLATLAF dentro de un try_catch
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        //instancia para usar ventana principal
        new VentanaPrincipal();

    }
}
