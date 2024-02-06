package CineUsurbil;

import java.util.Arrays;

import javafx.beans.property.SimpleIntegerProperty;

public class Cine {
    private SimpleIntegerProperty codCine;
    private Salas [] sala;

    /*constructor*/    
  
    public Cine(int codCine, Salas[] sala){
        this.codCine = new SimpleIntegerProperty(codCine);
        this.sala = sala;       
    }

        
    public Cine(){          

    }   

    /* public Cine(int codCine){

        this.codCine = codCine;
        this.sala = new Salas[4];        
    }
 */

    @Override
    public String toString() {
        return "Cine [codCine=" + codCine + ", sala=" + Arrays.toString(sala) + "]";
    }

    public int getCodCine() {
        return codCine.get();
    }

    public void setCodCine(int codCine) {
        this.codCine.set(codCine);
    }

    public Salas[] getSala() {
        return sala;
    }

    public void setSala(Salas[] sala) {
        this.sala = sala;
    }
    
}
