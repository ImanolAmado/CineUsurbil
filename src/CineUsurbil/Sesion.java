package CineUsurbil;

import java.util.Arrays;

public class Sesion {
    private int codPelicula;
    private int codSala;
    private Entradas [] entrada;
    private int fecha;
    private int hora;

    /*constructor*/
    public Sesion(int codPelicula, int codSala, Entradas entrada, int fecha, int hora){
        this.codPelicula = codPelicula;
        this.codSala = codSala;
        this.entrada = new Entradas[1];
        this.fecha = fecha;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Sesion [codPelicula=" + codPelicula + ", codSala=" + codSala + ", entrada=" + Arrays.toString(entrada)
                + ", fecha=" + fecha + ", hora=" + hora + "]";
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public int getCodSala() {
        return codSala;
    }

    public void setCodSala(int codSala) {
        this.codSala = codSala;
    }

    public Entradas[] getEntrada() {
        return entrada;
    }

    public void setEntrada(Entradas[] entrada) {
        this.entrada = entrada;
    }

    public int getFecha() {
        return fecha;
    }

    public void setFecha(int fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

}
