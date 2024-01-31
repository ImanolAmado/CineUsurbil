package CineUsurbil;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Controller3 {
    
        @FXML
        private Button botonAtras;
    
        @FXML
        private ImageView pelicula1;
    
        @FXML
        private ImageView pelicula2;
    
        @FXML
        private ImageView pelicula3;
    
        @FXML
        private ImageView pelicula4;
    
        @FXML
        private ImageView pelicula5;

        
        @FXML
    void atras(ActionEvent event) throws IOException {
        App.setRoot("vista4");
    }


    
}
