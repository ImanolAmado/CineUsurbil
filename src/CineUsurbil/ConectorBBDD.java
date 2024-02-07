package CineUsurbil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBBDD {

    final static String url = "jdbc:mysql://localhost:3306/cineusurbil";
    final static String user = "test";
    final static String pass = "pass";

    public static Connection conectar() {
       
        try {
			Connection connection = DriverManager.getConnection(url, user, pass);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
    }


// Getters para los DAO
		
    public static CineDao getCineDao() {
        CineDao cineDao = new CineDao();
		return cineDao;
	}

	public static SalaDao getSalaDao() {
        SalaDao salaDao = new SalaDao();
		return salaDao;
	}

	public static SesionDao getSesionDao() {
        SesionDao sesionDao = new SesionDao();
		return sesionDao;
	}

	public static PeliculaDao getTituloDao() {
        PeliculaDao tituloDao = new PeliculaDao();
		return tituloDao;
	}
	
}
