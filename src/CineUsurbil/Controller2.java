package CineUsurbil;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller2 {

    private Cine cine;

    @FXML
    private Button botonFinalizar;

    @FXML
    private ImageView cine1;

    @FXML
    private ImageView cine2;

    @FXML
    private ImageView cine3;

    
    @FXML
    private Label nomCine1;

    @FXML
    private Label nomCine2;

    @FXML
    private Label nomCine3;

   

    @FXML
    void finalizar(ActionEvent event) throws IOException {
       /* FXMLLoader loader = new FXMLLoader(getClass().getResource("vista1.fxml"));
        Parent parent = loader.load();
        Controller1 controller = loader.getController();
        controller.cargarModelo(cine);
        Scene s = ((Button) event.getSource()).getScene();
        s.setRoot(parent); */
        App.setRoot("vista1");

    }


    void cargarModelo(Cine cargaCine) {
        if (cine == null && cargaCine == null) {
            this.cine = new Cine();
        } else {
            this.cine = cargaCine;
        }
    }
  

    @FXML
    void c1(MouseEvent event) throws IOException {
        App.setRoot("vista3");
    }
    @FXML
    void c2(MouseEvent event) throws IOException {
        App.setRoot("vista3");
    }
    @FXML
    void c3(MouseEvent event) throws IOException {
        App.setRoot("vista3");
    }

   

}



