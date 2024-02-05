package CineUsurbil;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class Controller2  {
   
    @FXML
    private Button botonFinalizar;

    @FXML
    private ImageView cine1;

    @FXML
    private ImageView cine2;

    @FXML
    private ImageView cine3;
    
 
    @FXML
    void c1(MouseEvent event) throws IOException {
        App.setRoot("vista3", 1);
       
    }

    @FXML
    void c2(MouseEvent event) throws IOException {
        App.setRoot("vista3",2);
       

    }
    @FXML
    void c3(MouseEvent event) throws IOException {
        App.setRoot("vista3",3);
       
    }

    @FXML
    void finalizar(ActionEvent event) throws IOException {       
        App.setRoot("vista1");   
    }

    
}



