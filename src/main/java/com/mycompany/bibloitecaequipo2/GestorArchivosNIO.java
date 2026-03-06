package com.mycompany.bibloitecaequipo2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Gestor de archivos que utiliza java.nio (NIO)
 * 
 * @author alejandromontijo
 */
public class GestorArchivosNIO {

    private final String rutaArchivo;

    public GestorArchivosNIO(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    /**
     * Guarda la lista completa de libros sobrescribiendo el archivo.
     * 
     * @param libros lista de libros a guardar
     */
    public void guardarLibros(List<Libro> libros) {
        Path path = Paths.get(rutaArchivo);
        List<String> lineas = new ArrayList<>();

        for (Libro libro : libros) {
            lineas.add(libro.toString());
        }

        try {
            // crear directorios si no existen, aunque el archivo base estara en la raiz
            Files.write(path, lineas, StandardCharsets.UTF_8,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Lee todos los registros del archivo usando java.nio.
     * 
     * @return Lista de libros cargados
     */
    public List<Libro> leerLibros() {
        Path path = Paths.get(rutaArchivo);
        List<Libro> libros = new ArrayList<>();

        // si el archivo no existe, retornamos la lista vacia para evitar error
        if (Files.exists(path) == false) {
            return libros;
        }

        try {
            List<String> lineas = Files.readAllLines(path, StandardCharsets.UTF_8);
            for (String linea : lineas) {
                // brincar lineas vacias
                if (linea.trim().isEmpty()) {
                    continue;
                }

                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    try {
                        String isbn = datos[0];
                        String titulo = datos[1];
                        String autor = datos[2];
                        String editorial = datos[3];
                        int anio = Integer.parseInt(datos[4]);

                        Libro libro = new Libro(isbn, titulo, autor, editorial, anio);
                        libros.add(libro);
                    } catch (Exception exParams) {
                        System.out.println("Error al parsear libro: " + exParams.getMessage());
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return libros;
    }
}
