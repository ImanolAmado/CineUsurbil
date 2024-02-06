package CineUsurbil;

import java.util.Arrays;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Entradas {
   private SimpleIntegerProperty codEntrada;
   private SimpleIntegerProperty fecha;
   private Peliculas [] pelicula;
   private SimpleIntegerProperty horario;
   private SimpleStringProperty sala;
   private SimpleDoubleProperty precio;
   private Cliente[] cliente;


   public Entradas(int codEntrada, int fecha , Peliculas pelicula , int horario , String sala , double precio , Cliente cliente ){
      this.codEntrada = new SimpleIntegerProperty(codEntrada);
      this.fecha = new SimpleIntegerProperty(fecha);
      this.horario = new SimpleIntegerProperty(horario);
      this.sala = new SimpleStringProperty(sala);
      this.pelicula = new Peliculas[1];
      this.precio = new SimpleDoubleProperty(precio);
      this.cliente = new Cliente[10];
   }

@Override
public String toString() {
    return "Entradas [CodEntrada=" + codEntrada + ", fecha=" + fecha + ", pelicula=" + Arrays.toString(pelicula)
            + ", horario=" + horario + ", Sala=" + sala + ", precio=" + precio + ", cliente=" + Arrays.toString(cliente)
            + "]";
}

public int getCodEntrada() {
    return codEntrada.get();
}

public void setCodEntrada(int codEntrada) {
    this.codEntrada.set(codEntrada);
}

public int getFecha() {
    return fecha.get();
}

public void setFecha(int fecha) {
    this.fecha.set(fecha);
}

public Peliculas[] getPelicula() {
    return pelicula;
}

public void setPelicula(Peliculas[] pelicula) {
    this.pelicula = pelicula;
}

public int getHorario() {
    return horario.get();
}

public void setHorario(int horario) {
    this.horario.set(horario);
}

public String getSala() {
    return sala.get();
}

public void setSala(String sala){
    this.sala.set(sala);
}

public double getPrecio() {
    return precio.get();//esta bien?
}

public void setPrecio(double precio) {
    this.precio.set(precio);
}

public Cliente[] getCliente() {
    return cliente;
}

public void setCliente(Cliente[] cliente) {
    this.cliente = cliente;
}

}
