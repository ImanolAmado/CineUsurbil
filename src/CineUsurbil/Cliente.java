package CineUsurbil;

import javafx.beans.property.SimpleStringProperty;

public class Cliente {

    private SimpleStringProperty dni;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidos;
    private SimpleStringProperty email;
    private SimpleStringProperty sexo;
    private SimpleStringProperty contraseña;


    public Cliente(String dni, String nombre , String apellidos , String email, String sexo , String contraseña){
    this.dni = new SimpleStringProperty(dni);
    this.nombre = new SimpleStringProperty(nombre);
    this.apellidos = new SimpleStringProperty(apellidos);
    this.email = new SimpleStringProperty(email);
    this.sexo = new SimpleStringProperty(sexo);
    this.contraseña = new SimpleStringProperty(contraseña);
    }

    public Cliente(String dni, String nombre , String apellidos , String email){
        this.dni = new SimpleStringProperty(dni);
        this.nombre = new SimpleStringProperty(nombre);
        this.apellidos = new SimpleStringProperty(apellidos);
        this.email = new SimpleStringProperty(email);        
        }
      

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " Apellido: " + getApellidos();
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

    public String getSexo() {
        return sexo.get();
    }


    public void setSexo(String sexo) {
        this.sexo.set(sexo);
    }


    public String getContraseña() {
        return contraseña.get();
    }


    public void setContraseña(String contraseña) {
        this.contraseña.set(contraseña);
    }    
 

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }
    
}
