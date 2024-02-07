package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalaDao {

// Sentencia SQL
	private static final String
	SALASCINE = "SELECT codSala FROM sala where codCine=";

    // AL CONTRARIO QUE EN EL CASO DE "CINEDAO", AQUÍ ENTIENDO QUE NECESITAMOS
	// PASAR UN PARÁMETRO: "CODCINE".
	// CON "CODCINE" PODREMOS METER EN EL ARRAY DE SALAS ÚNICAMENTE LAS 
	// SALAS QUE CORRESPONDAN A UN CINE EN CONCRETO.
	// UNA VEZ TENGAMOS ESE DATO, PODREMOS MIRAR EN LA TABLA "SALAPELICULA"
	// DE NUESTRA BBDD Y EXTRAER LA INFO SOBRE LAS PELÍCULAS QUE SE VAN A EMITIR

	public Sala[] leerSalas(String codCine) throws SQLException {
		
	// Añadimos a la consulta "codCine" que recibimos de parámetro
		String sql = SALASCINE + "\"" + codCine + "\""; 
		System.out.println(sql);
		Sala[] salas = new Sala[20];
        int i = 0;		
		Connection c = ConectorBBDD.conectar();
		PreparedStatement pstmt = c.prepareStatement(sql);
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()){
            Sala sala = new Sala(rset.getString("codSala"));
			salas[i] = sala;
			System.out.println(salas[i].getCodSala());
            i++;
		}

		pstmt.close();
		c.close();
		return salas;
	}   	
}