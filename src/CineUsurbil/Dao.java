package CineUsurbil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {
    private static String url = "jdbc:mysql://127.0.0.1:3306/";
	private static String database = "cineusurbil";
	private static String user = "test";
	private static String password = "pass";

	public static Connection openConnection() {   
		try {
			Connection connection = DriverManager.getConnection(url + database, user, password);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e){
			e.printStackTrace();
		}
		return null;
	}

	//public static CineDao getCineDao() {
	
	//	return new CineDao();
	//}

	
}