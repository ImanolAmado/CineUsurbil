package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.image.Image;


public class Controller4 implements Initializable{

    private Peliculas pelicula;

    @FXML
    private Button botonAtras;

    @FXML
    private Button botonFinalizar;
    
    @FXML
    private TableColumn<?, ?> fecha;

    @FXML
    private TableColumn<?, ?> hora;

    @FXML
    private TableColumn<?, ?> sala;

     @FXML
    private ObservableList<Peliculas> tablaObservable;    
    
    @FXML
    private Label titulo;

    @FXML
    private Label sesiones;

     @FXML
    private ImageView imagen;


    public void cargarPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
        
        // Para que la vista tenga tiempo de cargarse, sacamos en
        // pantalla el título y la carátula de la película.

        titulo.setText(pelicula.getTitulo());
        
        // Para asignar una carátula dinámica a la "ImageView", primero
        // hay crear un objeto "Image" y pasarle la URL

        Image caratulaPelicula = new Image(pelicula.getImagen());

        // Ahora si podemos asignarlo a la ImageView
        imagen.setImage(caratulaPelicula);       

    }


    @FXML
    void finalizar(ActionEvent event) throws IOException {
    }

    @FXML
    void atras(ActionEvent event) throws IOException {
        App.setRoot("vista1");
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {



        PauseTransition pause = new PauseTransition(Duration.seconds(0.1));

        pause.setOnFinished(event -> {

           
            
       
        });
        pause.play();

    }


}
