package CineUsurbil;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

public class Controller4 {

    private String tituloPelicula;

    @FXML
    private Button botonAtras;

    @FXML
    private Button botonFinalizar;

    @FXML
    private DatePicker fecha;

    @FXML
    private Label fehcaYnomPeli;

    @FXML
    private Text horaYpeliYsalaYprecio;

    @FXML
    private Text horaYpeliYsalaYprecio2;

    @FXML
    private Label nomCineYnomPeli;
    

    public void cargarTituloPelicula(String tituloPelicula) {
        this.tituloPelicula = tituloPelicula;
        System.out.println(tituloPelicula);
    }

    @FXML
    void finalizar(ActionEvent event) throws IOException {
    }

    @FXML
    void atras(ActionEvent event) throws IOException {
        App.setRoot("vista1");
    }

}
