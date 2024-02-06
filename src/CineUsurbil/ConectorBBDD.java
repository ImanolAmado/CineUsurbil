package CineUsurbil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectorBBDD {

    final static String url = "jdbc:mysql://localhost:3306/cineusurbil";
    final static String user = "root";
    final static String pass = "Imaite2901?";

    public static Peliculas[] conectar(String sql) throws SQLException {

        Peliculas[] peliculas = null;

        Connection conn = DriverManager.getConnection(url, user, pass);
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            // METER EL RESULTADO EN UN ARRAY DE PELICULAS
            System.out.println(rs.getString("nombre"));
        }

        rs.close();
        ps.close();
        conn.close();

        return peliculas;
    }
}
