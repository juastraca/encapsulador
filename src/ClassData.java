
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.logging.Logger;



/**
 * Clase que mantiene los datos necesarios para generar el POJO
 * @author Enrique
 */
public class ClassData {
        
    private ArrayList<String> nombres;
    private ArrayList<String> tipos;
    private ArrayList<String> columnas;
    
    private static final Logger log = Logger.getLogger(ClassData.class.getCanonicalName());
    
    public ClassData(ResultSetMetaData rsmd){
        
         //prepara datos
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            
            String nombreColumna = rsmd.getColumnName(i);
            
            String tipoColumna = rsmd.getColumnTypeName(i);
            log.finest(tipoColumna);
            if (!this.chktipo.isSelected()) { //todos como String
                try {
                    if (!this.chkConversionInterna.isSelected()) {
                        
                        tipoColumna = getTipoColumnaFromMetadata(tipoColumna, rsmd, i);
                    } else {
                        tipoColumna = convertirDatoJava(tipoColumna);
                        if(tipoColumna == null){
                            tipoColumna = getTipoColumnaFromMetadata(tipoColumna, rsmd, i);
                        }
                    }
                } catch (Exception rara) {
                    tipoColumna = convertirDatoJava(tipoColumna);
                }
            } else {
                tipoColumna = "String";
            }
            
            nombres.add(convertirNombreColumna(nombreColumna));
            columnas.add(nombreColumna);
            tipos.add(tipoColumna);
        }
        
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
    
}
