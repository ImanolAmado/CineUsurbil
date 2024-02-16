package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SesionDao {    

    private static final String SESIONES = "SELECT codCine, codPelicula, codSala, nombreSala, fecha, hora, precioSesion FROM salapelicula "
    + "NATURAL JOIN sala where codPelicula=? AND CodCine=? ORDER BY fecha";      

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
