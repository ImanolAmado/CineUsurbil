package CineUsurbil;

import java.util.Arrays;

import javafx.beans.property.SimpleIntegerProperty;

public class Sesion {
    private SimpleIntegerProperty codPelicula;
    private SimpleIntegerProperty codSala;
    private Entradas [] entrada;
    private SimpleIntegerProperty fecha;
    private SimpleIntegerProperty hora;

    /*constructor*/
    public Sesion(int codPelicula, int codSala, Entradas entrada, int fecha, int hora){
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
        this.codSala = new SimpleIntegerProperty(codSala);
        this.entrada = new Entradas[1];
        this.fecha = new SimpleIntegerProperty(fecha);
        this.hora = new SimpleIntegerProperty(hora);
    }

    @Override
    public String toString() {
        return "Sesion [codPelicula=" + codPelicula + ", codSala=" + codSala + ", entrada=" + Arrays.toString(entrada)
                + ", fecha=" + fecha + ", hora=" + hora + "]";
    }

    public int getCodPelicula() {
        return codPelicula.get();
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula.set(codPelicula);
    }

    public int getCodSala() {
        return codSala.get();
    }

    public void setCodSala(int codSala) {
        this.codSala.set(codSala);
    }

    public Entradas[] getEntrada() {
        return entrada;
    }

    public void setEntrada(Entradas[] entrada) {
        this.entrada = entrada;
    }

    public int getFecha() {
        return fecha.get();
    }

    public void setFecha(int fecha) {
        this.fecha.set(fecha);
    }

    public int getHora() {
        return hora.get();
    }

    public void setHora(int hora) {
        this.hora.set(hora);
    }

}
