package CineUsurbil;


import javafx.beans.property.SimpleStringProperty;

public class Cine {

    private SimpleStringProperty codCine;
    private Sala [] sala;
    private SimpleStringProperty nombre;
    

    public Cine (String codCine, String nombre){
        this.codCine = new SimpleStringProperty(codCine);
        this.nombre = new SimpleStringProperty(nombre);

    }
  
    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public Cine(String codCine, Sala[] sala){
        this.codCine = new SimpleStringProperty(codCine);
        this.sala = sala;       
    }
    
    public Cine(String codCine){
        this.codCine = new SimpleStringProperty(codCine);     
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
