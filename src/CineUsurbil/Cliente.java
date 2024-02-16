package CineUsurbil;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cliente {

    private SimpleStringProperty dni;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidos;
    private SimpleStringProperty sexo;
    private SimpleStringProperty contraseña;


    public Cliente(String dni, String nombre , String apellidos , String sexo , String contraseña){
    this.dni = new SimpleStringProperty(dni);
    this.nombre = new SimpleStringProperty(nombre);
    this.apellidos = new SimpleStringProperty(apellidos);
    this.sexo = new SimpleStringProperty(sexo);
    this.contraseña = new SimpleStringProperty(contraseña);
    }

    public Cliente(String dni, String contraseña){
    this.dni = new SimpleStringProperty(dni);
    this.contraseña = new SimpleStringProperty(contraseña);
    }

    public Cliente(){
        
    }

    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo
                + ", contraseña=" + contraseña + "]";
    }


    public String getDni() {
        return dni.get();
    }

    public void setDni(String dni){
        this.dni.set(dni);
    }


    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre){
        this.nombre.set(nombre);
    }

    public String getApellidos() {
        return apellidos.get();
    }

    public void setApellidos(String apellidos){
        this.apellidos.set(apellidos);
    }

    public String Sexo() {
        return sexo.get();
    }//Esto está bién?


    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }


    public String getContraseña() {
        return contraseña.get();
    }


    public void setContraseña(String contraseña) {
        this.contraseña.set(contraseña);
    }    
    
}
