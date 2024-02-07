package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculaDao {
    private static final String
    PELICULA = "SELECT titulo,duracion,genero FROM pelicula where codpelicula=";

    public Peliculas[] leerPelicula(Peliculas[]peliculas1) throws SQLException{
        Peliculas[] titulo = new Peliculas[100];
        for(int i=0;i<peliculas1.length;i++){
           if (peliculas1[i]!=null){
             String sql = PELICULA +"\""+ peliculas1[i].getCodPelicula()+"\"";             
             int cont = 0;
            Connection c = ConectorBBDD.conectar();
		    PreparedStatement pstmt = c.prepareStatement(sql);
		    ResultSet rset = pstmt.executeQuery();
          
            while(rset.next()){

                Peliculas p= new Peliculas(rset.getString("titulo"),rset.getString("duracion"),rset.getString("genero"));
                titulo[i]= p;
                cont++;                
            }
            pstmt.close();
		c.close();

           }

        }

		return titulo;
    }
}
