package com.mycompany.bibloitecaequipo2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * Interfaz grafica principal para el sistema de biblioteca.
 * 
 * @author alejandromontijo
 */
public class FormularioBiblioteca extends JFrame {

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JPanel panelCentral;
    private javax.swing.JPanel panelFormulario;
    private javax.swing.JPanel panelInferior;
    private javax.swing.JPanel panelIzquierdo;
    private javax.swing.JTable tablaLibros;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAutor;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
    private DefaultTableModel modeloTabla;

    // Datos y archivos
    private List<Libro> listaLibros;
    private GestorArchivosNIO gestorArchivos;

    public FormularioBiblioteca() {
        // inicializar variables
        listaLibros = new ArrayList<>();
        gestorArchivos = new GestorArchivosNIO("libros_biblioteca.txt");

        // configurar ventana principal
        initComponents();

        // Inicializar modelo de la tabla DENTRO del constructor
        modeloTabla = (DefaultTableModel) tablaLibros.getModel();

        // cargar datos del archivo txt
        cargarDatosFichero();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIzquierdo = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        panelCentral = new javax.swing.JPanel();
        panelFormulario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtAutor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEditorial = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtAnio = new javax.swing.JTextField();
        panelInferior = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        itemSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Libros de Biblioteca");
        setPreferredSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(new java.awt.BorderLayout(10, 10));

        panelIzquierdo.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelIzquierdo.setLayout(new java.awt.GridLayout(4, 1, 10, 10));

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        panelIzquierdo.add(btnNuevo);

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        panelIzquierdo.add(btnGuardar);

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        panelIzquierdo.add(btnModificar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        panelIzquierdo.add(btnEliminar);

        getContentPane().add(panelIzquierdo, java.awt.BorderLayout.WEST);

        panelCentral.setBorder(javax.swing.BorderFactory.createTitledBorder("Formulario de Libros"));
        panelCentral.setLayout(new java.awt.BorderLayout());

        panelFormulario.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 50, 10, 50));
        panelFormulario.setLayout(new java.awt.GridLayout(5, 2, 5, 10));

        jLabel1.setText("ISBN:");
        panelFormulario.add(jLabel1);
        panelFormulario.add(txtIsbn);

        jLabel2.setText("Título:");
        panelFormulario.add(jLabel2);
        panelFormulario.add(txtTitulo);

        jLabel3.setText("Autor:");
        panelFormulario.add(jLabel3);
        panelFormulario.add(txtAutor);

        jLabel4.setText("Editorial:");
        panelFormulario.add(jLabel4);
        panelFormulario.add(txtEditorial);

        jLabel5.setText("Año de publicación:");
        panelFormulario.add(jLabel5);
        panelFormulario.add(txtAnio);

        panelCentral.add(panelFormulario, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelCentral, java.awt.BorderLayout.CENTER);

        panelInferior.setBorder(javax.swing.BorderFactory.createTitledBorder("Listado de Libros"));
        panelInferior.setPreferredSize(new java.awt.Dimension(800, 200));
        panelInferior.setLayout(new java.awt.BorderLayout());

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ISBN", "Título", "Autor", "Editorial", "Año de publicación"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tablaLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaLibrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablaLibros);

        panelInferior.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelInferior, java.awt.BorderLayout.SOUTH);

        menuArchivo.setText("Archivo");

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(itemSalir);

        jMenuBar1.add(menuArchivo);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {
        limpiarCampos();
        txtIsbn.requestFocus();
    }

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {
        guardarLibro();
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {
        modificarLibro();
    }

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {
        eliminarLibro();
    }

    private void tablaLibrosMouseClicked(java.awt.event.MouseEvent evt) {
        int fila = tablaLibros.getSelectedRow();
        if (fila >= 0) {
            txtIsbn.setText(modeloTabla.getValueAt(fila, 0).toString());
            txtTitulo.setText(modeloTabla.getValueAt(fila, 1).toString());
            txtAutor.setText(modeloTabla.getValueAt(fila, 2).toString());
            txtEditorial.setText(modeloTabla.getValueAt(fila, 3).toString());
            txtAnio.setText(modeloTabla.getValueAt(fila, 4).toString());
        }
    }

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void limpiarCampos() {
        txtIsbn.setText("");
        txtTitulo.setText("");
        txtAutor.setText("");
        txtEditorial.setText("");
        txtAnio.setText("");
        tablaLibros.clearSelection();
    }

    private void cargarDatosFichero() {
        listaLibros = gestorArchivos.leerLibros();
        actualizarTabla();
    }

    private void actualizarTabla() {
        modeloTabla.setRowCount(0); // limpiar filas
        for (Libro libro : listaLibros) {
            Object[] fila = {
                    libro.getIsbn(),
                    libro.getTitulo(),
                    libro.getAutor(),
                    libro.getEditorial(),
                    libro.getAnioPublicacion()
            };
            modeloTabla.addRow(fila);
        }
    }

    private void guardarLibro() {
        try {
            // Validacion rapida
            if (txtIsbn.getText().isEmpty() || txtTitulo.getText().isEmpty() ||
                    txtAutor.getText().isEmpty() || txtEditorial.getText().isEmpty() ||
                    txtAnio.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe llenar todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int anio = Integer.parseInt(txtAnio.getText());

            // comprobar que no exista el mismo isbn
            for (Libro lib : listaLibros) {
                if (lib.getIsbn().equals(txtIsbn.getText())) {
                    JOptionPane.showMessageDialog(this, "Ya existe un libro con este ISBN", "Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // crear libro
            Libro nuevoLibro = new Libro(txtIsbn.getText(), txtTitulo.getText(), txtAutor.getText(),
                    txtEditorial.getText(), anio);
            listaLibros.add(nuevoLibro);

            // guardar en txt usando NIO
            gestorArchivos.guardarLibros(listaLibros);

            actualizarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Libro guardado exitosamente", "Exito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El año debe ser un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error validacion", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarLibro() {
        int filaSelec = tablaLibros.getSelectedRow();
        if (filaSelec == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro de la tabla primero", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int anio = Integer.parseInt(txtAnio.getText());
            String nuevoIsbn = txtIsbn.getText();

            // Obtenemos el libro
            Libro libroSeleccionado = listaLibros.get(filaSelec);

            // comprobar que no exista otro libro con el mismo isbn
            for (int i = 0; i < listaLibros.size(); i++) {
                if (i != filaSelec && listaLibros.get(i).getIsbn().equals(nuevoIsbn)) {
                    JOptionPane.showMessageDialog(this, "Ya existe otro libro con este ISBN", "Error",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }

            // Actualizamos los datos
            libroSeleccionado.setIsbn(nuevoIsbn);
            libroSeleccionado.setTitulo(txtTitulo.getText());
            libroSeleccionado.setAutor(txtAutor.getText());
            libroSeleccionado.setEditorial(txtEditorial.getText());
            libroSeleccionado.setAnioPublicacion(anio);

            // guardar en txt
            gestorArchivos.guardarLibros(listaLibros);

            actualizarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Libro modificado exitosamente", "Exito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "El año debe ser un numero entero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error validacion", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void eliminarLibro() {
        int filaSelec = tablaLibros.getSelectedRow();
        if (filaSelec == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un libro de la tabla para eliminar", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar el libro?", "Confirmar",
                JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            listaLibros.remove(filaSelec);
            // guardar en txt
            gestorArchivos.guardarLibros(listaLibros);

            actualizarTabla();
            limpiarCampos();
            JOptionPane.showMessageDialog(this, "Libro eliminado", "Exito", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
