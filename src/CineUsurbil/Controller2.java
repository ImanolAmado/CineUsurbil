package CineUsurbil;

import java.io.IOException;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Controller2 implements Initializable {

    private Cine[] cines;

    @FXML
    private Button botonFinalizar;

    @FXML
    private ImageView cine1;

    @FXML
    private ImageView cine2;

    @FXML
    private ImageView cine3;

    @FXML
    private Label donostia;

    @FXML
    private Label andoain;

    @FXML
    private Label lasarte;

    @FXML
    void c1(MouseEvent event) throws IOException {

        // Se carga la vista
        // Se lee el controller de la nueva vista
        // Se le pasa el modelo, en este caso el atributo "CodCine" del
        // controlador actual al nuevo
        // Se lee la escena actual
        // Se cambia la vista en la escena actual

        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista3.fxml"));
        Parent parent = loader.load();
        Controller3 controller = loader.getController();
        controller.cargarCodCine(cines[1].getCodCine());
        Scene s = ((ImageView) event.getSource()).getScene();
        s.setRoot(parent);
    }

    @FXML
    void c2(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista3.fxml"));
        Parent parent = loader.load();
        Controller3 controller = loader.getController();        
        controller.cargarCodCine(cines[2].getCodCine());
        Scene s = ((ImageView) event.getSource()).getScene();
        s.setRoot(parent);
    }

    @FXML
    void c3(MouseEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("vista3.fxml"));
        Parent parent = loader.load();
        Controller3 controller = loader.getController();        
        controller.cargarCodCine(cines[0].getCodCine());
        Scene s = ((ImageView) event.getSource()).getScene();
        s.setRoot(parent);
    }

    @FXML
    void finalizar(ActionEvent event) throws IOException {
        App.setRoot("vista1");
    }

    // Método "initialize" es lo primero que se ejecuta siempre en el controller.
    // Creamos una instancia de "CineDao", nos conectamos a la BBDD y a través
    // del método leerCines() obtenemos un array todos nuestros cines.
    // Insertamos los nombres en los "labels" de nuestra vista2. Además, obtenemos
    // el código de los cines para pasarlos al controller3.

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        CineDao cineDao = ConectorBBDD.getCineDao();

        try {
            cines = cineDao.leerCines();
            donostia.setText(cines[1].getNombre());
            andoain.setText(cines[0].getNombre());
            lasarte.setText(cines[2].getNombre());

        } catch (SQLException e) {
            System.out.println("Error! SQL-Exception");
            e.printStackTrace();
        }
    }
}
