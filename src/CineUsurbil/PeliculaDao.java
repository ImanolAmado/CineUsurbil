package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculaDao {

    private static final String 
    PELICULA = "SELECT codPelicula,titulo,duracion,genero,imagen FROM pelicula where codpelicula=?";

    public Peliculas[] leerPelicula(int[] codigoPelicula) throws SQLException {
       
        Peliculas[] titulo = new Peliculas[100];
        Connection c = ConectorBBDD.conectar();               
        PreparedStatement pstmt = c.prepareStatement(PELICULA);
        int contador =0;

        // Hemos cambiado el ciclo "for" y la condicional "if" por un "do while", que hace
        // lo mismo mucho más eficientemente.

        do {          
                pstmt.setInt(1,codigoPelicula[contador]);
                ResultSet rset = pstmt.executeQuery();

                while (rset.next()) {
                    Peliculas p = new Peliculas(rset.getString("titulo"), rset.getString("duracion"),
                            rset.getString("genero"), rset.getInt("codPelicula"), rset.getString("imagen"));
                    titulo[contador] = p;                   
                }       
                contador++;        
            
        } while (codigoPelicula[contador] !=-1);

        pstmt.close();
        c.close();
        return titulo;
    }
}
