package CineUsurbil;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller1 {   

    @FXML
    private AnchorPane pantallaSeguir;

    @FXML
    void cambiarVista(MouseEvent event)throws IOException {
        App.setRoot("vista2");          
    }      
}
