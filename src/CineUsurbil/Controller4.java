package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ResourceBundle;

import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.scene.image.Image;

public class Controller4 implements Initializable {

    private Peliculas pelicula;
    private String nombreCine;
    private String codCine;
    private Sesion[] sesionesDisponibles;

    @FXML
    private Button botonAtras;

    @FXML
    private Button botonFinalizar;

    @FXML
    private TableColumn<Sesion, Date> fecha;

    @FXML
    private TableColumn<Sesion, Time> hora;

    @FXML
    private TableColumn<Sesion, String> sala;

    @FXML
    private ObservableList<Sesion> tablaObservable;

    @FXML
    private TableView<Sesion> tabla;

    @FXML
    private Label titulo;

    @FXML
    private Label sesiones;

    @FXML
    private Label cine;

    @FXML
    private ImageView imagen;

    public void cargarPelicula(Peliculas pelicula, String nombreCine, String codCine) {
        this.pelicula = pelicula;
        this.nombreCine = nombreCine;
        this.codCine = codCine;

        // Para que la vista tenga tiempo de cargarse, sacamos en
        // pantalla el título y la carátula de la película.

        titulo.setText(pelicula.getTitulo());

        // Para asignar una carátula dinámica a la "ImageView", primero
        // hay crear un objeto "Image" y pasarle la URL

        Image caratulaPelicula = new Image(pelicula.getImagen());

        // Ahora si podemos asignarlo a la ImageView
        imagen.setImage(caratulaPelicula);

        // Asignamos al "label" cine, el nombre del cine.

        cine.setText(nombreCine);

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

        PauseTransition pause = new PauseTransition(Duration.seconds(1));

        pause.setOnFinished(event -> {

            SesionDao sesionDao = ConectorBBDD.getSesionDao();
            try {
                sesionesDisponibles = sesionDao.sesionesDisponibles(pelicula.getCodPelicula(), codCine);
            } catch (SQLException e) {
                System.out.println("Error! Excepción SQL");
                e.printStackTrace();
            }

            for (int i = 0; i < sesionesDisponibles.length; i++) {

                if (sesionesDisponibles[i] != null) {
                    System.out.println(sesionesDisponibles[i].getCodPelicula());
                    System.out.println(sesionesDisponibles[i].getCodCine());
                    System.out.println(sesionesDisponibles[i].getFecha());
                    System.out.println(sesionesDisponibles[i].getHora());
                    System.out.println(sesionesDisponibles[i].getCodSala());
                }
            }

             // Configura las columnas de la tabla
            fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            hora.setCellValueFactory(new PropertyValueFactory<>("hora"));
            sala.setCellValueFactory(new PropertyValueFactory<>("codSala"));

            tablaObservable = FXCollections.observableArrayList();

            // Se añaden las sesiones a la "tablaObservable"
            for (int i = 0; i < sesionesDisponibles.length; i++) {
                if (sesionesDisponibles[i] != null) {
                    tablaObservable.add(sesionesDisponibles[i]);
                }
            }

            // Establece los elementos de la tabla desde la "tablaObservable"
            tabla.setItems(tablaObservable);


        });
        pause.play();

    }

}
