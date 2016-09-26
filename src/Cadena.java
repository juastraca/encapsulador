/*
 * Cadena.java
 *
 * Created on 2 de enero de 2002, 16:11
 */






/** Clase con diversas utilidades para cadenas
 *
 * @author edtrobo
 * @version 1.0
 */
public class Cadena extends java.lang.Object {
    
        
    /** <PRE>Esta funci�n deja la cadena como te gustar�a recibirla; a saber:
     * -Quita espacios iniciales y finales
     * -Quita espacios repetidos
     * -Quita retornos de carro y tabuladores
     * -Pega los signos de puntuacion a la palabra anterior
     * -Pega los signos de cierre a la palabra anterior
     * -Separa los signos de apertura de la palabra anterior
     *
     * ejemplo:
     *
     * String cadena = normalizarCadena("   cadena\n       .  �  normal y normalizada         ?  ");
     *
     * devuelve: cadena. normal y normalizada?</PRE>
     *
     *
     * @param cadena la cadena que se desea normalizar
     * @return la cadena normalizada
     */
    
    public static String normalizarCadena(String cadena) {
        
        StringBuffer nuevaCadena = new StringBuffer();
        final String SIMBOLOS_CIERRE = "?,;:.)}";
        final String SIMBOLOS_APERTURA = "{(";
        final char ESPACIO = ' ';
        
        final String SIMBOLOS_A_QUITAR = "\n\t\r";
        char charanterior;
        char charactual;
        char [] ccad;
        String tmpcad  = cadena.trim();
        charanterior = '@';
        
        String cadenaQuitados = "";
        for(int i = 0; i< tmpcad.length(); i++){
            
            
            if(SIMBOLOS_A_QUITAR.indexOf(tmpcad.charAt(i))==-1)
            {
                cadenaQuitados = cadenaQuitados + tmpcad.charAt(i);
                
            }
        }
        ccad = new char[cadenaQuitados.length()];
        
        for(int i = 0; i< cadenaQuitados.length(); i++){
            
            ccad[i] = cadenaQuitados.charAt(i);
            
        }
        
        for(int i = 0; i < ccad.length; i++){
            charactual = ccad[i];
            if(SIMBOLOS_APERTURA.indexOf(charactual)!=-1) { //es simbolo de apertura
                if(charanterior != ESPACIO){
                    nuevaCadena.append(' ');
                }
                
                
                nuevaCadena.append(charactual);
                
                
            }else{ /*no es apertura*/
                
                if(SIMBOLOS_CIERRE.indexOf(charactual)!=-1) { //es simbolo de cierre
                    if(charanterior == ESPACIO){
                        nuevaCadena = new StringBuffer(nuevaCadena.toString().trim());
                    }
                    nuevaCadena.append(charactual);
                }else{ //no es simbolo de cierre
                    if(charactual == ESPACIO){
                        if((charanterior != ESPACIO) && (SIMBOLOS_APERTURA.indexOf(charanterior)==-1)){
                            nuevaCadena.append(charactual);
                        }
                    }else{ //no es ni apertura ni cierre ni espacio ni nada
                        nuevaCadena.append(charactual);
                    }
                }
                
            }
            
            
            charanterior = charactual;
            
        }
        return nuevaCadena.toString();
    }
    /** Esta funcion te llena una cadena con el caracter que quieras hasta
 el tamaño deseado.     *
     * Ejemplo:
     * llenarCon('0',"3",3,'A'));
     * devuelve 003
     * @param caracter poner un char con el quieres hacer el relleno
     * @param numero normalmente es para numeros, poner aqui un String
     * con el numero o lo que sea.

	 * @param tamanyoFinal Poner aqui un int con el tamaño final que deseas     * para la cadena
     * @param AntesDespues Poner aqui un char con 'A' o 'D'
     * @return Cadena con el relleno
     */
    public static String llenarCon(char caracter, String numero, int tamanyoFinal, char AntesDespues)
    {
        StringBuilder ceros = new StringBuilder();
        
        
        for(int i = 0; i < (tamanyoFinal - numero.length()); i++)
        {
            ceros.append(caracter);
        }
        if (AntesDespues == 'D')
        {
            ceros.insert(0, numero);
        }else
        {
            ceros.append(numero);
        }
        return ceros.toString();
    }
    
    
    
    public static void main(String args[]) throws Exception
    {
        String cadena = normalizarCadena("   cadena       .  normal y normalizada         ?  ");
        System.out.println(cadena);
        System.out.println(llenarCon('0',"01",2,'D'));
        
    }
    
}
