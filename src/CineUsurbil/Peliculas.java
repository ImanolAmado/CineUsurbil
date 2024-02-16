package CineUsurbil;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Peliculas {
    private SimpleIntegerProperty codPelicula;
    private SimpleStringProperty titulo;
    private SimpleStringProperty duracion;
    private SimpleStringProperty genero;
    private SimpleStringProperty imagen;
    private SimpleDoubleProperty coste;

    // Constructores

    public Peliculas(int codPelicula,String titulo, String duracion, String genero, double coste){
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
        this.titulo = new SimpleStringProperty(titulo);
        this.duracion = new SimpleStringProperty(duracion);
        this.genero = new SimpleStringProperty(genero);
        this.coste = new SimpleDoubleProperty(coste);
    }
    public Peliculas(String titulo, String duracion, String genero, int codPelicula, String imagen){
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
        this.titulo = new SimpleStringProperty(titulo);
        this.duracion = new SimpleStringProperty(duracion);
        this.genero = new SimpleStringProperty(genero);
        this.imagen = new SimpleStringProperty(imagen);
    }

    public Peliculas (int codPelicula){
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
    }             

    public int getCodPelicula() {
        return codPelicula.get();
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula.set(codPelicula);
    }

    public String getTitulo() {
        return titulo.get();
    }

    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    public String getDuracion() {
        return duracion.get();
    }

    public void setDuracion(String duracion) {
        this.duracion.set(duracion);
    }

    public String getGenero() {
        return genero.get();
    }

    public void setGenero(String genero){
        this.genero.set(genero);
    }

    public double getCoste() {
        return coste.get();
    }

    public void setCoste(double coste) {
        this.coste.set(coste);
    }

    public void setImagen(String imagen) {
        this.imagen.set(imagen);
    }

    public String getImagen() {
        return imagen.get();
    }


    @Override
    public String toString() {
        return "Peliculas [codPelicula=" + codPelicula + ", duracion=" + duracion + ", genero=" + genero + ", coste="
                + coste + "]";
    }

   
}
