package CineUsurbil;

import java.sql.Date;
import java.sql.Time;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sesion {

    private SimpleStringProperty codCine;
    private SimpleIntegerProperty codPelicula;
    private SimpleStringProperty codSala;   
    private SimpleStringProperty nombreSala;
    private Date fecha;
    private Time hora;
    private SimpleDoubleProperty precio;

    // Constructores

    public Sesion(String codCine, int codPelicula, String codSala, String nombreSala, Date fecha, Time hora, double precio){
        this.codCine = new SimpleStringProperty(codCine);
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
        this.codSala = new SimpleStringProperty(codSala);  
        this.nombreSala = new SimpleStringProperty(nombreSala);    
        this.fecha = fecha;
        this.hora = hora;
        this.precio = new SimpleDoubleProperty(precio);
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

    public void setNombresala(String nombreSala) {
        this.codSala.set(nombreSala);
    }

    public String getNombreSala() {
        return nombreSala.get();
    }

    public void setCodSala(String codSala) {
        this.codSala.set(codSala);
    }
   
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora=hora;
    }

    public double getPrecio(){
        return precio.get();

    }

    public void setPrecio(double precio){
        this.precio.set(precio);
    }


    

    

}
