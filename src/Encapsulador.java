/*
 * Encapsulador.java
 *
 * Created on 9 de enero de 2002, 17:03
 */

/**
 *
 * @author edtrobo
 * @version
 */
import java.awt.Cursor;
import java.awt.FileDialog;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Logger;

public class Encapsulador extends javax.swing.JFrame {

    /**
     * Creates new form Encapsulador
     */
    private Connection conn; 
    
    private static final Logger log = Logger.getLogger(Encapsulador.class.getCanonicalName());
    private ClassGenerator basicGenerator = new BasicClassGenerator();
    
    
    
    

    public Encapsulador() {
        initComponents();
        this.setBounds(10, 10, 800, 500);

        System.out.println(System.getProperty("user.dir"));
        loadDatabaseConnProps(System.getProperty("user.dir"));
        try{
        cargarConfiguracionSqlToJava(this.abreFicheroConfiguracion(System.getProperty("user.dir") + "\\conv.txt"));
        }catch(Exception e){
            status.setText("Error cargando fichero de conversion de tipos (conv.txt");
            this.chkConversionInterna.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the FormEditor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtcontrolador = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        txturl = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtpassw = new javax.swing.JTextField();
        btnconectar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtsalida = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtconsulta = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btncadena = new javax.swing.JButton();
        status = new javax.swing.JLabel();
        txtNombreClase = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        optMenu = new javax.swing.JMenu();
        chkFicherito = new javax.swing.JCheckBoxMenuItem();
        claseMenu = new javax.swing.JMenu();
        chktipo = new javax.swing.JCheckBoxMenuItem();
        chkConversionInterna = new javax.swing.JCheckBoxMenuItem();
        chkMyBatis = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();

        setTitle("Encapsulador");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });
        getContentPane().setLayout(null);

