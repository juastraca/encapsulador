
import java.util.ArrayList;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Enrique
 */
public abstract class AbstractClassData implements ClassGenerator {
    
    protected ArrayList<String> nombreAtributosJava;
    protected ArrayList<String> tipoAtributosJava;
    protected ArrayList<String> nombreColumnasSql;
    
    protected StringBuilder salida = new StringBuilder();
    protected ClassGenerator generator;
    private GenerationMode generationMode;
    private String className;
    
    public AbstractClassData(ClassGenerator cg){
            this.generator = cg;
            
    }
    
    public AbstractClassData(){
        
    }
    
    protected void reset(){
        setNombreAtributosJava(new ArrayList<String>());
        setTipoAtributosJava(new ArrayList<String>());
        setNombreColumnasSql(new ArrayList<String>());
       
        salida = new StringBuilder();
    }
    
    @Override
    public HashMap<String, String> getConversionTiposSqlToJava(){
        return generator.getConversionTiposSqlToJava();
    }

    @Override
    public String getClassText() {
        return salida.toString();
    }

    /**
     * @return the nombreAtributosJava
     */
    public ArrayList<String> getNombreAtributosJava() {
        return nombreAtributosJava;
    }

    /**
     * @param nombreAtributosJava the nombreAtributosJava to set
     */
    public void setNombreAtributosJava(ArrayList<String> nombreAtributosJava) {
        this.nombreAtributosJava = nombreAtributosJava;
    }

    /**
     * @return the tipoAtributosJava
     */
    public ArrayList<String> getTipoAtributosJava() {
        return tipoAtributosJava;
    }

    /**
     * @param tipoAtributosJava the tipoAtributosJava to set
     */
    public void setTipoAtributosJava(ArrayList<String> tipoAtributosJava) {
        this.tipoAtributosJava = tipoAtributosJava;
    }

    /**
     * @return the nombreColumnasSql
     */
    public ArrayList<String> getNombreColumnasSql() {
        return nombreColumnasSql;
    }

    /**
     * @param nombreColumnasSql the nombreColumnasSql to set
     */
    public void setNombreColumnasSql(ArrayList<String> nombreColumnasSql) {
        this.nombreColumnasSql = nombreColumnasSql;
    }

   

    /**
     * @return the generationMode
     */
    public GenerationMode getGenerationMode() {
        return generationMode;
    }

    /**
     * @param generationMode the generationMode to set
     */
    public void setGenerationMode(GenerationMode generationMode) {
        this.generationMode = generationMode;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className the className to set
     */
    public void setClassName(String className) {
        this.className = className;
    }
    
}
