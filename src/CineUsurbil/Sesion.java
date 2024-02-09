package CineUsurbil;

import java.util.Arrays;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sesion {

    private SimpleStringProperty codCine;
    private SimpleIntegerProperty codPelicula;
    private SimpleStringProperty codSala;
    private Entradas [] entrada;
    private SimpleIntegerProperty fecha;
    private SimpleIntegerProperty hora;

    // Constructores

    public Sesion(String codCine, int codPelicula, String codSala, Entradas entrada, int fecha, int hora){
        this.codCine = new SimpleStringProperty(codCine);
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
        this.codSala = new SimpleStringProperty(codSala);
        this.entrada = new Entradas[1];
        this.fecha = new SimpleIntegerProperty(fecha);
        this.hora = new SimpleIntegerProperty(hora);
    }
   

    @Override
    public String toString() {
        return "Sesion [codPelicula=" + codPelicula + ", codSala=" + codSala + ", entrada=" + Arrays.toString(entrada)
                + ", fecha=" + fecha + ", hora=" + hora + "]";
    }

           
    
    public String getCodCine() {
        return codCine.get();
    }

    public void setCodCine(String codCine) {
        this.codCine.set(codCine);
    }

    public int getCodPelicula() {
        return codPelicula.get();
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula.set(codPelicula);
    }

    public String getCodSala() {
        return codSala.get();
    }

    public void setCodSala(String codSala) {
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
