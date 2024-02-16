package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

    /* private static final String 
    USUPASS = "SELECT dni,contraseña FROM cliente";

    public Cliente[] leerCliente() throws SQLException {
       
        Cliente[] cliente = new Cliente[100];
        Connection c = ConectorBBDD.conectar();               
        PreparedStatement pstmt = c.prepareStatement(USUPASS);
        ResultSet rset = pstmt.executeQuery();

            while (rset.next()) {
                Cliente cl = new Cliente(rset.getString("dni"), rset.getString("contraseña"));      
            }  
            pstmt.close();
            c.close();
            return cliente;  
    }   */ 

    public boolean autenticarCliente(String dni, String contraseña) throws SQLException {
        // Lógica para autenticar al cliente en la base de datos
        Connection c = ConectorBBDD.conectar();
        PreparedStatement pstmt = c.prepareStatement("SELECT * FROM cliente WHERE dni = ? AND contraseña = ?");
        pstmt.setString(1, dni);
        pstmt.setString(2, contraseña);
        ResultSet rset = pstmt.executeQuery();

        boolean autenticado = rset.next(); // Devuelve true si hay resultados, es decir, si el usuario y la contraseña coinciden

        // Cierra recursos
        rset.close();
        pstmt.close();
        c.close();

        return autenticado;
    }
}
