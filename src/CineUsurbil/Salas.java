package CineUsurbil;

public class Salas {
    private int codSala;
    private String nombre;
    private String genero;
    private double coste;

    /*constructor*/
    public Salas(){
        this.codSala = codSala;
        this.nombre = nombre;
        this.genero = genero;
        this.coste = coste;
    }

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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
