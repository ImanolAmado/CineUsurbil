package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Controller6 {

    @FXML
    private Button Atras;

    @FXML
    private TextField Contraseña;

    @FXML
    private TextField DNI;

    @FXML
    private Button butonLog;

    @FXML
    private Button butonRegistrarse;

    @FXML
    void Atras(MouseEvent event) {

    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {
        /*tengo que hacer un if, donde si el usuario y la contraseña coinciden con la BBDDD podrá ingresar dentro del login, pero si uno de los dos está mal, no dejará entrar, y si no hay nada puesto, tampoco dejará entrar. */
        
        String dni = DNI.getText();
        String contrasena = Contraseña.getText();

        //ClienteDao clienteDao = ConectorBBDD.getClienteDao();
    }

    @FXML
    void Registrarse(MouseEvent event) throws IOException{
        App.setRoot("vista7");
    }

    @FXML
    void login(MouseEvent event) throws IOException{
        App.setRoot("vista1");
    }

}



