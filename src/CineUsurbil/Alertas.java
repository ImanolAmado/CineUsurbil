package CineUsurbil;

import java.io.IOException;
import java.util.Optional;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class Alertas {

    public static void alertaSeleccion() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Título no seleccionado");
        alert.setContentText("¡Error! Selecciona un título");
        alert.showAndWait();
    }

    public static void alertaInformacionSesion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle("Sesión confirmada");
        alert.setContentText("Sesión correctamente añadida al carrito");
        alert.showAndWait();
    }

    public static void alertaCarritoLleno() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Compra pendiente en el carrito");
        alert.setContentText("¿Deseas completar la compra o borrar carrito y salir? ");

        // Crear los botones personalizados

        ButtonType botonCompletarCompra = new ButtonType("Completar compra");
        ButtonType botonBorrarCarrito = new ButtonType("Borrar y salir");

        // Establecer los botones personalizados en la alerta

        alert.getButtonTypes().setAll(botonCompletarCompra, botonBorrarCarrito);

        // Mostrar la alerta y obtener el resultado
        Optional<ButtonType> resultado = alert.showAndWait();

        // Si el usuario pulsa "Completar compra", le envíamos a la vista5,
        // si no, salimos del programa

        if (resultado.isPresent()) {
            if (resultado.get() == botonCompletarCompra) {
                App.setRoot("vista5");

            } else if (resultado.get() == botonBorrarCarrito) {
                 Platform.exit();
            }
        }
    }

    public static boolean alertaVaciarCarrito() throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("¡Cuidado!");
        alert.setContentText("¿Realmente deseas vaciar el carrito?");
               
        Optional<ButtonType> resultado = alert.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            // El usuario ha pulsado "Aceptar"
            return true;
        }

        return false;       
    }
}