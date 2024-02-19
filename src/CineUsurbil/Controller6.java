package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Controller6 implements Initializable{

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
    private Label labelDni;
    
    @FXML
    private Label labelContraseña;

    @FXML
    private Label labelLogin;

    @FXML
    void atras(ActionEvent event)throws IOException {
        App.setRoot("vista1");

    }

    @FXML
    void login(ActionEvent event) throws IOException{
        String dniText = dni.getText(); //obtiene la inforamción ingresada en textfield de dni
        String contraseñaText = contraseña.getText(); //obtiene la inforamción ingresada en textfield de contraseña
        
        if (dniText.isEmpty() || contraseñaText.isEmpty()) {
            // Campos vacíos, muestra un mensaje de error.
            Alertas.camposVacios();
            return;
        }
    ClienteDao clienteDao = ConectorBBDD.getClienteDao();

    try {
        Cliente cliente = clienteDao.leerCliente(dniText, contraseñaText);//aquí pasa la información ingresada en los textfield al objeto que hemos creado "cliente" qie se conecta con la BBDD que creamos
                      
        if(cliente==null){
            Alertas.usuarioContraseñaIncorrectos();
        }
        else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista8.fxml"));
            Parent parent = loader.load();
            Controller8 controller = loader.getController();        
            controller.cargarCliente(cliente);
            Scene s = ((Button) event.getSource()).getScene();
            s.setRoot(parent);        
        }

    } catch (SQLException e) {
        e.printStackTrace();
        labelLogin.setText("Error al acceder a la base de datos.");
    } 
}

        @FXML
        public void initialize(URL location, ResourceBundle resources) {
            PauseTransition pause = new PauseTransition(Duration.seconds(0.1));

        pause.setOnFinished(event -> {
        });
        pause.play();
        }

    @FXML
    void registrarse(ActionEvent event) throws IOException{
        App.setRoot("vista7");
    }

}


