package CineUsurbil;

import javafx.beans.property.SimpleStringProperty;

public class Peliculas {
    private int codPelicula;
    private double duracion;
    private final SimpleStringProperty genero;
    private double coste;

    /*constructor*/
    public Peliculas(int codPelicula, double duracion, String genero, double coste){
        this.codPelicula = codPelicula;
        this.duracion = duracion;
        this.genero = new SimpleStringProperty(genero);
        this.coste = coste;
    }

    

    @Override
    public String toString() {
        return "Peliculas [codPelicula=" + codPelicula + ", duracion=" + duracion + ", genero=" + genero + ", coste="
                + coste + "]";
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
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
