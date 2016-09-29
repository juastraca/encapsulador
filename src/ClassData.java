
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Clase que mantiene los datos necesarios para generar el POJO
 *
 * @author Enrique
 */
public class ClassData extends AbstractClassData {

    private static final Logger log = Logger.getLogger(ClassData.class.getCanonicalName());
    private ResultSetMetaData rsmd;
    private StringBuilder mapeo;
    private StringBuilder toString;

    /**
     *
     * @param c
     */
    public ClassData(ClassGenerator c) {
        super(c);
    }

    public ClassData() {

    }

    @Override
    public String getText() {
        mapeo = new StringBuilder("HashMap<String, String> columToProp = new HashMap<String, String>();\n");
        toString = new StringBuilder("StringBuffer toStr = new StringBuffer();\n");
        createClassDefinitions();

        createClassMethods();
//genera código de conexion
        //FIXME:
        //if (this.chkCodigodeConexion.isSelected()) {
        //    salida = generarCodigodeConexion(salida, nombres, tipos);
        //}

        return super.getText();
    }

    private void createClassMethods() {
        // crea getters y setters
        for (int i = 0; i < nombres.size(); i++) {

            String nombreFuncionGet = "public " + tipos.get(i) + " get" + nombres.get(i).substring(0, 1).toUpperCase() + nombres.get(i).substring(1) + "()";
            String nombreFuncionSet = "public void set" + nombres.get(i).substring(0, 1).toUpperCase() + nombres.get(i).substring(1) + "(" + tipos.get(i) + " valor)";
            salida.append("/**\n")
                    .append("* devuelve ")
                    .append(nombres.get(i))
                    .append(".\n* @return ")
                    .append(nombres.get(i))
                    .append("\n*/\n");

            salida.append(nombreFuncionGet);
            salida.append("{\n\t return ").append(nombres.get(i)).append(";\n}");

            salida.append('\n');
            salida.append("/**\n")
                    .append("* establece el valor de ")
                    .append(nombres.get(i))
                    .append(".\n *@param valor nuevo valor")
                    .append("\n*/\n");
            salida.append(nombreFuncionSet);
            salida.append("{\n\t");
            salida.append(nombres.get(i)).append(" = valor;\n}\n");

        }

        salida.append("\n/**\n").
                append("* devuelve la realacion entre columnas y propiedades.\n")
                .append("*\n")
                .append("* @return Map con la relacion\n")
                .append("*/\n");
        salida.append("public static Map<String, String> getColumToProperty() {\n");
        mapeo.append("\n return columToProp;\n");
        salida.append(mapeo.toString());
        salida.append("\n}");
        salida.append("\n@Override\n");
        salida.append("public String toString() {\n");
        salida.append(toString.toString());
        salida.append("\n return toStr.toString().replaceAll(\"null\", \"\");\n ");
        salida.append("\n}\n}");

    }

    private void createClassDefinitions() {
        //crea la definicion de campos, metodo mapeo y toString
        salida.append("public class ").append(getClassName()).append(" { \n");
        for (int i = 0; i < nombres.size(); i++) {
            salida.append("@Column(name=\"");
            salida.append(columnas.get(i))
                    .append("\")\n");
            salida.append("private ");
            salida.append(tipos.get(i));
            salida.append(' ');
            salida.append(nombres.get(i));
            salida.append(";");
            salida.append('\n');

            mapeo.append("columToProp.put(\"")
                    .append(columnas.get(i))
                    .append("\", ");
            mapeo.append("\"")
                    .append(nombres.get(i))
                    .append("\");\n");
            toString.append("toStr.append(");
            toString.append(nombres.get(i));
            toString.append(");\n");
            toString.append("toStr.append('");
            toString.append(COMA);
            toString.append("');\n");

        }
    }

    private String convertirDatoJava(String tipoDato) {
        String result = null;

        if (this.getConversion().get(tipoDato) != null) {
            result = (String) this.getConversion().get(tipoDato);
        }
        return result;

    }

    private String convertirNombreColumna(String cname) {
        cname = cname.toLowerCase();
        int lastIndex = 0;
        int index = 0;
        while (index >= 0) {
            index = cname.indexOf("_");
            if (index >= 0) {
                String tmp = cname.substring(0, index);
                lastIndex = index + 1;
                String tail = cname.substring(lastIndex);

                char first = Character.toUpperCase(tail.charAt(0));
                tail = first + tail.substring(1);
                cname = tmp + first + tail.substring(1);

            }
        }
        return cname;
    }

    private String getTipoColumnaFromMetadata(String tipoColumna, ResultSetMetaData rsmd, int i) throws SQLException {
        tipoColumna = rsmd.getColumnClassName(i);
        tipoColumna = tipoColumna.substring(tipoColumna.lastIndexOf('.') + 1);
        return tipoColumna;
    }

    @Override
    public void prepareData() throws Exception {
        //prepara datos
        for (int i = 1; i <= rsmd.getColumnCount(); i++) {

            String nombreColumna = rsmd.getColumnName(i);

            String tipoColumna = rsmd.getColumnTypeName(i);
            log.finest(tipoColumna);
            try {

                switch (getGenerationMode()) {
                    case NORMAL:
                        tipoColumna = getTipoColumnaFromMetadata(tipoColumna, rsmd, i);
                        break;
                    case INTERNAL:
                        tipoColumna = convertirDatoJava(tipoColumna);
                        if (tipoColumna == null) {
                            tipoColumna = getTipoColumnaFromMetadata(tipoColumna, rsmd, i);
                        }
                        break;
                    case STRING:
                        tipoColumna = "String";
                        break;
                    default:
                        throw new AssertionError();
                }

            } catch (Exception rara) {
                tipoColumna = convertirDatoJava(tipoColumna);
            }

            getNombres().add(convertirNombreColumna(nombreColumna));
            getColumnas().add(nombreColumna);
            getTipos().add(tipoColumna);
        }
    }

    /**
     * @param rsmd the rsmd to set
     */
    public void setRsmd(ResultSetMetaData rsmd) {
        this.rsmd = rsmd;
    }

}
