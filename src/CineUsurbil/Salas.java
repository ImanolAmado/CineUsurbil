package CineUsurbil;

import javafx.beans.property.SimpleStringProperty;

public class Salas {
    private int codSala;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty genero;
    private double coste;

    /*constructor*/
    public Salas(int codSala, String nombre, String genero, double coste){
        this.codSala = codSala;
        this.nombre = new SimpleStringProperty(nombre);
        this.genero = new SimpleStringProperty(genero);
        this.coste = coste;
    }

   //public Salas(){

   //}

   
    @Override
    public String toString() {
        return "Salas [codSala=" + codSala + ", nombre=" + nombre + ", genero=" + genero + ", coste=" + coste + "]";
    }

    public int getCodSala() {
        return codSala;
    }

    public void setCodSala(int codSala) {
        this.codSala = codSala;
    }

    public SimpleStringProperty getNombre() {
        return nombre;
    }

    public SimpleStringProperty getGenero() {
        return genero;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }


}
