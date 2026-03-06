package com.mycompany.bibloitecaequipo2;

/**
 * Entidad que representa un modelo de libro
 * 
 * @author alejandromontijo
 */
public class Libro {

    // atributos privados
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private int anioPublicacion;

    /**
     * Constructor con validacion temprana
     */
    public Libro(String isbn, String titulo, String autor, String editorial, int anioPublicacion) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN no puede estar vacio");
        }
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacio");
        }
        if (editorial == null || editorial.trim().isEmpty()) {
            throw new IllegalArgumentException("La editorial no puede estar vacia");
        }
        if (anioPublicacion <= 0) {
            throw new IllegalArgumentException("El año de publicacion debe ser mayor a cero");
        }

        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("El ISBN no puede estar vacio");
        }
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        if (autor == null || autor.trim().isEmpty()) {
            throw new IllegalArgumentException("El autor no puede estar vacio");
        }
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        if (editorial == null || editorial.trim().isEmpty()) {
            throw new IllegalArgumentException("La editorial no puede estar vacia");
        }
        this.editorial = editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion <= 0) {
            throw new IllegalArgumentException("El año de publicacion debe ser mayor a cero");
        }
        this.anioPublicacion = anioPublicacion;
    }

    @Override
    public String toString() {
        // formato para guardar en el archivo de texto
        return isbn + "," + titulo + "," + autor + "," + editorial + "," + anioPublicacion;
    }
}
