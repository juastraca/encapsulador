
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
    
    protected ArrayList<String> nombres;
    protected ArrayList<String> tipos;
    protected ArrayList<String> columnas;
    
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
        setNombres(new ArrayList<String>());
        setTipos(new ArrayList<String>());
        setColumnas(new ArrayList<String>());
       
        salida = new StringBuilder();
    }
    
    @Override
    public HashMap<String, String> getConversion(){
        return generator.getConversion();
    }

    @Override
    public String getText() {
        return salida.toString();
    }

    /**
     * @return the nombres
     */
    public ArrayList<String> getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(ArrayList<String> nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the tipos
     */
    public ArrayList<String> getTipos() {
        return tipos;
    }

    /**
     * @param tipos the tipos to set
     */
    public void setTipos(ArrayList<String> tipos) {
        this.tipos = tipos;
    }

    /**
     * @return the columnas
     */
    public ArrayList<String> getColumnas() {
        return columnas;
    }

    /**
     * @param columnas the columnas to set
     */
    public void setColumnas(ArrayList<String> columnas) {
        this.columnas = columnas;
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
