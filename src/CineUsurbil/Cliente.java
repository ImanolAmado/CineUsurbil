package CineUsurbil;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Cliente {
    private SimpleStringProperty dni;
    private SimpleStringProperty nombre;
    private SimpleStringProperty apellidos;
    private SimpleBooleanProperty sexo;
    private SimpleIntegerProperty contraseña;


    public Cliente(String dni, String nombre , String apellidos , boolean sexo , int contraseña){
    this.dni = new SimpleStringProperty(dni);
    this.nombre = new SimpleStringProperty(nombre);
    this.apellidos = new SimpleStringProperty(apellidos);
    this.sexo = new SimpleBooleanProperty(sexo);
    this.contraseña = new SimpleIntegerProperty(contraseña);

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

    public boolean isSexo() {
        return sexo.get();
    }//Esto está bién?


    public void setSexo(boolean sexo) {
        this.sexo.set(sexo);
    }


    public int getContraseña() {
        return contraseña.get();
    }


    public void setContraseña(int contraseña) {
        this.contraseña.set(contraseña);
    }    
    
}
