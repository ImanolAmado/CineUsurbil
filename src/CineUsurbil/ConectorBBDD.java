package CineUsurbil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectorBBDD {    
           
    private final String url = "jdbc:mysql://localhost:3306/cineusurbil";
    private final String user = "test";
    private final String pass = "pass"; 

    public Peliculas[] pelicula;

    public Peliculas[] Conectar (String sql) throws SQLException {
        
        Connection conn = DriverManager.getConnection(url, user, pass);
       
        PreparedStatement ps = conn.prepareStatement(sql);
        
        ResultSet rs= ps.executeQuery();

        while (rs.next()){

        // METER EL RESULTADO EN UN ARRAY DE PELICULAS
            System.out.println(rs.getString(1));
        }

        rs.close();
        ps.close();
        conn.close();   

        return pelicula;
    }
}
