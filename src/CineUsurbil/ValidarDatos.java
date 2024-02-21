package CineUsurbil;

import java.sql.SQLException;

public class ValidarDatos {

// Validamos que nos pasan un DNI válido. 

    public static boolean validarDNI(String dniNumero) {

        String dniSinLetra;
        String letraDni;
        int numero;

        final String[] CODIGOCONTROL = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S",
                "Q","V", "H", "L", "C", "K", "E"};

        if (dniNumero.length() != 9) {
            return false;
        }

        dniSinLetra = dniNumero.substring(0, 8);
        letraDni = dniNumero.substring(8, 9);

        try {
            numero = Integer.valueOf(dniSinLetra);
        } catch (NumberFormatException e) {
            return false;
        }

        numero = numero % 23;

        if (numero > 22 || numero < 0) {
            return false;
        } else if (CODIGOCONTROL[numero].equalsIgnoreCase(letraDni)) {
            return true;
        } else
            return false;
    }


    // Validamos que los campos de nombre y apellidos tengan una
    // largura inferior a 100 carácteres (y superior a 1), que es el tamaño que
    // tenemos en la BBDD para esos campos.

    
    public static boolean validarNombreApellido(String largo) {

        if (largo.length() <= 1 || largo.length() > 100) {
            return false;
        }
        return true;

    }


    // Deberíamos implementar algún tipo de verificación de email antes de introducir
    // los datos en la BBDD. De momento, nos conformamos con exigir una largura de al menos
    // 8 carácteres y que sea inferior a 100. Para la contraseña usamos el mismo método

    
    public static boolean validarLargo(String largo) {

        if (largo.length() <=8  || largo.length() > 100) {
            return false;
        }
        return true;

    }   

    // Si el DNI es válido, necesitamos saber si ya existe en nuestra BBDD.
    // No podemos tener 2 DNI iguales puesto que es "primary key".

    public static boolean dniExistente(String dni) {
        ClienteDao clienteDao = ConectorBBDD.getClienteDao();

        try {
            if (!clienteDao.buscarDNI(dni)) {      
                return false;
            }          

        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return true;  
    }


     // En nuestra BBDD, email es "unique" por lo que tenemos que asegurarnos
    // de que no existe.

    public static boolean emailExistente(String email) {
        ClienteDao clienteDao = ConectorBBDD.getClienteDao();

        try {
            if (!clienteDao.buscarEmail(email)) {       
                return false;
            }          

        } catch (SQLException e) {
            e.printStackTrace();
        }  
        return true;
  
    }




}

