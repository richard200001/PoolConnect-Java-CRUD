package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import modelo.Cliente;
import modelo.ClienteCRUD;
import vista.ClienteVistaGUI;

public class ControladorCliente implements ActionListener, ItemListener {
    ClienteVistaGUI vista;
    ClienteCRUD modelo;
    
    public ControladorCliente(ClienteVistaGUI vista,ClienteCRUD modelo){
        this.vista = vista;
        this.modelo = modelo;
        vista.asignarEscuchas(this);
        vista.escuchaCoboBox(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == vista.getbIngresar())
        {
            String no= vista.getNombre();
            long id=Long.parseLong(vista.getcc());
            Cliente unCli= new Cliente(id,no);
            vista.mostrarSalida(modelo.ingresarRegistro(unCli));
        }
        if(ae.getSource() == vista.getbActu())
        {
            String no= vista.getNombre();
            long id=Long.parseLong(vista.getcc());
            Cliente unCli= new Cliente(id,no);
            vista.mostrarSalida(modelo.actualizarRegistro(unCli));
        }
        if(ae.getSource() == vista.getbBorrar())
        {
            long id =Long.parseLong(vista.getcc());
            vista.mostrarSalida(modelo.borrarRegistro(id));
        }
        if(ae.getSource() == vista.getbMostrar())
        {
            vista.borrar();
            List<Cliente> clientes=modelo.mostrarRegistros();
            vista.mostrarCampos(clientes);
        }
        if(ae.getSource() == vista.getBlimpiar())
        {
            vista.borrar();
        }
        if(ae.getSource() == vista.getBfiltro())
        {
           vista.borrar();
           List<Cliente> clientes=modelo.mostrarRegistros();
           vista.filtro(clientes);
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource() == vista.getListaDesplegable()){
            
            String seleccionado=(String)vista.getListaDesplegable().getSelectedItem();
            System.out.println(seleccionado);
            vista.cambiarColorDePanel(vista.getpDatos(), vista.getlCc(), vista.getlNombre(), seleccionado, vista.getBfiltro(), vista.getBlimpiar(),vista.getbActu(),vista.getbBorrar(),vista.getbIngresar(),vista.getbMostrar(),vista.getListaDesplegable());
        }
    }
}
