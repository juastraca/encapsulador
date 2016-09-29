
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
public interface ClassGenerator {
    
    public static final char COMA = ',';
    public String getText();
    public void prepareData() throws Exception;
    public HashMap<String, String> getConversion();
    
}
