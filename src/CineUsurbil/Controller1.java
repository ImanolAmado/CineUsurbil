package CineUsurbil;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Controller1 {

    @FXML
    private AnchorPane pantallaSeguir;

    @FXML
    void cambiarVista(MouseEvent event)throws IOException {
        App.setRoot("vista2");
    }

}
