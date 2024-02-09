package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CineDao {

	// Sentencia SQL
	private static final String ALL = "SELECT * FROM cine";
	private static final String SELECTNOMBRE = "SELECT nombre FROM cine where codCine=?";

	// Lee todos los cines de la BBDD y devuelve el nombre de los
	// mismos en un array de Cine. Lo usamos para sacar en pantalla
	// los nombres de los cines en la "vista2".

	public Cine[] leerCines() throws SQLException {
		Cine[] cines = new Cine[10];
		int i = 0;
		Connection c = ConectorBBDD.conectar();
		PreparedStatement pstmt = c.prepareStatement(ALL);
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()) {
			Cine cine = new Cine(rset.getString("codCine"), rset.getString("nombre"));
			cines[i] = cine;
			i++;
		}

		pstmt.close();
		c.close();
		return cines;
	}

	// Recibimos el parámetro codCine y devolvemos el nombre del cine
	// que necesitaremos para el "label" de la vista3.
	
	public String getNombreCine(String codCine) throws SQLException {

		Connection c = ConectorBBDD.conectar();
		PreparedStatement pstmt = c.prepareStatement(SELECTNOMBRE);
		pstmt.setString(1, codCine);
		ResultSet rset = pstmt.executeQuery();
		String nombre="";
		while (rset.next()) {
			nombre=rset.getString("nombre");

		}
		pstmt.close();
		c.close();
		return nombre;
	}
}