package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SesionDao {

    private static final String
    SALAPELICULA = "SELECT codPelicula FROM salapelicula where codSala =";

    public Peliculas[] leerSesion(Sala[] salas) throws SQLException{
        /*solo queremos crear uno y si lo dejamos en el for crearía uno cada vez que iteramos*/
        Peliculas[] pelicula = new Peliculas[100];
        for(int i = 0; i<salas.length;i++){
            if(salas[i] != null){
        String sql = SALAPELICULA + "\"" + salas[i].getCodSala() + "\"";        
        int cont = 0;
        Connection c = ConectorBBDD.conectar();
		PreparedStatement pstmt = c.prepareStatement(sql);
		ResultSet rset = pstmt.executeQuery();

        while (rset.next()){
            Peliculas peliculas = new Peliculas(rset.getInt("codPelicula"));
            pelicula[i] = peliculas;           
            cont++;
        } 
        pstmt.close();
		c.close();
            }
        }
        return pelicula;
    }
    
}
