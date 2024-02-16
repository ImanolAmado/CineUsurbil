package CineUsurbil;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sala {

    private SimpleStringProperty codCine;
    private SimpleStringProperty codSala;
    private SimpleStringProperty nombre;
    private SimpleStringProperty genero;
    private SimpleDoubleProperty coste;

    // Constructores

    public Sala(String codCine, String codSala, String nombre, String genero, double coste) {

        this.codCine = new SimpleStringProperty(codCine);
        this.codSala = new SimpleStringProperty(codSala);
        this.nombre = new SimpleStringProperty(nombre);
        this.genero = new SimpleStringProperty(genero);
        this.coste = new SimpleDoubleProperty(coste);
    }

    public Sala(String codSala) {

        this.codSala = new SimpleStringProperty(codSala);
    }

    public Sala(String codSala, String nombre){
        this.codSala = new SimpleStringProperty(codSala);
        this.nombre = new SimpleStringProperty(nombre);
    }

    @Override
    public String toString() {
        return "Salas [codSala=" + codSala + ", nombre=" + nombre + ", genero=" + genero + ", coste=" + coste + "]";
    }

    public String getCodCine() {
        return codCine.get();
    }

    public void setCodCine(String codCine) {
        this.codCine.set(codCine);
    } 
        
    public String getCodSala() {
        return codSala.get();
    }

    public void setCodSala(String codSala) {
        this.codSala.set(codSala);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getGenero() {
        return genero.get();
    }

    public void setGenero(String genero) {
        this.genero.set(genero);
    }

    public double getCoste() {
        return coste.get();// está bien?
    }

    public void setCoste(double coste) {
        this.coste.set(coste);
    }

}
