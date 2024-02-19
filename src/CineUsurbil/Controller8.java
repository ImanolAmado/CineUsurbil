package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.Duration;

public class Controller8 implements Initializable {

    private Cliente cliente;
    private double precioMedio=0;

// Creamos una variable de tipo Date para capturar
// fecha actual. Le damos formato para que sea más 
// legible en pantalla.
// Además, lo transformamos en el tipo "Date" del paquete SQL
// para insertarlo en la BBDD sin problemas.

    java.sql.Date fechaSistema = new java.sql.Date(new java.util.Date().getTime());
   
    private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
    private String fechaConFormato = formatter.format(fechaSistema);  

    @FXML
    private Button imprimir;

    @FXML
    private Button inicio;

    @FXML
    private Label dniCliente;

    @FXML
    private Label emailCliente;

    @FXML
    private Label nombreEmail;

    @FXML
    private Label nombreCliente;

    @FXML
    private Label totalCompra;

    @FXML
    private Label fecha;
    
    @FXML
    private ListView<String> lista;

    @FXML
    private ObservableList<String> listaObservable;


    @FXML
    void imprimir(ActionEvent event) throws IOException {

    }

    @FXML
    void inicio(ActionEvent event) throws IOException {

        // Recorremos todo el array de "CarritoCompra" para eliminar registros.

        for (int i = 0; i < Controller4.carritoCompra.length; i++) {
            if (Controller4.carritoCompra[i] != null) {
                    Controller4.carritoCompra[i] = null;
            } else
                    break;
    }
        App.setRoot("vista2");

    }

    // En este método hemos recibido el objeto cliente de la vista7

    public void cargarCliente(Cliente nuevoUsuario) {
        this.cliente = nuevoUsuario;

    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        PauseTransition pause = new PauseTransition(Duration.seconds(0.1));

        pause.setOnFinished(event -> {

            dniCliente.setText(cliente.getDni());
            nombreCliente.setText(cliente.getNombre() + " " + cliente.getApellidos());
            nombreEmail.setText(cliente.getEmail());
            fecha.setText(fechaConFormato);           
            totalCompra.setText(String.valueOf(Controller5.facturaTotal));

            // Dividimos factura total por el número de items en el carrito.
            // Actualizamos los precios que tenemos guardados en el carrito para insertarlos
            // en la BBDD.

            precioMedio = Controller5.facturaTotal / Controller5.itemsCarrito;

                for (int i = 0; i < Controller5.itemsCarrito; i++) {                               
                Controller4.carritoCompra[i].getSesion().setPrecio(precioMedio);                                
            }

            // Recorremos el carrito de la compra y convertimos en un String cada registro
            // usando la función "ToString". Sacamos los datos en la "listView".

            listaObservable = FXCollections.observableArrayList();

            for (int i = 0; i < Controller5.itemsCarrito; i++) {                  
                    listaObservable.add(Controller4.carritoCompra[i].toString());               
            }

            lista.setItems(listaObservable);

    
            EntradasDao entradasDao = ConectorBBDD.getEntradasDao();
            try {
                entradasDao.insertarEntradas(precioMedio, fechaSistema, cliente);
            } catch (SQLException e) {
                
                e.printStackTrace();
            }

        });
        pause.play();

    }

}
