package CineUsurbil;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class Controller5 implements Initializable {

        // Usaremos estas variables para sumar el precio de las sesiones compradas,
        // para calcular el descuento y para mostrar el importe final a pagar

        public static double facturaTotal=0;
        public static int itemsCarrito=0;
        private double sumaCompra=0;
        private int descuentoTotal=0;    
        private String texto;

        @FXML
        private Button atras;

        @FXML
        private Button vaciar;

        @FXML
        private Button finalizar;

        @FXML
        private TextField contraseña;

        @FXML
        private Label descuento;

        @FXML
        private Label subtotal;

        @FXML
        private Label total;

        @FXML
        private TextField usuario;

        @FXML
        private ListView<String> lista;

        @FXML
        private ObservableList<String> listaObservable;

        @FXML
        void atras(ActionEvent event) throws IOException {
                App.setRoot("vista2");

        }

        @FXML
        void vaciar(ActionEvent event) throws IOException {

                // Sacamos en pantalla alerta antes de vaciar carrito. Si el usuario confirma,
                // borramos carrito y labels.

                if (Alertas.alertaVaciarCarrito()) {

                        // Recorremos todo el array de "CarritoCompra" para eliminar registros.

                        for (int i = 0; i < Controller4.carritoCompra.length; i++) {
                                if (Controller4.carritoCompra[i] != null) {
                                        Controller4.carritoCompra[i] = null;
                                } else
                                        break;
                        }

                        // Vaciamos la lista observable usando el método clear()
                        listaObservable.clear();

                        // Limpiamos el valor de los "labels"
                        String borrar = "";
                        subtotal.setText(borrar);
                        total.setText(borrar);
                        descuento.setText(borrar);
                }
        }

      
        @FXML
        void finalizar(ActionEvent event) throws IOException {

        // Antes de proceder al "checkout", miramos si el carrito está vacío

                if (Controller4.carritoCompra[0]==null){
                        Alertas.alertaCarritoVacio();
                        App.setRoot("vista2");
                } else  App.setRoot("vista6");   
        }
    


        @FXML
        public void initialize(URL location, ResourceBundle resources) {

                PauseTransition pause = new PauseTransition(Duration.seconds(0.1));

                pause.setOnFinished(event -> {

                        // Recorremos el carrito de la compra y convertimos en un String cada registro
                        // usando la función "ToString". Sacamos los datos en la "listView".
                        // Aprovechamos la circunstancia para sumar el total de la compra y sumar
                        // número de registros en el carrito.

                        listaObservable = FXCollections.observableArrayList();

                        for (int i = 0; i < Controller4.carritoCompra.length; i++) {
                                if (Controller4.carritoCompra[i] != null) {
                                sumaCompra = sumaCompra + Controller4.carritoCompra[i].getSesion().getPrecio();
                                descuentoTotal++;
                                listaObservable.add(Controller4.carritoCompra[i].toString());
                                } else break;
                        }

                        lista.setItems(listaObservable);

                        // Sacamos la info en los "labels", teniendo en cuenta que los números hay que
                        // transformarlos primero
                        // en Strings. El descuento máxino que permitimos es del 50%.

                        texto = String.valueOf(sumaCompra) + "€";
                        subtotal.setText(texto);

                        itemsCarrito = descuentoTotal;                       
                        descuentoTotal = descuentoTotal * 10;

                        if (descuentoTotal > 50) {
                                descuentoTotal = 50;
                        }

                        texto = String.valueOf(descuentoTotal) + "%";
                        descuento.setText(texto);

                        facturaTotal = sumaCompra - (sumaCompra * descuentoTotal / 100);
                        texto = String.valueOf(facturaTotal) + "€";
                        total.setText(texto);                   

                });
                pause.play();
        }
}
