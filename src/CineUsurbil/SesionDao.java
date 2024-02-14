package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SesionDao {

    private static final String SALAPELICULA = "SELECT DISTINCT codPelicula FROM salapelicula where codSala =?";

    private static final String SESIONES = "SELECT codCine, codPelicula, codSala, nombreSala, fecha, hora, precioSesion FROM salapelicula "
    + "NATURAL JOIN sala where codPelicula=? AND CodCine=? ORDER BY fecha";

    

    // Lo usamos en el controller 3

    public int[] leerSesion(String[] salas) throws SQLException {
        
    // Declaro el array y lo inicializo con valor por defecto "-1". El "0" no nos vale
    // ya que tenemos un código de película que es "0". No queremos que salga la misma
    // película en la tabla 100 veces.

        int codigoPelicula[] = new int[100];
        for (int i=0; i<codigoPelicula.length;i++){
            codigoPelicula[i]=-1;
        }
        
        Connection c = ConectorBBDD.conectar();
        PreparedStatement pstmt = c.prepareStatement(SALAPELICULA);
        int i = 0;
        int contador = 0;

    // Sustituido el "for" y el "if" por un "do while". Más eficiente
    // ya que no recorre todo el array.

        do {                               
                pstmt.setString(1, salas[i]);
                ResultSet rset = pstmt.executeQuery();

                while (rset.next()) {                    
                    codigoPelicula[contador] = rset.getInt("codPelicula");
                    contador++;
                }     
                i++;
                
            } while (salas[i]!=null);
        
        pstmt.close();
        c.close();
        return codigoPelicula;
    }

    // Lo usamos en el controller 4, buscamos las sesiones disponibles de la
    // película
    // y el cine elegido ordenados por fecha.

    public Sesion[] sesionesDisponibles(int codPelicula, String codCine) throws SQLException {

        Sesion[] sesionesDisponibles = new Sesion[100];

        int contador = 0;
        Connection c = ConectorBBDD.conectar();
        PreparedStatement pstmt = c.prepareStatement(SESIONES);
        pstmt.setInt(1, codPelicula);
        pstmt.setString(2, codCine);
        ResultSet rset = pstmt.executeQuery();

        while (rset.next()) {
            Sesion sesion = new Sesion(rset.getString("codCine"), rset.getInt("codPelicula"),
                    rset.getString("codSala"), rset.getString("nombreSala"),
                    rset.getDate("fecha"), rset.getTime("hora"), rset.getDouble("precioSesion"));
            sesionesDisponibles[contador] = sesion;
            contador++;
        }
        pstmt.close();
        c.close();

        return sesionesDisponibles;
    }
}
