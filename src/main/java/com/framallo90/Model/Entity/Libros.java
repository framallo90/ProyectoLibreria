package com.framallo90.Model.Entity;

public class Libros {
    private String titulo;
    private Integer isbn;
    private String autor;
    private float precio;
    private int copias;

    public Libros(String titulo, Integer isbn, String autor, float precio, int copias) {
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

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
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
