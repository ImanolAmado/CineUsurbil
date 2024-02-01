package CineUsurbil;
public class Entradas {
   private int CodEntrada;
   private int fecha;
   private Peliculas [] pelicula;
   private int horario;
   private String Sala;
   private double precio;
   private Cliente[] cliente;



   public Entradas(int CodEntrada, int fecha , Peliculas[] pelicula , int horario , String Sala , double precio , Cliente[] cliente ){
      this.CodEntrada=CodEntrada;
      this.fecha=fecha;
      this.horario=horario;
      this.Sala=Sala;
      this.pelicula=pelicula;
      this.precio=precio;
      this.cliente=cliente;
   }
public String toString() {
    return CodEntrada+fecha+horario+Sala+pelicula+precio+cliente;
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

public String getSala() {
    return Sala;
}

public void setSala(String sala) {
    Sala = sala;
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
