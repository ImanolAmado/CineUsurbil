package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;


public class Controller3 implements Initializable{        
    @FXML
    private Button botonAtras;

    @FXML
    private TableColumn<?, ?> duracion;

    @FXML
    private Label nombreCine;

    @FXML
    private TableColumn<?, ?> pelicula;

    @FXML
    void atras(ActionEvent event) throws IOException{
        App.setRoot("vista2");

    }

   @FXML
   public void initialize(URL location, ResourceBundle resources) {

    Cine cine = App.getCine();
    String codCine = cine.getCodCine();   

    System.out.println(codCine);

    String sql = "select nombre from cine where codCine=\"" + codCine +"\"";
    System.out.println(sql);
    Peliculas[] peliculas = null;

    try {
        peliculas= ConectorBBDD.conectar(sql);
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    }
        
}