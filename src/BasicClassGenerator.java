
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
public class BasicClassGenerator implements ClassGenerator{
    
    private HashMap<String, String> conversionTiposSqlToJava = new HashMap<>();

    @Override
    public String getClassText() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void prepareData() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the conversion
     */
    @Override
    public HashMap<String, String> getConversionTiposSqlToJava() {
        return conversionTiposSqlToJava;
    }

    /**
     * @param conversionTiposSqlToJava the conversion to set
     */
    public void setConversionTiposSqlToJava(HashMap<String, String> conversionTiposSqlToJava) {
        this.conversionTiposSqlToJava = conversionTiposSqlToJava;
    }
    
}
