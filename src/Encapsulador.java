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

public class Encapsulador extends javax.swing.JFrame {

	/**
	 * Creates new form Encapsulador
	 */
    Connection conn = null;
    private final char COMA = ',';
	/**
	 * has
	 */
	Hashtable conversion = new Hashtable();

	public Encapsulador() {
		initComponents();
		this.setBounds(10, 10, 800, 500);

		System.out.println(System.getProperty("user.dir"));
		cargarConfiguracion(this.abreFicheroConfiguracion(System.getProperty("user.dir") + "\\conv.txt"));
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code.
	 * The content of this method is always regenerated by the FormEditor.
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
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        optMenu = new javax.swing.JMenu();
        chkFicherito = new javax.swing.JCheckBoxMenuItem();
        chkConversionExacta = new javax.swing.JCheckBoxMenuItem();
        claseMenu = new javax.swing.JMenu();
        chktipo = new javax.swing.JCheckBoxMenuItem();
        chkConversionInterna = new javax.swing.JCheckBoxMenuItem();
        chkCodigodeConexion = new javax.swing.JCheckBoxMenuItem();

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
        status.setBounds(180, 350, 410, 50);

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

        editMenu.setText("Edición");

        cutMenuItem.setText("Cortar");
        editMenu.add(cutMenuItem);

        copyMenuItem.setText("Copiar");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setText("Pegar");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setText("Borrar");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setText("Ayuda");

        aboutMenuItem.setText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        optMenu.setText("Opciones");

        chkFicherito.setText("Generar clase a partir de texto");
        chkFicherito.setToolTipText("Poner campo,tipo en el panel SQL/Texto");
        optMenu.add(chkFicherito);

        chkConversionExacta.setText("Emplear conversion Exacta de tipos");
        chkConversionExacta.setToolTipText("Emplea los tipos del fichero de configuracion");
        optMenu.add(chkConversionExacta);

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

        chkCodigodeConexion.setText("Generar codigo de conexión");
        chkCodigodeConexion.setToolTipText("Te genera gratis el codigo para poner valores a los campos");
        claseMenu.add(chkCodigodeConexion);

        menuBar.add(claseMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
	    javax.swing.JFrame ayuda = new javax.swing.JFrame("Ayuda");

	    javax.swing.JTextArea text = new javax.swing.JTextArea();
	    javax.swing.JScrollPane scr = new javax.swing.JScrollPane(text);
	    ayuda.getContentPane().setLayout(null);

	    //ayuda.getContentPane().add(text);

	    //scr.setViewportView(text);
	    //ayuda.getContentPane().add(scr);
	    scr.setBounds(10, 10, 400, 300);
	    ayuda.setContentPane(scr);
	    //scr.add(text);
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
	  if (this.chkFicherito.isSelected()) {
		  crearClase();
		  return;
	  }


	  try {
		  Class.forName(this.txtcontrolador.getText());

		  conn = java.sql.DriverManager.getConnection(this.txturl.getText(),
			  this.txtusuario.getText(),
			  this.txtpassw.getText());
		  realizarConsulta(conn);
		  cerrar();
	  } catch (Exception e) {
		  System.out.println(e.toString());
		  this.status.setText(e.toString());
	  }





  }//GEN-LAST:event_btnconectarclic

  private void btncadenaclic(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncadenaclic

	  Cadena cadena = new Cadena();
	  
	  String saux = txtconsulta.getText();
	  txtconsulta.setText(" ");

	  this.txtconsulta.setText(cadena.normalizarCadena(saux));










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

		Hashtable ht;
		ResultSetMetaData rsmd;

                //TODO: Cambiar a arraylist, esto es de hace mil años...
		Vector nombres = new Vector();
		Vector tipos = new Vector();
		rsmd = rs.getMetaData();
		Vector tiposJava = new Vector();
		ArrayList<String> columnas = new ArrayList<>();


		StringBuffer salida = new StringBuffer();
		StringBuffer mapeo = new StringBuffer("HashMap<String, String> columToProp = new HashMap<String, String>();\n");
        StringBuffer toString = new StringBuffer("StringBuffer toStr = new StringBuffer();\n");


		salida.append("public class " + this.txtNombreClase.getText() + " { \n");
		



		for (int i = 1; i <= rsmd.getColumnCount(); i++) {

			String nombreColumna = rsmd.getColumnName(i);


			String tipoColumna = rsmd.getColumnTypeName(i);
			if (this.chktipo.isSelected() == false) {
				try {
					if (!this.chkConversionInterna.isSelected()) {
						//tipoColumna = rs.getObject(nombreColumna).getClass().getName();
						tipoColumna = rsmd.getColumnClassName(i);
						tipoColumna = tipoColumna.substring(tipoColumna.lastIndexOf('.') + 1);
					} else {
						tipoColumna = convertirDatoJava(tipoColumna);
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

		for (int i = 0; i < nombres.size(); i++) {
			salida.append("@Column(name=\"");
			salida.append(columnas.get(i))
				.append("\")\n");
			salida.append("private ");
			salida.append(tipos.elementAt(i));
			salida.append(' ');
			salida.append(nombres.elementAt(i).toString());
			salida.append(";");
			salida.append('\n');

			mapeo.append("columToProp.put(\"")
				.append(columnas.get(i))
				.append("\", ");
			mapeo.append("\"")
				.append(nombres.elementAt(i).toString())
                    .append("\");\n");
            toString.append("toStr.append(");
            toString.append(nombres.elementAt(i).toString());
            toString.append(");\n");
            toString.append("toStr.append('");
            toString.append(COMA);
            toString.append("');\n");



		}

		for (int i = 0; i < nombres.size(); i++) {
			
			String nombreFuncionGet = "public " + tipos.elementAt(i).toString() + " get" + nombres.elementAt(i).toString().substring(0, 1).toUpperCase() + nombres.elementAt(i).toString().substring(1) + "()";
			String nombreFuncionSet = "public void set" + nombres.elementAt(i).toString().substring(0, 1).toUpperCase() + nombres.elementAt(i).toString().substring(1) + "(" + tipos.elementAt(i).toString() + " valor)";
			salida.append("/**\n")
				.append("* devuelve ")
				.append(nombres.elementAt(i))
				.append(".\n* @return ")
				.append(nombres.elementAt(i))
				.append("\n*/\n");

			salida.append(nombreFuncionGet);
            salida.append("{\n\t return " + nombres.elementAt(i).toString() + ";\n}");

			salida.append('\n');
			salida.append("/**\n")
				.append("* establece el valor de ")
				.append(nombres.elementAt(i))
				.append(".\n *@param valor nuevo valor")
				.append("\n*/\n");
			salida.append(nombreFuncionSet);
            salida.append("{\n\t");
			salida.append(nombres.elementAt(i).toString() + " = valor;\n}\n");


		}
		if (this.chkCodigodeConexion.isSelected()) {

			salida = generarCodigodeConexion(salida, nombres, tipos);
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
		
		this.txtsalida.setText(salida.toString());

	}

	private void crearClase() {

		Hashtable ht;

		Vector nombres = new Vector();
		Vector tipos = new Vector();
		Vector tiposJava = new Vector();


		StringBuffer salida = new StringBuffer();
		salida.append("public class " + this.txtNombreClase.getText() + " { \n");
		//salida.append("public PonElNombre(){\n}");

		StringTokenizer st = new StringTokenizer(this.txtconsulta.getText(), ",");


		for (int i = 0; i <= st.countTokens(); i++) {

			String nombreColumna = st.nextToken();
			String tipoColumna = st.nextToken();
			if (this.chktipo.isSelected()) {

				tipoColumna = "String";
			}

			nombres.add(nombreColumna);
			tipos.add(tipoColumna);
		}

		for (int i = 0; i < nombres.size(); i++) {
			salida.append("private");
			salida.append(tipos.elementAt(i));
			salida.append(' ');
			salida.append(nombres.elementAt(i).toString().toLowerCase());
			salida.append(" = null;");
			salida.append('\n');


		}

		for (int i = 0; i < nombres.size(); i++) {
			//salida.append("public "); 

			//salida.append(tipos.elementAt(i).toString());
			//salida.append(' ');
			
			String nombreFuncionGet = "public final " + tipos.elementAt(i).toString() + " get" + nombres.elementAt(i).toString().substring(0, 1).toUpperCase() + nombres.elementAt(i).toString().substring(1) + "()";
			String nombreFuncionSet = "public final void set" + nombres.elementAt(i).toString().substring(0, 1).toUpperCase() + nombres.elementAt(i).toString().substring(1) + "(" + tipos.elementAt(i).toString() + " valor )";
			salida.append(nombreFuncionGet);
			salida.append("{\n return " + nombres.elementAt(i).toString().toLowerCase() + ";\n}");

			salida.append('\n');
			salida.append(nombreFuncionSet);
			salida.append("{\n");
			salida.append(nombres.elementAt(i).toString() + " = valor;\n}\n");


		}

		salida.append("\n}");
		salida.append("// para superclase del bean\n");


		this.txtsalida.setText(salida.toString());

	}

	private String convertirDatoJava(String tipoDato) {
		if (this.chkConversionExacta.isSelected()) {
			if (this.conversion.get(tipoDato) != null) {
				tipoDato = (String) this.conversion.get(tipoDato);
			}

		}
		if (tipoDato.indexOf("NUMBER") > -1) {
			tipoDato = "Long";

		}
		if (tipoDato.indexOf("VARCHAR") > -1) {
			tipoDato = "String";
		}

		if (tipoDato.indexOf("DATE") > -1) {
			tipoDato = "java.util.Date";
		}

		return tipoDato;

	}

	private void realizarConsulta(Connection conn) {

		ResultSet rs = null;
		try {
			Statement st = conn.createStatement();
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
				FileWriter fw = new FileWriter(f);
				String text = txtsalida.getText();
				int textsize = text.length();
				fw.write(txtsalida.getText(), 0, textsize);
				fw.close();
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
		String linea = "";
		String retorno = null;
		String stError = "Fichero de configuracion no disponible o ruta incorrecta";
		//Vector stvRecurso = new Vector();
		StringBuffer arch = new StringBuffer();
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
							arch.append(linea + '\n');
						}
					} // if linea con datos
				} // Fin fichero
				retorno = arch.toString();

				br.close();

			}

		} catch (Exception e) {
			stError = "\nException " + e + stError;

		} finally {
			if (!stError.equals("")) {
				this.status.setText(stError);
			}
			return retorno;
		}
	}

	private void cargarConfiguracion(String contenidoArchivo) {
		if (contenidoArchivo != null) {
			Cadena cadena = new Cadena();
			contenidoArchivo = cadena.normalizarCadena(contenidoArchivo);
			StringTokenizer st = new StringTokenizer(contenidoArchivo, ",");
			for (int i = 0; i <= st.countTokens(); i++) {

				String nombreSQL = st.nextToken();
				String nombreJava = st.nextToken();
				this.conversion.put(nombreSQL, nombreJava);
			}
		} else {
			this.chkConversionExacta.setEnabled(false);
		}
	}

	private StringBuffer generarCodigodeConexion(StringBuffer sb,
		Vector nombres, Vector tipos) {
		sb.append("public void conectarDatos(java.sql.ResultSet rs){\n");
		sb.append("try{");
		//sb.append("    if(rs.next()){\n");

		for (int i = 0; i < nombres.size(); i++) {
			sb.append("        " + nombres.elementAt(i).toString().toLowerCase());
			sb.append(" = (rs.getObject(\"" + nombres.elementAt(i).toString()
				+ "\")!=null) ? (" + tipos.elementAt(i).toString()
				+ ") rs.getObject(\""
				+ nombres.elementAt(i).toString() + "\")\n");
			sb.append(": null;\n");


		}
		//sb.append("    }\n");
		sb.append("}catch(Exception e){}\n");
		sb.append("}");

		return sb;
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JButton btncadena;
    private javax.swing.JButton btnconectar;
    private javax.swing.JCheckBoxMenuItem chkCodigodeConexion;
    private javax.swing.JCheckBoxMenuItem chkConversionExacta;
    private javax.swing.JCheckBoxMenuItem chkConversionInterna;
    private javax.swing.JCheckBoxMenuItem chkFicherito;
    private javax.swing.JCheckBoxMenuItem chktipo;
    private javax.swing.JMenu claseMenu;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
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
    private javax.swing.JMenuItem pasteMenuItem;
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

	private Object convertirNombreColumna(String cname) {
		cname = cname.toLowerCase();
		int lastIndex = 0;
		int index = 0;
		while (index >= 0) {
			index = cname.indexOf("_");
			if (index >= 0) {
				String tmp = cname.substring(0, index);
				lastIndex = index;
				lastIndex = index + 1;
				String tail = cname.substring(lastIndex);

				char first = Character.toUpperCase(tail.charAt(0));
				tail = first + tail.substring(1);
				cname = tmp + first + tail.substring(1);

			}
		}
		return cname;
	}
}