        txtcontrolador.setText("oracle.jdbc.driver.OracleDriver");
        txtcontrolador.setToolTipText("");
        txtcontrolador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontroladorActionPerformed(evt);
            }
        });
        getContentPane().add(txtcontrolador);
        txtcontrolador.setBounds(10, 30, 180, 20);

        jLabel1.setText("Controlador");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 10, 90, 20);

        jLabel2.setText("Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 60, 70, 20);

        txtusuario.setText("US_PREDICTORESOWNER");
        getContentPane().add(txtusuario);
        txtusuario.setBounds(10, 80, 180, 20);

        txturl.setText("jdbc:oracle:thin:@servidor:puerto:sid");
        txturl.setToolTipText("");
        txturl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txturlActionPerformed(evt);
            }
        });
        getContentPane().add(txturl);
        txturl.setBounds(210, 30, 180, 20);

        jLabel3.setText("URL");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(210, 10, 120, 10);

        jLabel4.setText("Contraseña");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(210, 60, 70, 20);

        txtpassw.setToolTipText("");
        getContentPane().add(txtpassw);
        txtpassw.setBounds(210, 80, 170, 20);

        btnconectar.setText("Generar Letras");
        btnconectar.setToolTipText("Genera todas las letras necesarias para formar la clase");
        btnconectar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnconectarclic(evt);
            }
        });
        getContentPane().add(btnconectar);
        btnconectar.setBounds(410, 80, 130, 30);

        jScrollPane1.setViewportView(txtsalida);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(320, 120, 400, 220);

        jScrollPane4.setViewportView(txtconsulta);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(10, 120, 290, 220);

        jLabel5.setText("SQL/Texto");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 100, 140, 20);

        btncadena.setText("Normalizar Cadena");
        btncadena.setToolTipText("Dale, que es bueno");
        btncadena.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btncadenaclic(evt);
            }
        });
        getContentPane().add(btncadena);
        btncadena.setBounds(20, 350, 150, 20);
        getContentPane().add(status);
        status.setBounds(180, 350, 370, 50);

        txtNombreClase.setText("PonElNombre");
        getContentPane().add(txtNombreClase);
        txtNombreClase.setBounds(410, 30, 100, 20);

        jLabel6.setText("Nombre de la clase");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(410, 10, 110, 14);

        fileMenu.setText("Archivo");

        openMenuItem.setText("Abrir");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);

        saveMenuItem.setText("Guardar");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setText("Guardar Como...");
        saveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setText("Salir");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        optMenu.setText("Opciones");

        chkFicherito.setText("Generar clase a partir de texto");
        chkFicherito.setToolTipText("Poner campo,tipo en el panel SQL/Texto");
        optMenu.add(chkFicherito);

        menuBar.add(optMenu);

        claseMenu.setText("Clase");

        chktipo.setText("Todos como String");
        chktipo.setToolTipText("Hace que todas las propiedades sean String");
        chktipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chktipoActionPerformed(evt);
            }
        });
        claseMenu.add(chktipo);

        chkConversionInterna.setText("Forzar conversion interna de datos");
        chkConversionInterna.setToolTipText("No emplear los tipos java devueltos por la base de datos");
        claseMenu.add(chkConversionInterna);

        chkMyBatis.setText("Generar ResultMap para MyBatis");
        chkMyBatis.setActionCommand("Generar ResultMap para MyBatis");
        chkMyBatis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMyBatisActionPerformed(evt);
            }
        });
        claseMenu.add(chkMyBatis);

        menuBar.add(claseMenu);

        helpMenu.setText("Ayuda");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        javax.swing.JFrame ayuda = new javax.swing.JFrame("Ayuda");

        javax.swing.JTextArea text = new javax.swing.JTextArea();
        javax.swing.JScrollPane scr = new javax.swing.JScrollPane(text);
        ayuda.getContentPane().setLayout(null);

        scr.setBounds(10, 10, 400, 300);
        ayuda.setContentPane(scr);

        text.setText(this.abreFicheroConfiguracion(System.getProperty("user.dir") + "\\ayu.txt"));
        ayuda.pack();
        ayuda.show();
        ayuda.setBounds(50, 50, 400, 300);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

  private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
      cmdAbrir();
  }//GEN-LAST:event_openMenuItemActionPerformed

  private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsMenuItemActionPerformed
      cmdGuardar();
  }//GEN-LAST:event_saveAsMenuItemActionPerformed

  private void btnconectarclic(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnconectarclic
    

      try {
            if (this.chkFicherito.isSelected()) {
          crearClase();
          return;
      }
          Class.forName(this.txtcontrolador.getText());

          conn = java.sql.DriverManager.getConnection(this.txturl.getText(),
                  this.txtusuario.getText(),
                  this.txtpassw.getText());
          realizarConsulta(conn);
          cerrar();
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println(e.toString());
          this.status.setText(e.toString());
      }


  }//GEN-LAST:event_btnconectarclic

  private void btncadenaclic(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncadenaclic

      String saux = txtconsulta.getText();
      txtconsulta.setText(" ");

      this.txtconsulta.setText(Cadena.normalizarCadena(saux));


  }//GEN-LAST:event_btncadenaclic

  private void chktipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chktipoActionPerformed
      // Add your handling code here:
  }//GEN-LAST:event_chktipoActionPerformed

    private void exitMenuItemActionPerformed (java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    private void txtcontroladorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontroladorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcontroladorActionPerformed

    private void txturlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txturlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txturlActionPerformed

    private void chkMyBatisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMyBatisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMyBatisActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        new Encapsulador().show();
    }

    private void cerrar() {
        try {
            conn.close();
            //btnconectar.setText("Conectar");
        } catch (Exception e) {
        }
    }

    private void crearClase(ResultSet rs) throws Exception {
       
       ResultSetMetaData rsmd = rs.getMetaData();
       ClassData cd = ConfigureClassGenerator(rsmd);
        this.txtsalida.setText(cd.getClassText());

    }


    private ClassData ConfigureClassGenerator(ResultSetMetaData rsmd) throws Exception {
        ClassData cd = new ClassData(basicGenerator);
        cd.reset();
        cd.setRsmd(rsmd);
        cd.setClassName(this.txtNombreClase.getText());
        if(this.chkConversionInterna.isSelected()){
            cd.setGenerationMode(GenerationMode.INTERNAL);
        }
        else if(chktipo.isSelected()){
            cd.setGenerationMode(GenerationMode.STRING);
        }
        else{
            cd.setGenerationMode(GenerationMode.NORMAL);
        }cd.prepareData();
        
        cd.setMyBatisGenerator(chkMyBatis.isSelected());
        
        return cd;
    }

   

    private void crearClase() throws Exception {
        
        PairValueGenerator generator = new PairValueGenerator(basicGenerator);
        generator.setTokenizedRawData(this.txtconsulta.getText());
        generator.prepareData();
        generator.setClassName(this.txtNombreClase.getText());
        this.txtsalida.setText(generator.getClassText());

    }

   

    private void realizarConsulta(Connection conn) {

        ResultSet rs = null;
        try {
            Statement st = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            st.setMaxRows(1);
            rs = st.executeQuery(this.txtconsulta.getText());
        } catch (Exception e) {
            System.out.println(e.toString());
            this.status.setText(e.toString());
        }
        try {
            crearClase(rs);
        } catch (Exception e) {
            System.out.println(e.toString());
            this.status.setText(e.toString());
            e.printStackTrace();
        }

    }

    private void cmdGuardar() {
        FileDialog file = new FileDialog(this, "Guardar", FileDialog.SAVE);
        file.show(); // Blocks
        String curFile;
        if ((curFile = file.getFile()) != null) {
            String filename = file.getDirectory() + curFile;
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            File f = new File(filename);
            try {
                try (FileWriter fw = new FileWriter(f)) {
                    String text = txtsalida.getText();
                    int textsize = text.length();
                    fw.write(txtsalida.getText(), 0, textsize);
                }
                status.setText("Guardado: " + filename);
            } catch (IOException exc) {
                status.setText("IOException: " + filename);
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private void cmdAbrir() {
        FileDialog file = new FileDialog(this, "Abrir archivo", FileDialog.LOAD);
        file.setFile("*.java;*.txt");
        file.show();
        String curFile;
        if ((curFile = file.getFile()) != null) {
            String filename = file.getDirectory() + curFile;
            char[] data;
            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            File f = new File(filename);
            try {
                FileReader fin = new FileReader(f);
                int filesize = (int) f.length();
                data = new char[filesize];
                fin.read(data, 0, filesize);
                txtconsulta.setText(new String(data));
                status.setText("Cargado: " + filename);
            } catch (FileNotFoundException exc) {
                status.setText("Archivo no encontrado: " + filename);
            } catch (IOException exc) {
                status.setText("IOException: " + filename);
            }
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        }
    }

    private String abreFicheroConfiguracion(String archivo) {
        String linea;
        String retorno = null;
        String stError = "Fichero de configuracion no disponible o ruta incorrecta";
        
        StringBuilder arch = new StringBuilder();
        final String INDICA_COMENTARIO = "/*";

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            File fichero = new File(archivo);
            
            if (fichero.exists()) {
                while ((linea = br.readLine()) != null) {
                    stError = "";
                    linea = linea.trim();
                    if ((linea.length() > 0) && !linea.startsWith(INDICA_COMENTARIO)) {
                        {
                            arch.append(linea).append('\n');
                        }
                    } // if linea con datos
                } // Fin fichero
                retorno = arch.toString();
                br.close();

            }

        } catch (Exception e) {
            stError = "\nException " + e + stError;

        } finally {
            if (!"".equals(stError)) {
                this.status.setText(stError);
            }
            return retorno;
        }
    }

    private void cargarConfiguracionSqlToJava(String contenidoArchivo) {
       
        if (contenidoArchivo != null) {
            String contenidoNormalizado = Cadena.normalizarCadena(contenidoArchivo);
            String[] tokens = contenidoNormalizado.split(",");
            int max = tokens.length;
            for (int i = 0; i < max; i++) {

                String nombreSQL = tokens[i];
                i++;
                String nombreJava = tokens[i];
                this.basicGenerator.getConversionTiposSqlToJava().put(nombreSQL, nombreJava);
            }
        } else {
            this.chkConversionInterna.setEnabled(false);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton btncadena;
    private javax.swing.JButton btnconectar;
    private javax.swing.JCheckBoxMenuItem chkConversionInterna;
    private javax.swing.JCheckBoxMenuItem chkFicherito;
    private javax.swing.JCheckBoxMenuItem chkMyBatis;
    private javax.swing.JCheckBoxMenuItem chktipo;
    private javax.swing.JMenu claseMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenu optMenu;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JLabel status;
    private javax.swing.JTextField txtNombreClase;
    private javax.swing.JTextArea txtconsulta;
    private javax.swing.JTextField txtcontrolador;
    private javax.swing.JTextField txtpassw;
    private javax.swing.JTextArea txtsalida;
    private javax.swing.JTextField txturl;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables

  

    private void loadDatabaseConnProps(String dir) {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            String filename = "config.properties";
            input = new FileInputStream(dir + "/config.properties");
            if (input == null) {
                System.out.println("No encuentro " + filename);
                return;
            }

            prop.load(input);

            txtcontrolador.setText(prop.getProperty("controlador"));
            txturl.setText(prop.getProperty("url"));
            txtusuario.setText(prop.getProperty("usuario"));
            txtpassw.setText(prop.getProperty("password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
