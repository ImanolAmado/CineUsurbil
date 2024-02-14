package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class Controller3 implements Initializable {

    private String codCine;
    private String[] salas;
    private int [] codigoPelicula;   
    private Peliculas[] peliculas;
    private String nombreCine;

    @FXML
    private Button botonAtras;

    @FXML
    private Button seleccionar;

    @FXML
    private TableColumn<Peliculas, String> duracion;

    @FXML
    private TableColumn<Peliculas, String> genero;

    @FXML
    private Label nomCine;

    @FXML
    private TableColumn<Peliculas, String> pelicula;

    @FXML
    private TableView<Peliculas> tabla;

    @FXML
    private ObservableList<Peliculas> tablaObservable;

   

    @FXML
    void atras(ActionEvent event) throws IOException {
        App.setRoot("vista2");
    }

    @FXML
    void seleccionar(ActionEvent event) throws IOException {

        // Al hacer "click" en el botón "seleccionar" comprobamos si es "null".
        // en caso de serlo, sacamos alerta. Si la selección es válida, lo asignamos
        // en la variable "seleccion" que es de tipo "Peliculas".

        if (tabla.getSelectionModel().getSelectedItem() == null) {
            Alertas.alertaSeleccion();
        } else {

            Peliculas seleccion = tabla.getSelectionModel().getSelectedItem();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista4.fxml"));
            Parent parent = loader.load();
            Controller4 controller = loader.getController();

            // Cogemo todo el objeto película porque en la siguiente vista necesitaremos el título,
            // la imagen y el código de película para buscar sesiones. También enviamos a la siguiente
            // vista el código y el nombre del cine.

            controller.cargarPelicula(seleccion, nombreCine, codCine);
            Scene s = ((Button) event.getSource()).getScene();
            s.setRoot(parent);
        }
    }

    // Creamos variable "codCine" y un constructor para asignarle el
    // valor que recibimos de "controller2". Llamamos a la base de datos
    // para recoger el nombre del cine para presentarlo en pantalla.

    public void cargarCodCine(String codCine) {
        CineDao cineDao = ConectorBBDD.getCineDao();
        try {
            nombreCine = cineDao.getNombreCine(codCine);
            nomCine.setText(nombreCine);
        } catch (SQLException e) {
            System.out.println("Error! Excepción SQL");
            e.printStackTrace();
        }
        this.codCine = codCine;
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        // Forzamos una pausa de 0.1 segundos para que el valor de "codCine"
        // se actualice antes de que se cargue la vista.

        PauseTransition pause = new PauseTransition(Duration.seconds(0.1));

        pause.setOnFinished(event -> {

            // Hacemos las consultas SQL necesarias para extraer el título de las
            // películas que se proyectan en el cine seleccionado.

            SalaDao salaDao = ConectorBBDD.getSalaDao();
            try {
                salas = salaDao.leerSalas(codCine);
            } catch (SQLException e) {
                System.out.println("Error 1! Excepción SQL");
                e.printStackTrace();
            }
            SesionDao sesionDao = ConectorBBDD.getSesionDao();
            try {
                codigoPelicula = sesionDao.leerSesion(salas);
            } catch (SQLException e) {
                System.out.println("Error 2! Excepción SQL");
                e.printStackTrace();
            }
            PeliculaDao tituloDao = ConectorBBDD.getTituloDao();
            try {
                peliculas = tituloDao.leerPelicula(codigoPelicula);
            } catch (SQLException e) {
                System.out.println("Error 3! Excepción SQL");
                e.printStackTrace();
            }

            // Configura las columnas de la tabla
            pelicula.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
            duracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

            tablaObservable = FXCollections.observableArrayList();

            // Se añaden las películas a la "tablaObservable"
            for (int i = 0; i < peliculas.length; i++) {
                if (peliculas[i] != null) {
                    tablaObservable.add(peliculas[i]);
                } else break; // Ahorramos recursos
            }

            // Establece los elementos de la tabla desde la "tablaObservable"
            tabla.setItems(tablaObservable);

        });
        pause.play();
    }
}
