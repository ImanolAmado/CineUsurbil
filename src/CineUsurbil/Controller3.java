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
    private Sala[] salas;
    private Peliculas[] peliculas1;

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

    // Al hacer "click" en el botón "seleccionar" asignamos la selección
    // en la variable "seleccion" que es de tipo "Pelicula".

        Peliculas seleccion = tabla.getSelectionModel().getSelectedItem();
        System.out.println("Primer print" + seleccion.getTitulo());

    // TODO --> SI EL USUARIO NO SELECCIONA PELICULA Y ACCIONA EL BOTÓN,
    // HAY QUE SACAR UN MENSAJE DE ALERTA.

        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista4.fxml"));
        Parent parent = loader.load();
        Controller4 controller = loader.getController();
    
    // Cogemos únicamente el código de película.
        controller.cargarTituloPelicula(seleccion.getTitulo());
        Scene s = ((Button) event.getSource()).getScene();
        s.setRoot(parent);       
    }

    // Creamos variable "codCine" y un constructor para asignarle el
    // valor que recibimos de "controller2". Llamamos a la base de datos
    // para recoger el nombre del cine para presentarlo en pantalla.

    public void cargarCodCine(String codCine) {
        CineDao cineDao = ConectorBBDD.getCineDao();
        try {
            String nombreCine = cineDao.getNombreCine(codCine);
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
                System.out.println("Error! Excepción SQL");
                e.printStackTrace();
            }
            SesionDao sesionDao = ConectorBBDD.getSesionDao();
            try {
                peliculas1 = sesionDao.leerSesion(salas);
            } catch (SQLException e) {
                System.out.println("Error! Excepción SQL");
                e.printStackTrace();
            }

            PeliculaDao tituloDao = ConectorBBDD.getTituloDao();
            try {
                /* Se sobre escribe */
                peliculas1 = tituloDao.leerPelicula(peliculas1);
            } catch (SQLException e) {
                System.out.println("Error! Excepción SQL");
                e.printStackTrace();
            }

            // Configura las columnas de la tabla
            pelicula.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            genero.setCellValueFactory(new PropertyValueFactory<>("genero"));
            duracion.setCellValueFactory(new PropertyValueFactory<>("duracion"));

            tablaObservable = FXCollections.observableArrayList();

            // Se añaden las películas a la "tablaObservable"
            for (int i = 0; i < peliculas1.length; i++) {
                if (peliculas1[i] != null) {
                    tablaObservable.add(peliculas1[i]);
                }
            }

            // Establece los elementos de la tabla desde la "tablaObservable"
            tabla.setItems(tablaObservable);

        });
        pause.play();
    }
}
