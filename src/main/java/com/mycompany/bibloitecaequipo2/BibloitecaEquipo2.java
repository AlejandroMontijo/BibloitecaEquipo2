package com.mycompany.bibloitecaequipo2;

import javax.swing.SwingUtilities;

/**
 * Clase principal que arranca la aplicacion.
 * 
 * @author alejandromontijo
 */
public class BibloitecaEquipo2 {

    public static void main(String[] args) {
        // Ejecutar en el hilo de despacho de eventos de Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormularioBiblioteca form = new FormularioBiblioteca();
                form.setVisible(true);
            }
        });
    }
}
