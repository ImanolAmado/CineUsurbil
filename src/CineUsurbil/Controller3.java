package CineUsurbil;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;

public class Controller3 {        
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
    
}
