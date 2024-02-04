package CineUsurbil;

import javafx.beans.property.SimpleStringProperty;

public class Cliente {
    private final SimpleStringProperty dni;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty apellidos;
    private boolean sexo;
    private int contraseña;


    public Cliente(String dni, String nombre , String apellidos , boolean sexo , int contraseña){
    this.dni = new SimpleStringProperty(dni);
    this.nombre = new SimpleStringProperty(nombre);
    this.apellidos = new SimpleStringProperty(apellidos);
    this.sexo = sexo;
    this.contraseña = contraseña;

    }


    @Override
    public String toString() {
        return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", sexo=" + sexo
                + ", contraseña=" + contraseña + "]";
    }


    public SimpleStringProperty getDni() {
        return dni;
    }


    public SimpleStringProperty getNombre() {
        return nombre;
    }


    public SimpleStringProperty getApellidos() {
        return apellidos;
    }


    public boolean isSexo() {
        return sexo;
    }


    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }


    public int getContraseña() {
        return contraseña;
    }


    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }    
    
}
