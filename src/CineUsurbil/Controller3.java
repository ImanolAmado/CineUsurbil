package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;

public class Controller3 implements Initializable {

    // Creamos variable "codCine" y un constructor para asignarle el
    // valor que recibimos de "controller2".

    private String codCine;
    private Sala[] salas;
    private Peliculas[] peliculas1;

    public void cargarCodCine(String codCine) {
        this.codCine = codCine;
    }

    @FXML
    private Button botonAtras;

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
            SesionDao sesionDao = ConectorBBDD.getSesionDao();
            try {
                peliculas1 = sesionDao.leerSesion(salas);
            } catch (SQLException e) {
                System.out.println("Error! Excepción SQL");
                e.printStackTrace();
            }
            PeliculaDao tituloDao = ConectorBBDD.gettituloDao();
            try {
                /* Se sobre escribe */
                peliculas1 = tituloDao.leerPelicula(peliculas1);
            } catch (SQLException e) {
                System.out.println("Error! Excepción SQL");
                e.printStackTrace();
            }

            for(int i=0;i<peliculas1.length;i++){
                if(peliculas1[i]!=null){

                System.out.println(peliculas1[i].gettitulo());
                System.out.println(peliculas1[i].getGenero());
                System.out.println(peliculas1[i].getDuracion());
                }
            }

            tablaObservable = FXCollections.observableArrayList();
            tabla.setItems(tablaObservable);
            
            pelicula.setCellValueFactory(new PropertyValueFactory<>(peliculas1[1].gettitulo()));
            genero.setCellValueFactory(new PropertyValueFactory<>(peliculas1[1].getGenero()));
            duracion.setCellValueFactory(new PropertyValueFactory<>(peliculas1[1].getDuracion()));
                        
            tablaObservable.add(peliculas1[1]);

        });
        pause.play();

    }

}
