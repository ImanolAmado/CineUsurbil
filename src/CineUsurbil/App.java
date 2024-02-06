package CineUsurbil;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;

// Creamos variable estática int que va a representar el código cine.

    private static int codigoCine;

    @Override
    public void start(Stage stage) throws IOException {      
       
        scene = new Scene(loadFXML("vista1"));
        stage.setTitle("Cine Usurbil");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot (String fxml) throws IOException{
        scene.setRoot(loadFXML(fxml));
       
    }   

// En los "setRoot" de controlador2, al pulsar en la imágen del cine,
// enviamos un int como parámetro correspondiente al código de cine.
// En este método, asignamos el valor que recibimos a la variable privada
// estática que hemos definido un poco más arriba.
// Después, en el controlador3 usaremos el "getter" para acceder a dicha variable.

    static void setRoot (String fxml, int codigoCine) throws IOException{
        scene.setRoot(loadFXML(fxml));
        App.codigoCine = codigoCine;
    }   

// Getter del código cine. En el controlador2 enviamos como parámetro
    public static int getCodigoCine() {
        return codigoCine;
    }

    static void setRoot(Parent fxml) throws IOException {
        scene.setRoot(fxml);
    }   

    private static FXMLLoader FXMLLoader(String fxml){
        return new FXMLLoader(App.class.getResource(fxml + ".fxml"));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader loader = FXMLLoader(fxml);
        Parent parent = loader.load();
        return parent;
    }
   
    public static void main(String[] args) {
        launch(args);
    }
}