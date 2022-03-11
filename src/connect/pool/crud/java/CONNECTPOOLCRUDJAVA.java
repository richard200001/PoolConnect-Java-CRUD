/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect.pool.crud.java;


import controlador.ControladorCliente;
import modelo.ClienteCRUD;
import vista.ClienteVistaGUI;

public class CONNECTPOOLCRUDJAVA {
    public static void main(String[] args) {
        ClienteVistaGUI vista = new ClienteVistaGUI();
        ClienteCRUD modelo = new ClienteCRUD();
        ControladorCliente controlador = new ControladorCliente(vista,modelo);
    }
}
