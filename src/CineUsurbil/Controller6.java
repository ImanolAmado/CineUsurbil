package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class Controller6 implements Initializable {

    @FXML
    private Button atras;   

    @FXML
    private Button login;

    @FXML
    private Button registrarse;    

    @FXML
    private TextField dni;

    @FXML
    private TextField contraseña;

    @FXML
    private Label labelRegistrarse;
    
    @FXML
    private Label labelContraseña;

    @FXML
    private Label labelLogin;

    @FXML
    void atras(MouseEvent event)throws IOException {
        App.setRoot("vista1");

    }

    @FXML
    void login(MouseEvent event) throws IOException{
       
    }


    @FXML
    void registrarse(MouseEvent event) throws IOException{
        App.setRoot("vista7");
    }



    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        /*tengo que hacer un if, donde si el usuario y la contraseña coinciden con la BBDDD podrá ingresar dentro del login, pero si uno de los dos está mal, no dejará entrar, y si no hay nada puesto, tampoco dejará entrar. */
         
        
        PauseTransition pause = new PauseTransition(Duration.seconds(0.1));

        pause.setOnFinished(event -> {  
        //String dni = dni.getText();
        //String contrasena = contraseña.getText();

        //ClienteDao clienteDao = ConectorBBDD.getClienteDao();


    });
    pause.play();
    }

    

   

}



