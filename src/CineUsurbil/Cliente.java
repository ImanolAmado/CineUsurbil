package CineUsurbil;
public class Cliente {
    String dni;
    String nombre;
    String apellidos;
    boolean sexo;
    int contraseña;


    public Cliente(String dni, String nombre , String apellidos , boolean sexo , int contraseña){
    this.dni=dni;
    this.nombre=nombre;
    this.apellidos=apellidos;
    this.sexo=sexo;
    this.contraseña=contraseña;

    }


    public String getDni() {
        return dni;
    }


    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }


    public boolean isSexo() {
        return sexo;
    }


    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }


    public int getContraseña() {
        return contraseña;
    }


    public void setContraseña(int contraseña) {
        this.contraseña = contraseña;
    }

    
}
