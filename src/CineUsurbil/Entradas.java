package CineUsurbil;

import java.sql.Date;
import java.sql.Time;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Entradas {
    private SimpleIntegerProperty codEntrada;
    private Date fecha;
    private Peliculas pelicula;
    private Time hora;
    private SimpleStringProperty sala;
    private SimpleDoubleProperty precio;
    private Cliente cliente;

    public Entradas(int codEntrada, Date fecha, Peliculas pelicula, Time hora, String sala, double precio,
            Cliente cliente) {
        this.codEntrada = new SimpleIntegerProperty(codEntrada);
        this.fecha = fecha;
        this.hora = hora;
        this.sala = new SimpleStringProperty(sala);
        this.pelicula = pelicula;
        this.precio = new SimpleDoubleProperty(precio);
        this.cliente = cliente;
    }

    

    public int getCodEntrada() {
        return codEntrada.get();
    }

    public void setCodEntrada(int codEntrada) {
        this.codEntrada.set(codEntrada);
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    }

    public Time getHora() {
        return hora;
    }

    public void setHorario(Time hora) {
        this.hora = hora;
    }

    public String getSala() {
        return sala.get();
    }

    public void setSala(String sala) {
        this.sala.set(sala);
    }

    public double getPrecio() {
        return precio.get();// esta bien?
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
