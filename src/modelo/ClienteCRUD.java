package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD {
    private PreparedStatement pst;
   
    public ClienteCRUD(){
       Connection connect = null;
    }
       
    public String ingresarRegistro(Cliente unCliente){
        String salida="";
        String sql ="INSERT INTO cliente VALUES(?,?)";
        Connection connect = null;
        try{
                connect = Conexion.getInstance().getConnection();
                pst = connect.prepareStatement(sql);
                pst.setLong(1,unCliente.getId());
                pst.setString(2,unCliente.getNombre());
                int rowsInserted = pst.executeUpdate();
                if ( rowsInserted > 0) {
                    salida="Se ingresó el cliente: "+unCliente.getNombre()+" con exito";
                }
        }catch(SQLException ex){
            salida= "No se puedo ingresar el cliente: "+unCliente.getNombre()+ ex.getMessage();
        }
        return salida;
    }
   
    public List<Cliente> mostrarRegistros(){
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente ORDER BY cc ASC";
        Connection connect = null;
        try{
            connect = Conexion.getInstance().getConnection();
            pst = connect.prepareStatement(sql);
            ResultSet resultado = pst.executeQuery(sql);
            while (resultado.next()){
                long id = resultado.getLong(1);
                String nombre = resultado.getString(2);
                lista.add(new Cliente(id,nombre));
            }
        }catch(SQLException ex)
        {
            System.out.println("No se pudo traer datos: ");
        }
        return lista;
    }
   
    public String actualizarRegistro(Cliente unCliente){
        String salida="";
        String sql ="UPDATE cliente SET nombre=? WHERE cc=?";
        Connection connect = null;
        try{
                connect = Conexion.getInstance().getConnection();
                pst = connect.prepareStatement(sql);
                pst.setString(1,unCliente.getNombre());
                pst.setLong(2,unCliente.getId());
                int rowsInserted = pst.executeUpdate();
                if ( rowsInserted > 0) {
                    salida="Actualización exitosa!";
                }
        }catch(SQLException ex){
            salida="No se puedo actualizar: "+ ex.getMessage();
        }
        return salida;
    }
   
    public String borrarRegistro(long id){
        String salida ="";
        String sql ="DELETE FROM cliente WHERE cc=?";
        Connection connect = null;
        try{
                connect = Conexion.getInstance().getConnection();
                pst = connect.prepareStatement(sql);
                pst.setLong(1,id);
                int rowsInserted = pst.executeUpdate();
                if ( rowsInserted > 0) {
                    salida ="Borrado exitoso!";
                }
        }catch(SQLException ex){
            salida="No se pudo borrar: "+ ex.getMessage();
        }
        return salida;
    }
}


