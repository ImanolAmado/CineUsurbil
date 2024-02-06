package CineUsurbil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CineDao {

	private static final String
	ALL = "SELECT * FROM cine";

    //lee todos lo cines
	public Cine[] leeTodos() throws SQLException {
		Cine[] cines = new Cine[10];
        int i = 0;		
		Connection c = ConectorBBDD.conectar();
		PreparedStatement pstmt = c.prepareStatement(ALL);
		ResultSet rset = pstmt.executeQuery();

		while (rset.next()){
            Cine cine =new Cine(rset.getString("codCine"),rset.getString("nombre"));
			cines[i] = cine;
            i++;
		}

		pstmt.close();
		c.close();
		return cines;
	}
 

}