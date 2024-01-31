package Scenebuilder;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class Controller4 {
    
        @FXML
        private Button botonAtras;
    
        @FXML
        private Button botonFinalizar;
    
        @FXML
        private DatePicker fecha;
        
        @FXML
    void atras(ActionEvent event) throws IOException {
        App.setRoot("vista1");
    }

    
}
