package CineUsurbil;

import java.util.Arrays;

import javafx.beans.property.SimpleStringProperty;

public class Entradas {
   private int CodEntrada;
   private int fecha;
   private Peliculas [] pelicula;
   private int horario;
   private final SimpleStringProperty sala;
   private double precio;
   private Cliente[] cliente;



   public Entradas(int CodEntrada, int fecha , Peliculas pelicula , int horario , String sala , double precio , Cliente cliente ){
      this.CodEntrada = CodEntrada;
      this.fecha = fecha;
      this.horario = horario;
      this.sala = new SimpleStringProperty(sala);
      this.pelicula = new Peliculas[1];
      this.precio = precio;
      this.cliente = new Cliente[10];
   }



@Override
public String toString() {
    return "Entradas [CodEntrada=" + CodEntrada + ", fecha=" + fecha + ", pelicula=" + Arrays.toString(pelicula)
            + ", horario=" + horario + ", Sala=" + sala + ", precio=" + precio + ", cliente=" + Arrays.toString(cliente)
            + "]";
}



public int getCodEntrada() {
    return CodEntrada;
}



public void setCodEntrada(int codEntrada) {
    CodEntrada = codEntrada;
}



public int getFecha() {
    return fecha;
}



public void setFecha(int fecha) {
    this.fecha = fecha;
}



public Peliculas[] getPelicula() {
    return pelicula;
}



public void setPelicula(Peliculas[] pelicula) {
    this.pelicula = pelicula;
}



public int getHorario() {
    return horario;
}



public void setHorario(int horario) {
    this.horario = horario;
}



public SimpleStringProperty getSala() {
    return sala;
}



public double getPrecio() {
    return precio;
}



public void setPrecio(double precio) {
    this.precio = precio;
}



public Cliente[] getCliente() {
    return cliente;
}



public void setCliente(Cliente[] cliente) {
    this.cliente = cliente;
}



}
