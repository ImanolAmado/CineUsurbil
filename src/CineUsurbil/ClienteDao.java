package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDao {

    private static final String 
    USUPASS = "SELECT dni,contraseña FROM cliente WHERE dni=? AND contraseña=?";

    public Cliente leerCliente(String dni, String contraseña) throws SQLException {
        Cliente cl = new Cliente();
        Connection c = ConectorBBDD.conectar();               
        PreparedStatement pstmt = c.prepareStatement(USUPASS);
        ResultSet rset = pstmt.executeQuery();
        pstmt.setString(1, dni);
        pstmt.setString(2, contraseña);

            while (rset.next()) {
                cl = new Cliente(rset.getString("dni"), rset.getString("contraseña"));   
             
            }  
            pstmt.close();
            c.close();  
            return cl;
    }

}
