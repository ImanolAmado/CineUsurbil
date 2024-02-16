// PRUEBAS PARA METODOS QUE VAMOS A NECESITAR
// RETO 3
// LIQUIDPAPER 

package CineUsurbil;


import java.util.Scanner;


public class MetodosDiversos {


    public static boolean comprobarDNI(String dniNumero){ 
       
        boolean dniCorrecto=false;
        String dniSinLetra;
        String letraDni;
        int numero;
        
        String[] codigoControl={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};

        if (dniNumero.length() !=9){
        dniCorrecto=false;
        return dniCorrecto;
        }

        dniSinLetra=dniNumero.substring(0,8);
        letraDni=dniNumero.substring(8,9);


    try {
        numero=Integer.valueOf(dniSinLetra);
    } catch (NumberFormatException e){
        return false;
    }   
        
        numero=numero%23;
       

        if (numero > 22 || numero < 0){
            dniCorrecto=false;
        } else if(codigoControl[numero].equalsIgnoreCase(letraDni)) {
            dniCorrecto=true;}
         else dniCorrecto=false;
        
       return dniCorrecto;
        }


public static void main(String[] args){


Scanner teclado = new Scanner (System.in);
String respuesta;
System.out.print("Introduce número de DNI: ");
respuesta = teclado.nextLine();

if(comprobarDNI(respuesta)){
    System.out.println("El DNI introducido es correcto");
} else {
    System.out.println("El DNI introducido es incorrecto");
}

teclado.close();

}


}