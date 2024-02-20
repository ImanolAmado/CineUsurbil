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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class Controller7 implements Initializable {

    private String nombreCliente = null;
    private String apellidosCliente = null;
    private String dniCliente = null;
    private String emailCliente = null;
    private String sexoCliente = null;
    private String contraseñaCliente = null;    
   
    @FXML
    private AnchorPane Registrarse;

    @FXML
    private Button registrarse;

    @FXML
    private Button atras;

    @FXML
    private TextField apellidos;

    @FXML
    private PasswordField contraseña;

    @FXML
    private TextField dni;

    @FXML
    private TextField email;

    @FXML
    private TextField email2;

    @FXML
    private TextField nombre;

    @FXML
    private ComboBox<String> lista;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelApellidos;

    @FXML
    private Label labelDni;

    @FXML
    private Label labelSexo;

    @FXML
    private Label labelContraseña;

    @FXML
    private Label labelEmail;      
      
    
    // Al registrarnos y pulsar el botón de "registrarse", empezamos a
    // validar los datos introducidos. Hemos creado una clase llamada
    // "ValidarDatos" para que este controller no engorde demasiado.

    @FXML
    void registrarse(ActionEvent event) throws IOException {


        // Validamos nombre y apellido

        if (ValidarDatos.validarNombreApellido(nombre.getText())) {
            nombreCliente = nombre.getText();
        } else {
            nombre.clear();
            nombreCliente = null;
        }

        if (ValidarDatos.validarNombreApellido(apellidos.getText())) {
            apellidosCliente = apellidos.getText();
        } else {
            apellidos.clear();
            apellidosCliente = null;
        }

        // Validamos si el formato del DNI es correcto y luego
        // comprobamos si ya existe en nuestra BBDD

        if (ValidarDatos.validarDNI(dni.getText())) {           
            if(ValidarDatos.dniExistente(dni.getText())){
                Alertas.alertaUsuarioExiste();
                dni.clear();
                dniCliente = null;     
               
            }  else dniCliente = dni.getText();
                       
        } else {         
            dni.clear();
            dniCliente = null;
        }

        // Validamos largura del e-mail y si el usuario lo ha introducido
        // 2 veces de manera correcta. Miramos en la BBDD si existe el email introducido.
        
        if (email.getText().equals(email2.getText()) && ValidarDatos.validarLargo(email.getText())) {
          
            if(ValidarDatos.emailExistente(email.getText())){                
                Alertas.alertaEmailExiste();
                email.clear();
                email2.clear();
                emailCliente = null;

            } else emailCliente = email.getText();     
       
        } else {
            email.clear();
            email2.clear();
            emailCliente = null;
        }

        // Puesto que es una ComboBox, no necesitamos validar el sexo.
        sexoCliente = lista.getValue();

        // Verificamos que el largo de la contraseña sea superior a 8 e inferior a 100 
    
        if (ValidarDatos.validarLargo(contraseña.getText())){
            contraseñaCliente=contraseña.getText();
            contraseñaCliente = Encrypt.encryptPassword(contraseñaCliente);
        
        } else {
            contraseña.clear();
            contraseñaCliente=null;               
        }

        // Si no hay ninguna variable=null, significa que todo es correcto y podemos llamar al constructor para
        // crear nuestro objeto Cliente.

        if (nombreCliente != null && apellidosCliente != null && dniCliente != null && emailCliente != null
                && contraseñaCliente != null) {

            Cliente nuevoUsuario = new Cliente(dniCliente, nombreCliente, apellidosCliente, emailCliente, sexoCliente,
                    contraseñaCliente);
            ClienteDao clienteDao = ConectorBBDD.getClienteDao();

            try {
                clienteDao.insertarCliente(nuevoUsuario);
            } catch (SQLException e) {
                System.out.println("Error SQL al insertar");
                e.printStackTrace();
            }

            // Nos vamos a la Vista 8 y nos llevamos el objeto "Cliente" que acabamos de crear

            FXMLLoader loader = new FXMLLoader(getClass().getResource("vista8.fxml"));
            Parent parent = loader.load();
            Controller8 controller = loader.getController();           

            controller.cargarCliente(nuevoUsuario);
            Scene s = ((Button) event.getSource()).getScene();
            s.setRoot(parent);

        } else Alertas.alertaVerificaDatos();        

    }

    @FXML
    void atras(ActionEvent event) throws IOException {
        App.setRoot("vista2");

    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {

        // Configuramos nuestra comboBox

        lista.getItems().addAll("Mujer", "Hombre", "Otro");

        // Establecemos "Mujer" como preselección de nuestra ComboBox para que el
        // usuario no tenga
        // ocasión de no seleccionar nada.

        lista.setValue("Mujer");

    }

}
