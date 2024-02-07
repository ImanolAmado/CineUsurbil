package CineUsurbil;

import java.util.Arrays;

import javafx.beans.property.SimpleStringProperty;

public class Cine {

    private SimpleStringProperty codCine;
    private Sala [] sala;
    private String nombre;
    /*constructor*/    
  
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cine(String codCine, Sala[] sala){
        this.codCine = new SimpleStringProperty(codCine);
        this.sala = sala;       
    }
    
    public Cine(String codCine){
        this.codCine = new SimpleStringProperty(codCine);        
    } 
        
    public Cine(String codCine,String nombre){
        this.codCine = new SimpleStringProperty(codCine);
        this.nombre=nombre;
    }   

    
    @Override
    public String toString() {
        return "Cine [codCine=" + codCine + ", sala=" + Arrays.toString(sala) + "]";
    }

    public String getCodCine() {
        return codCine.get();
    }

    public void setCodCine(String codCine) {
        this.codCine.set(codCine);
    }

    public Sala[] getSala() {
        return sala;
    }

    public void setSala(Sala[] sala) {
        this.sala = sala;
    }
    
}
