package CineUsurbil;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    private static Scene scene;
    public static Cine model;

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

    static void setRoot(Parent fxml) throws IOException {
        scene.setRoot(fxml);
    }

    public static Cine getModel(){
        return model;
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