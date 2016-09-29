
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
    
    private HashMap<String, String> conversion = new HashMap<>();

    @Override
    public String getText() {
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
    public HashMap<String, String> getConversion() {
        return conversion;
    }

    /**
     * @param conversion the conversion to set
     */
    public void setConversion(HashMap<String, String> conversion) {
        this.conversion = conversion;
    }
    
}
