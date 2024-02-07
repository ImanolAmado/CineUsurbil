package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.util.Duration;


public class Controller3 implements Initializable {    

// Creamos variable "codCine" y un constructor para asignarle el
// valor que recibimos de "controller2".

    private String codCine;
    private Sala[] salas;

    public void cargarCodCine(String codCine) {
        this.codCine = codCine;
    }

    @FXML
    private Button botonAtras;

    @FXML
    private TableColumn<?, ?> duracion;

    @FXML
    private Label nombreCine;

    @FXML
    private TableColumn<?, ?> pelicula;
   

    @FXML
    void atras(ActionEvent event) throws IOException {
        App.setRoot("vista2");
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

    // Forzamos una pausa de 0.1 segundos para que el valor de "codCine"
    // se actualice antes de que se cargue la vista.

        PauseTransition pause = new PauseTransition(Duration.seconds(0.1));

        pause.setOnFinished(event -> {

            System.out.println(codCine);

            SalaDao salaDao = ConectorBBDD.getSalaDao();

            try {
                salas = salaDao.leerSalas(codCine);
            } catch (SQLException e) {
                System.out.println("Error! Excepción SQL");
                e.printStackTrace();
            }

        });
        pause.play();

    }

}
