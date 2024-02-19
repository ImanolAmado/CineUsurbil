package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

public class Controller7 implements Initializable{

    @FXML
    private AnchorPane Registrarse;
    
    @FXML
    private Button registrarse;

    @FXML
    private Button atras;
   
    @FXML
    private TextField apellidos;   

    @FXML
    private TextField contraseña;

    @FXML
    private TextField dni;

    @FXML
    private TextField email;

    @FXML
    private TextField nombre;

    @FXML
    private TextField sexo;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelApellidos;

    @FXML
    private Label labelDni;

    @FXML
    private Label labelSexo;

    @FXML
    private Label labelContraseña;

    @FXML
    private Label labelEmail;

    
    @FXML
    void registrarse(ActionEvent event)throws IOException {

    }

    @FXML
    void atras(ActionEvent event)throws IOException {

    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
               
        PauseTransition pause = new PauseTransition(Duration.seconds(1));

        pause.setOnFinished(event -> {  
       






    });
    pause.play();
}

}
