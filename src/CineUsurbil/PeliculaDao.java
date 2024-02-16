package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculaDao {

    private static final String PELICULA = "SELECT DISTINCT codPelicula,titulo,duracion,genero,imagen FROM pelicula " +
            "natural join salapelicula natural join sala " +
            "where codCine=?";

    public Peliculas[] leerPelicula(String codCine) throws SQLException {

        Peliculas[] titulo = new Peliculas[100];
        Connection c = ConectorBBDD.conectar();
        PreparedStatement pstmt = c.prepareStatement(PELICULA);
        int contador = 0;

        pstmt.setString(1, codCine);
        ResultSet rset = pstmt.executeQuery();

        while (rset.next()) {
            Peliculas p = new Peliculas(rset.getString("titulo"), rset.getString("duracion"),
                    rset.getString("genero"), rset.getInt("codPelicula"), rset.getString("imagen"));
            titulo[contador] = p;
            contador++;
        }       

        pstmt.close();
        c.close();
        return titulo;
    }
}
