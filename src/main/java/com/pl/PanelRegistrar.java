package com.pl;

import javax.swing.*;//clase swing para componentes graficos
import java.awt.*;//clase para usar ediciones como font en tipo y tamano de letras
import java.time.LocalDate;//clase para guardar formato fecha
//librerias para conectar base de datos
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//librerias para formatos de fecha, dependencia Lgooddatepicker
import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;
import com.pl.dao.ConexionBD;

public class PanelRegistrar extends JPanel{//clase PanelRegistrar con extension a JPanel para crear componentes del panel
    //creacion de atributos de la clase PanelRegistrar globales encapsulados
    private JLabel lblLogo, lblNombre, lblCorreo, lblContrasena, lblFechaNacimiento;
    private JTextField txtNombre, txtCorreo, txtContrasena;
    private DatePicker datePickerNacimiento;
    private JButton btnVolver, btnRegistrar;

    public PanelRegistrar(VentanaPrincipal ventana){//el panel registrar tendra como asociasion ventana principal, con palabra clave ventana para acceder a componentes o metodos de Ventana Principal
        setLayout(null);//la edicion de componentes es personalizable

        //INICIALIZAR COMPONENTES
        lblLogo = new JLabel("PLAY LOG!");//label que contiene el nombre de la aplicacion
        lblNombre = new JLabel("Nombre");//label nombre
        txtNombre = new JTextField();//texto nombre
        lblCorreo = new JLabel("Correo");//label correo
        txtCorreo = new JTextField();//texto correo
        lblContrasena = new JLabel("Contraseña");//label contrasena
        txtContrasena = new JTextField();//texto contrasena
        lblFechaNacimiento = new JLabel("Fecha de Nac.");//label fecha de nacimiento

        //configuracion del datePicker para el estilo del formato de fecha de nacimiento
        DatePickerSettings settings = new DatePickerSettings();
        settings.setFormatForDatesCommonEra("dd/MM/yyyy");
        settings.setAllowEmptyDates(false);
        datePickerNacimiento = new DatePicker(settings);

        btnVolver = new JButton("Volver");//boton volver
        btnRegistrar = new JButton("Registrarme");//boton registrar

        //DIMENSIONES COMPONENTES
        lblLogo.setBounds(270, 150, 320, 50);//dimensiones del label que contiene el nombre de la aplicacion
        lblNombre.setBounds(285, 220, 160, 30);//dimensiones label nombre
        txtNombre.setBounds(365, 220, 160, 30);//dimensiones texto para nombre
        lblCorreo.setBounds(285, 250, 160, 30);//dimensiones label correo
        txtCorreo.setBounds(365, 250, 160, 30);//dimensiones texto correo
        lblContrasena.setBounds(285, 280, 160, 30);//dimensiones label contrasena
        txtContrasena.setBounds(365, 280, 160, 30);//dimensiones texto contrasena
        lblFechaNacimiento.setBounds(285, 310, 160, 30);//dimensiones label fecha de nacimiento
        datePickerNacimiento.setBounds(365, 310, 160, 30);//dimensiones datePicker fecha de nacimiento
        btnVolver.setBounds(275, 360, 120, 30);//dimensiones boton aseptar
        btnRegistrar.setBounds(415, 360, 120, 30);//dimensiones boton volver

        //EDICION COMPONENTES
        lblLogo.setFont(new Font("Arial", Font.BOLD,50));//edicion de las letras del nombre del logo

        //FUNCIONES COMPONENTES
        btnVolver.addActionListener(e -> ventana.cambiarPanel("inicio"));//funcion: nos regresara al panel inicio
        btnRegistrar.addActionListener(e ->{//funcion: agregara los datos solicitados al usuario a la base de datos
            //primero: extraer los datos ingresados por el usuario
            String nombre = txtNombre.getText().trim();
            String correo = txtCorreo.getText().trim();
            String contrasena = txtContrasena.getText().trim();
            LocalDate fechaNacimineto = datePickerNacimiento.getDate();

            //segundo: validar que los campos no esten vacios
            if (nombre.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || fechaNacimineto == null) {
                JOptionPane.showMessageDialog(null, "Por favor complete todos los campos.");
                return;
            }

            //tercero: realizar la consulta a la base de datos, para agregar los datos
            try(Connection conn = ConexionBD.obtenerConexion()) {
                String sql = "INSERT INTO usuarios (nombre, correo, contrasena, fecha_nacimiento) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, nombre);
                ps.setString(2, correo);
                ps.setString(3, contrasena);
                ps.setDate(4, java.sql.Date.valueOf(fechaNacimineto));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Usuario registrado correctamente.");//mensaje de confirmacion, si todo esta bien con la base de datos

                //cuarto: limpiara los campos, para que no se muestre al ingresar de nuevo al panel registro
                txtNombre.setText("");
                txtCorreo.setText("");
                txtContrasena.setText("");
                datePickerNacimiento.clear();

                //quinto: ultimo paso, nos regresara al panel inicio, para que podamos ingresar por medio de los datos ingresados y confirmados
                ventana.cambiarPanel("inicio");

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al registrar usuario: " + ex.getMessage());//en caso que ocurra un error, nos mostrara un mensaje al momento de agregar un usuario
            }
        });

        //AGREGAR COMPONENTES
        add(lblLogo);//agregamos label logo
        add(lblNombre);//agregamos label nombre
        add(txtNombre);//agregamos texto nombre
        add(lblCorreo);//agregamos label correo
        add(txtCorreo);//agregamos texto correo
        add(lblContrasena);//agregamos label contrasena
        add(txtContrasena);//agregamos texto contrasena
        add(lblFechaNacimiento);//agregamos label fecha de nacimiento
        add(datePickerNacimiento);//agregamos datePicker fecha de nacimiento
        add(btnVolver);//agregamos boton volver
        add(btnRegistrar);//agregamos boton registrar
    }
}
