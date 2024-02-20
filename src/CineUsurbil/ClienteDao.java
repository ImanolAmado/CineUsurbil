package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

    private static final String 
    USUPASS = "SELECT nombre, apellido, dni, email FROM cliente WHERE dni=? AND contraseña=?";

    private static final String DNI = "SELECT dni FROM cliente WHERE dni=?";

    private static final String EMAIL = "SELECT email FROM cliente WHERE email=?";

    private static final String INSERTAR = "INSERT INTO cliente (dni, nombre, apellido, sexo, contraseña, email) VALUES " +
    "(?, ?, ?, ?, ?, ?)";


    public Cliente leerCliente(String dni, String contraseña) throws SQLException {
        Cliente cl=null;
        Connection c = ConectorBBDD.conectar();               
        PreparedStatement pstmt = c.prepareStatement(USUPASS);
        pstmt.setString(1, dni);
        pstmt.setString(2, contraseña);
        ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                
            cl = new Cliente(rset.getString("dni"),rset.getString("nombre"),rset.getString("apellido"),rset.getString("email"));   
                
            }  
            pstmt.close();
            c.close();                    
            return cl;
    }


    public boolean buscarDNI (String dni) throws SQLException {

        String dniEncontrado=null;

        Connection c = ConectorBBDD.conectar();
        PreparedStatement pstmt = c.prepareStatement(DNI);
        int contador = 0;

        pstmt.setString(1, dni);
        ResultSet rset = pstmt.executeQuery();

        while (rset.next()) {
            dniEncontrado=rset.getString("dni");           
            contador++;
        }       

        pstmt.close();
        c.close();

        if (dniEncontrado !=null){                 
        return true;
        } else return false;      
        
    }       


    public boolean buscarEmail (String email) throws SQLException {

        String emailEncontrado=null;

        Connection c = ConectorBBDD.conectar();
        PreparedStatement pstmt = c.prepareStatement(EMAIL);
        int contador = 0;

        pstmt.setString(1, email);
        ResultSet rset = pstmt.executeQuery();

        while (rset.next()) {
            emailEncontrado=rset.getString("email");           
            contador++;
        }       

        pstmt.close();
        c.close();
       
        if (emailEncontrado !=null){            
            return true;
            } else return false;     

    }       
    
    
    public void insertarCliente(Cliente nuevoUsuario) throws SQLException {     
        
        Connection c = ConectorBBDD.conectar();
        PreparedStatement pstmt = c.prepareStatement(INSERTAR);        

        pstmt.setString(1, nuevoUsuario.getDni());
        pstmt.setString(2, nuevoUsuario.getNombre());
        pstmt.setString(3, nuevoUsuario.getApellidos());       
        pstmt.setString(4, nuevoUsuario.getSexo());
        pstmt.setString(5, nuevoUsuario.getContraseña());
        pstmt.setString(6, nuevoUsuario.getEmail());

        pstmt.executeUpdate();

        pstmt.close();
        c.close();
    }       

}
