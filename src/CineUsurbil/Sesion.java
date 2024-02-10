package CineUsurbil;

import java.sql.Date;
import java.sql.Time;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Sesion {

    private SimpleStringProperty codCine;
    private SimpleIntegerProperty codPelicula;
    private SimpleStringProperty codSala;   
    private Date fecha;
    private Time hora;

    // Constructores

    public Sesion(String codCine, int codPelicula, String codSala, Date fecha, Time hora){
        this.codCine = new SimpleStringProperty(codCine);
        this.codPelicula = new SimpleIntegerProperty(codPelicula);
        this.codSala = new SimpleStringProperty(codSala);      
        this.fecha = fecha;
        this.hora = hora;
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

}
