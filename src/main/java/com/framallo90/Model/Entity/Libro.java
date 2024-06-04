package com.framallo90.Model.Entity;

public class Libro {
    private String titulo;
    private String isbn;
    private String autor;
    private float precio;
    private int copias;

    public Libro(String titulo, String isbn, String autor, float precio, int copias) {
        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        if(isbn == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("El isbn no puede estar vacio");
        }
        if(autor == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }if(precio < 0){
            throw new IllegalArgumentException("El precio no puede ser menor a 0");
        }

        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.precio = precio;
        this.copias = copias;
    }

    @Override
    public String toString() {
        return "Libros{" +
                "titulo='" + titulo + '\'' +
                ", isbn=" + isbn +
                ", autor='" + autor + '\'' +
                ", precio=" + precio +
                ", copias=" + copias +
                '}';
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getCopias() {
        return copias;
    }

    public void setCopias(int copias) {
        this.copias = copias;
    }
}
