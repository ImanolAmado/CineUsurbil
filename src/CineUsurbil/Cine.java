package CineUsurbil;

import java.util.Arrays;

import javafx.beans.property.SimpleStringProperty;

public class Cine {
    private SimpleStringProperty codCine;
    private Salas [] sala;

    /*constructor*/    
  
    public Cine(String codCine, Salas[] sala){
        this.codCine = new SimpleStringProperty(codCine);
        this.sala = sala;       
    }

        
    public Cine(String codCine){
        this.codCine = new SimpleStringProperty(codCine);
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

    public Salas[] getSala() {
        return sala;
    }

    public void setSala(Salas[] sala) {
        this.sala = sala;
    }
    
}
