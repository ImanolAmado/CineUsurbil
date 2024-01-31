package CineUsurbil;

public class Peliculas {
    private int codPelicula;
    private double duracion;
    private String genero;
    private double coste;

    /*constructor*/
    public Peliculas(){
        this.codPelicula = codPelicula;
        this.duracion = duracion;
        this.genero = genero;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }
}
