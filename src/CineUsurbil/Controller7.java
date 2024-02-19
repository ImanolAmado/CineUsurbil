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

    // Validamos que los campos de nombre y apellidos tengan una
    // largura inferior a 100 carácteres (y superior a 1), que es el tamaño que
    // tenemos en la BBDD para esos campos.

    @FXML
    private boolean validarNombreApellido(String largo) {

        if (largo.length() <= 1 || largo.length() > 100) {
            return false;
        }
        return true;

    }

    // Deberíamos implementar algún tipo de verificación de email antes de introducir
    // los datos en la BBDD. De momento, nos conformamos con exigir una largura de al menos
    // 8 carácteres y que sea inferior a 100. Para la contraseña usamos el mismo método

    @FXML
    private boolean validarLargo(String largo) {

        if (largo.length() <=8  || largo.length() > 100) {
            return false;
        }
        return true;

    }


    // Validamos que nos pasan un DNI válido. Va a ser "primary key"
    // en nuestra BBDD por lo que es importante que el DNI sea correcto.

    public boolean validarDNI(String dniNumero) {

        String dniSinLetra;
        String letraDni;
        int numero;

        final String[] CODIGOCONTROL = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S",
                "Q",
                "V", "H", "L", "C", "K", "E" };

        if (dniNumero.length() != 9) {
            return false;
        }

        dniSinLetra = dniNumero.substring(0, 8);
        letraDni = dniNumero.substring(8, 9);

        try {
            numero = Integer.valueOf(dniSinLetra);
        } catch (NumberFormatException e) {
            return false;
        }

        numero = numero % 23;

        if (numero > 22 || numero < 0) {
            return false;
        } else if (CODIGOCONTROL[numero].equalsIgnoreCase(letraDni)) {
            return true;
        } else
            return false;
    }


    // Si el DNI es válido, necesitamos saber si ya existe en nuestra BBDD.
    // No podemos tener 2 parámetros de DNI iguales puesto que es "primary key".

    public boolean dniExistente() {
        ClienteDao clienteDao = ConectorBBDD.getClienteDao();

        try {
            if (!clienteDao.buscarDNI(dni.getText())) {              
                dniCliente = dni.getText();
                return false;
            }

            else {                         
                dni.clear();
                dniCliente = null;               
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }  return true;
  
    }

    // En nuestra BBDD, email es "unique" por lo que tenemos que asegurarnos
    // de que no existe.

    public boolean emailExistente() {
        ClienteDao clienteDao = ConectorBBDD.getClienteDao();

        try {
            if (!clienteDao.buscarEmail(email.getText())) {               
                emailCliente = email.getText();
                return false;
            }

            else {                            
                email.clear();
                email2.clear();
                emailCliente = null;               
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }  return true;
  
    }
    

    // Al registrarnos y pulsar el botón de "registrarse", empezamos a
    // validar los datos introducidos.

    @FXML
    void registrarse(ActionEvent event) throws IOException {

        // Validamos nombre y apellido

        if (validarNombreApellido(nombre.getText())) {
            nombreCliente = nombre.getText();
        } else {
            nombre.clear();
            nombreCliente = null;
        }

        if (validarNombreApellido(apellidos.getText())) {
            apellidosCliente = apellidos.getText();
        } else {
            apellidos.clear();
            apellidosCliente = null;
        }

        // Validamos si el formato del DNI es correcto y luego
        // comprobamos si ya existe en nuestra BBDD

        if (validarDNI(dni.getText())) {           
            if(dniExistente()){
                Alertas.alertaUsuarioExiste();
            }             
        } else {         
            dni.clear();
            dniCliente = null;
        }

        // Validamos largura del e-mail y si el usuario lo ha introducido
        // 2 veces de manera correcta. Miramos en la BBDD si existe el email introducido.
        

        if (email.getText().equals(email2.getText()) && validarLargo(email.getText())) {
          
            if(emailExistente()){                
                Alertas.alertaEmailExiste();
            }          
       
        } else {
            email.clear();
            email2.clear();
            emailCliente = null;
        }

        sexoCliente = lista.getValue();

        // Verificamos que el largo de la contraseña sea superior a 8 e inferior a 100 
    
        if (validarLargo(contraseña.getText())){
            contraseñaCliente=contraseña.getText();
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
