package CineUsurbil;

import java.util.Arrays;

public class Cine {
    private int codCine;
    private Salas [] sala;

    /*constructor*/    
  
    public Cine(int codCine, Salas[] sala){
        this.codCine = codCine;
        this.sala = sala;       
    }

        
    public Cine(){          

    }   

    public Cine(int codCine){

        this.codCine = codCine;
        this.sala = new Salas[4];        
    }


    @Override
    public String toString() {
        return "Cine [codCine=" + codCine + ", sala=" + Arrays.toString(sala) + "]";
    }

    public int getCodCine() {
        return codCine;
    }

    public void setCodCine(int codCine) {
        this.codCine = codCine;
    }

    public Salas[] getSala() {
        return sala;
    }

    public void setSala(Salas[] sala) {
        this.sala = sala;
    }
    
}
