package CineUsurbil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntradasDao {

    private static final String ENTRADA = "INSERT INTO entradas (fechaCompra, precio, dni, codSesion) VALUES " +
    "( ?, ?, ?, ?)";


public void insertarEntradas(Double precioMedio, Date fechaSistema, Cliente cliente) throws SQLException{

    Connection c = ConectorBBDD.conectar();
    PreparedStatement pstmt = c.prepareStatement(ENTRADA);
    
    for (int i= 0; i<Controller5.itemsCarrito; i++) {

    pstmt.setDate(1, fechaSistema);
    pstmt.setDouble(2, precioMedio);
    pstmt.setString(3, cliente.getDni());    
    pstmt.setInt(4, Controller4.carritoCompra[i].getSesion().getCodSesion());

    pstmt.executeUpdate();
        
    }       

    pstmt.close();
    c.close();

}

}