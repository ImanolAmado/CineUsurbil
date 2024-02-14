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
import javafx.util.Duration;
import javafx.scene.image.Image;

public class Controller4 implements Initializable {

    private Peliculas pelicula;
    private String nombreCine;   
    private String codCine;
    private Sesion[] sesionesDisponibles;   
    public static Entradas carritoCompra[] = new Entradas[50];

    @FXML
    private Button botonAtras;

    @FXML
    private Button botonAñadir;

    @FXML
    private Button botonFinalizar;

    @FXML
    private TableColumn<Sesion, Date> fecha;

    @FXML
    private TableColumn<Sesion, Time> hora;

    @FXML
    private TableColumn<Sesion, String> sala;

    @FXML
    private TableColumn<Sesion, Double> precio;

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
    void añadir(ActionEvent event) throws IOException {
        // Al hacer "click" en el botón "seleccionar" comprobamos si es "null".
        // en caso de serlo, sacamos alerta. Si la selección es válida, lo asignamos
        // en la variable "seleccion" que es de tipo "Sesion".

        if (tabla.getSelectionModel().getSelectedItem() == null) {
            Alertas.alertaSeleccion();
        } else {

            Sesion seleccion = tabla.getSelectionModel().getSelectedItem();

            // Recorremos nuestro carritoCompra (array de tipo Entradas).
            // Asignamos nuestra selección, que es un Objeto de Sesion, 
            // además del Objeto Película que recibimos como parámetro desde
            // el controller3 y Objeto Cine que montamos con las variables 
            // codCine y nombreCine.

            Cine cine = new Cine(codCine, nombreCine);

            for (int i = 0; i < carritoCompra.length; i++) {
                if (carritoCompra[i] == null) {
                    carritoCompra[i] = new Entradas (cine, seleccion, pelicula);                                  
                    Alertas.alertaInformacionSesion();                    
                    break;
                }
            }      
        }
    }

    @FXML
    void finalizar(ActionEvent event) throws IOException {           
        App.setRoot("vista5");      
    }

    @FXML
    void atras(ActionEvent event) throws IOException {
        App.setRoot("vista2");
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        PauseTransition pause = new PauseTransition(Duration.seconds(0.1));

        pause.setOnFinished(event -> {

            // Buscamos en la base de datos las sesiones que tenemos disponibles teniendo en
            // cuenta
            // el cine (codCine) y la película (codPelicula) que el usuario ha elegido.

            SesionDao sesionDao = ConectorBBDD.getSesionDao();
            try {
                sesionesDisponibles = sesionDao.sesionesDisponibles(pelicula.getCodPelicula(), codCine);
            } catch (SQLException e) {
                System.out.println("Error! Excepción SQL");
                e.printStackTrace();
            }
            
            // Configura las columnas de la tabla
            fecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
            hora.setCellValueFactory(new PropertyValueFactory<>("hora"));
            sala.setCellValueFactory(new PropertyValueFactory<>("NombreSala"));
            precio.setCellValueFactory(new PropertyValueFactory<>("precio"));

            tablaObservable = FXCollections.observableArrayList();

            // Se añaden las sesiones a la "tablaObservable"
            for (int i = 0; i < sesionesDisponibles.length; i++) {
                if (sesionesDisponibles[i] != null) {
                    tablaObservable.add(sesionesDisponibles[i]);
                } else break;
            }

            // Establece los elementos de la tabla desde la "tablaObservable"
            tabla.setItems(tablaObservable);

        });
        pause.play();

    }

}
