package CineUsurbil;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller1 {

    private Cine cine;

    @FXML
    private AnchorPane pantallaSeguir;

    @FXML
    void cambiarVista(MouseEvent event)throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("vista2.fxml"));
        // Se carga la vista
        Parent parent = loader.load();
        // Se lee el controller de la nueva vista
        Controller2 controller = loader.getController();
        // Se le pasa el modelo del controlador actual al nuevo
        controller.cargarModelo(cine);
        // Se lee la escena actual
        Scene s = ((AnchorPane) event.getSource()).getScene();
        // Se cambia la vista en la escena actual
        s.setRoot(parent);
        //App.setRoot("vista2");
    }

    void cargarModelo(Cine cargaCine) {
        if (cine == null && cargaCine == null) {
            this.cine = new Cine();
        } else {
            this.cine = cargaCine;
        }
    }
}
