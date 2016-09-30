/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Enrique
 */
public class PairValueClass extends AbstractClassData {
    
    private String tokenizedRawData;

    @Override
    public void prepareData() throws Exception {
        
        String[] nameTypePairs = tokenizedRawData.split(String.valueOf(COMA));
        int max = nameTypePairs.length;
        

        for (int i = 0; i < max; i++) {

            String nombreColumna = nameTypePairs[i];
            String tipoColumna = nameTypePairs[i];
            
            getNombreAtributosJava().add(nombreColumna);
            getTipoAtributosJava().add(tipoColumna);
            
        }
    }
    
    private void createClassDefinitions() {
        salida.append("public class ").append(getClassName()).append(" { \n");
        for (int i = 0; i < getNombreAtributosJava().size(); i++) {
            salida.append("private");
            salida.append(getTipoAtributosJava().get(i));
            salida.append(' ');
            salida.append(getNombreAtributosJava().get(i));
            salida.append(" = null;");
            salida.append('\n');

        }

        for (int i = 0; i < getNombreAtributosJava().size(); i++) {
	
            String capitalizedPropertyName = capitalizeWord(getNombreAtributosJava().get(i));
            String nombreFuncionGet = "public final " + getTipoAtributosJava()
                    .get(i) + " get" + capitalizedPropertyName + "()";
            String nombreFuncionSet = "public final void set" 
                    + capitalizedPropertyName + "(" 
                    + getTipoAtributosJava().get(i) + " valor )";
            salida.append(nombreFuncionGet);
            salida.append("{\n return ").append( getNombreAtributosJava()
                    .get(i)).append( ";\n}");
            salida.append('\n');
            salida.append(nombreFuncionSet);
            salida.append("{\n");
            salida.append(getNombreAtributosJava().get(i)).append(" = valor;\n}\n");

        }

        salida.append("\n}");
        salida.append("// para superclase del bean\n");
    }
    
    private String capitalizeWord(String word){
         return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    /**
     * @param tokenizedRawData the tokenizedRawData to set
     */
    public void setTokenizedRawData(String tokenizedRawData) {
        this.tokenizedRawData = tokenizedRawData;
    }
    
}
