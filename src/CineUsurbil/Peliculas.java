package CineUsurbil;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Peliculas {
    private SimpleIntegerProperty codPelicula;
    private SimpleStringProperty titulo;
    private SimpleStringProperty duracion;
    private SimpleStringProperty genero;
    private SimpleDoubleProperty coste;

    /*constructor*/
    public Peliculas(int codPelicula,String titulo, String duracion, String genero, double coste){
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
        this.titulo = new SimpleStringProperty(titulo);
        this.duracion = new SimpleStringProperty(duracion);
        this.genero = new SimpleStringProperty(genero);
        this.coste = new SimpleDoubleProperty(coste);
    }
    public Peliculas(String titulo, String duracion, String genero){
        this.titulo = new SimpleStringProperty(titulo);
        this.duracion = new SimpleStringProperty(duracion);
        this.genero = new SimpleStringProperty(genero);
    }

    public Peliculas (int codPelicula){
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
    }
      
    

    @Override
    public String toString() {
        return "Peliculas [codPelicula=" + codPelicula + ", duracion=" + duracion + ", genero=" + genero + ", coste="
                + coste + "]";
    }

    public int getCodPelicula() {
        return codPelicula.get();
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula.set(codPelicula);
    }

    public String gettitulo() {
        return titulo.get();
    }

    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }

    public String getDuracion() {
        return duracion.get();//esta bien?
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
        return coste.get();//está bien?
    }

    public void setCoste(double coste) {
        this.coste.set(coste);
    }

   

   
}
