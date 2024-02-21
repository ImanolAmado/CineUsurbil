package CineUsurbil;


public class Entradas {

    private Cine cine;  
    private Sesion sesion;
    private Peliculas pelicula;

    public Entradas(Cine cine, Sesion sesion, Peliculas pelicula) {             
       
        this.cine = cine;    
        this.sesion = sesion;
        this.pelicula = pelicula;
       
    }    

    public Cine getCine(){
        return cine;
    }

    public void setCine(Cine cine){
        this.cine = cine;
    }    

    public Peliculas getPelicula() {
        return pelicula;
    }

    public void setPelicula(Peliculas pelicula) {
        this.pelicula = pelicula;
    } 

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    @Override
    public String toString() {
        return cine.getNombre() + " - " + pelicula.getTitulo() + " - " + sesion.getFecha() + " - "
        + sesion.getHora() + " - " + sesion.getNombreSala() + " - " + sesion.getPrecio() +"€";  
    }      
    

    public String mostrarEntrada(){
        return cine.getNombre() + " - " + pelicula.getTitulo() + " - " + sesion.getFecha() + " - "
        + sesion.getHora() + " - " + sesion.getNombreSala() + " - " + sesion.getPrecio() +"€";  
    }

}
