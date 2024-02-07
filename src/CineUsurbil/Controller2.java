package CineUsurbil;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
        App.setCine(cines[1]);
        App.setRoot("vista3");       
    }

    @FXML
    void c2(MouseEvent event) throws IOException {
        App.setCine(cines[2]);
        App.setRoot("vista3");   

    }

    @FXML
    void c3(MouseEvent event) throws IOException {        
        App.setCine(cines[0]);
        App.setRoot("vista3");       
    }

    @FXML
    void finalizar(ActionEvent event) throws IOException {       
        App.setRoot("vista1");   
    }


   @Override
    public void initialize(URL location, ResourceBundle resources) {
      CineDao cineDao= ConectorBBDD.getCineDao();
      try {
        cines=cineDao.leeTodos();
        donostia.setText(cines[1].getNombre());
        andoain.setText(cines[0].getNombre());
        lasarte.setText(cines[2].getNombre());


    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       
    }
    
}



