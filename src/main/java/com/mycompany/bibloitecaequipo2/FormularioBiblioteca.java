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
    // Componentes del formulario
    private JTextField txtIsbn;
    private JTextField txtTitulo;
    private JTextField txtAutor;
    private JTextField txtEditorial;
    private JTextField txtAnio;

    // Botones
    private JButton btnNuevo;
    private JButton btnGuardar;
    private JButton btnModificar;
    private JButton btnEliminar;

    // Tabla
    private JTable tablaLibros;
    private javax.swing.JScrollPane jScrollPane1;
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

        // cargar datos del archivo txt
        cargarDatosFichero();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setTitle("Registro de Libros de Biblioteca");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        // iniciar componentes visuales
        crearMenu();
        crearPanelLateral();
        crearPanelCentral();
        crearPanelInferior();
    }// </editor-fold>//GEN-END:initComponents

    private void crearMenu() {
        JMenuBar bar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemSalir = new JMenuItem("Salir");

        itemSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menuArchivo.add(itemSalir);
        bar.add(menuArchivo);
        setJMenuBar(bar);
    }

    private void crearPanelLateral() {
        JPanel panelIzquierdo = new JPanel(new GridLayout(4, 1, 10, 10));
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        btnNuevo = new JButton("Nuevo");
        btnGuardar = new JButton("Guardar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");

        panelIzquierdo.add(btnNuevo);
        panelIzquierdo.add(btnGuardar);
        panelIzquierdo.add(btnModificar);
        panelIzquierdo.add(btnEliminar);

        add(panelIzquierdo, BorderLayout.WEST);

        // agregar eventos a los botones
        btnNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
                txtIsbn.requestFocus();
            }
        });

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarLibro();
            }
        });

        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarLibro();
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarLibro();
            }
        });
    }

    private void crearPanelCentral() {
        JPanel panelCentral = new JPanel(new BorderLayout());
        panelCentral.setBorder(BorderFactory.createTitledBorder("Formulario de Libros"));

        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 10));
        panelFormulario.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

        panelFormulario.add(new JLabel("ISBN:"));
        txtIsbn = new JTextField();
        panelFormulario.add(txtIsbn);

        panelFormulario.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelFormulario.add(txtTitulo);

        panelFormulario.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelFormulario.add(txtAutor);

        panelFormulario.add(new JLabel("Editorial:"));
        txtEditorial = new JTextField();
        panelFormulario.add(txtEditorial);

        panelFormulario.add(new JLabel("Año de publicación:"));
        txtAnio = new JTextField();
        panelFormulario.add(txtAnio);

        panelCentral.add(panelFormulario, BorderLayout.CENTER);

        // panel inferior dentro del formulario para botones extra si es necesario
        // se puede asimilar al moackup

        add(panelCentral, BorderLayout.CENTER);
    }

    private void crearPanelInferior() {
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.setBorder(BorderFactory.createTitledBorder("Listado de Libros"));

        // columnas
        String[] columnas = { "ISBN", "Título", "Autor", "Editorial", "Año de publicación" };
        modeloTabla = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; // que no se pueda editar directamente la tabla
            }
        };

        tablaLibros = new JTable(modeloTabla);
        jScrollPane1 = new JScrollPane(tablaLibros);
        panelInferior.add(jScrollPane1, BorderLayout.CENTER);

        // para que tome la mitad inferior de la ventana, usamos preferredSize
        panelInferior.setPreferredSize(new java.awt.Dimension(800, 200));

        add(panelInferior, BorderLayout.SOUTH);

        // Agregar listener para cuando seleccionan una fila
        tablaLibros.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting() == false) {
                int fila = tablaLibros.getSelectedRow();
                if (fila >= 0) {
                    txtIsbn.setText(modeloTabla.getValueAt(fila, 0).toString());
                    txtTitulo.setText(modeloTabla.getValueAt(fila, 1).toString());
                    txtAutor.setText(modeloTabla.getValueAt(fila, 2).toString());
                    txtEditorial.setText(modeloTabla.getValueAt(fila, 3).toString());
                    txtAnio.setText(modeloTabla.getValueAt(fila, 4).toString());
                }
            }
        });
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

            // Obtenemos el libro
            Libro libroSeleccionado = listaLibros.get(filaSelec);

            // Actualizamos los datos
            libroSeleccionado.setIsbn(txtIsbn.getText());
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
