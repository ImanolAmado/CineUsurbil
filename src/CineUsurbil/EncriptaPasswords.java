// Script para encriptar todas las contraseñas
// que tenemos en la BBDD.

package CineUsurbil;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLException;


public class EncriptaPasswords {


    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://18.195.195.238/cineusurbil";
        String user = "test";
        String pass = "AitanaImanolAbde24!";
        String buscar = "SELECT * from cliente";
        String Insertar = "UPDATE cliente SET contraseña=? where dni=?";
        String[] listaContraseñas = new String[30];
        Connection connection;
      
		connection = DriverManager.getConnection(url, user, pass);
							
        int contador =0;
        PreparedStatement pstmt = connection.prepareStatement(buscar);
        PreparedStatement pstmt1 = connection.prepareStatement(Insertar);
        ResultSet rset = pstmt.executeQuery();

        while (rset.next()) {
           listaContraseñas[contador]=rset.getString("contraseña"); 
           listaContraseñas[contador] = Encrypt.encryptPassword(listaContraseñas[contador]);               
           pstmt1.setString(1,listaContraseñas[contador]);
           pstmt1.setString(2,rset.getString("dni"));
           pstmt1.executeUpdate();
           contador++;
        }
       
        pstmt.close();
        connection.close();        
    }
        

    }
