package CineUsurbil;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Salas {
    private SimpleIntegerProperty codSala;
    private SimpleStringProperty nombre;
    private SimpleStringProperty genero;
    private SimpleDoubleProperty coste;

    /*constructor*/
    public Salas(int codSala, String nombre, String genero, double coste){
        this.codSala = new SimpleIntegerProperty(codSala);
        this.nombre = new SimpleStringProperty(nombre);
        this.genero = new SimpleStringProperty(genero);
        this.coste = new SimpleDoubleProperty(coste);
    }

   //public Salas(){

   //}

   
    @Override
    public String toString() {
        return "Salas [codSala=" + codSala + ", nombre=" + nombre + ", genero=" + genero + ", coste=" + coste + "]";
    }

    public int getCodSala() {
        return codSala.get();
    }

    public void setCodSala(int codSala) {
        this.codSala.set(codSala);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre){
        this.nombre.set(nombre);
    }

    public String getGenero() {
        return genero.get();
    }

    public void setGenero(String genero){
        this.genero.set(genero);
    }

    public double getCoste() {
        return coste.get();//está bien?
    }

    public void setCoste(double coste) {
        this.coste.set(coste);
    }


}
