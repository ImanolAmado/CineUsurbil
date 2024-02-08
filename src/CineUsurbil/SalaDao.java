package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaDao {

// Sentencia SQL
	private static final String
	SALASCINE = "SELECT codSala FROM sala where codCine=";
    
	public Sala[] leerSalas(String codCine) throws SQLException {
		
	// Añadimos a la consulta "codCine" que recibimos de parámetro
		String sql = SALASCINE + "\"" + codCine + "\""; 		
		Sala[] salas = new Sala[20];
        int i = 0;		
		Connection c = ConectorBBDD.conectar();
		PreparedStatement pstmt = c.prepareStatement(sql);
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()){
            Sala sala = new Sala(rset.getString("codSala"));
			salas[i] = sala;			
            i++;
		}

		pstmt.close();
		c.close();
		return salas;
	}   	
}