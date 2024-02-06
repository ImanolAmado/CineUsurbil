package CineUsurbil;

import java.util.Arrays;

public class Cine {
    private String codCine;
    private Salas [] sala;

    /*constructor*/    
  
    public Cine(String codCine, Salas[] sala){
        this.codCine = codCine;
        this.sala = sala;       
    }

        
    public Cine(String codCine){
        this.codCine = codCine;        

    }    


    @Override
    public String toString() {
        return "Cine [codCine=" + codCine + ", sala=" + Arrays.toString(sala) + "]";
    }

    public String getCodCine() {
        return codCine;
    }

    public void setCodCine(String codCine) {
        this.codCine = codCine;
    }

    public Salas[] getSala() {
        return sala;
    }

    public void setSala(Salas[] sala) {
        this.sala = sala;
    }
    
}
