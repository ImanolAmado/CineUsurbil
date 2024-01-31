package CineUsurbil;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

public class Controller4 {
    
        @FXML
        private Button botonAtras;
    
        @FXML
        private Button botonFinalizar;

        @FXML
        private Label fehcaYnomPeli;

        @FXML
        private Label horaYpeliYsalaYprecio;

        @FXML
        private Label horaYpeliYsalaYprecio2;

        @FXML
        private Label nomCineYnomPeli;
    
        @FXML
        private DatePicker fecha;
        
        @FXML
        void atras(ActionEvent event) throws IOException {
        App.setRoot("vista1");
    }

    
}
