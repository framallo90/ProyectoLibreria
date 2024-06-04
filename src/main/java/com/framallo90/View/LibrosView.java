package com.framallo90.View;

import com.framallo90.Model.Entity.Libro;

import java.util.Scanner;
import java.util.Set;

public class LibrosView {
    public String ingresoTitulo(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese titulo:");
            String titulo = scanner.nextLine();
            return titulo;
        }catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (Exception er) {
            System.out.println("Ha ocurrido un error inesperado." + er.getMessage());
        }
        return null;
    }

    public String ingresoIsbn(){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese isbn:");
            String isbn = scanner.nextLine();
            return isbn;
        }catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (Exception er) {
            System.out.println("Ha ocurrido un error inesperado." + er.getMessage());
        }
        return null;
    }

    public String ingresoAutor() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese nombre de autor:");
            String autor = scanner.nextLine();
            return autor;
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        } catch (Exception er) {
            System.out.println("Ha ocurrido un error inesperado." + er.getMessage());
        }
        return null;
    }

    public float ingresoPrecio(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el precio:");
            float precio = scanner.nextFloat();
            return precio;
    }

    public int ingresoNroCopias(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de copias:");
        int numCopias = scanner.nextInt();
        return numCopias;
    }

    public void readLibro(Libro libro){
        System.out.println("-----------------------------");
        System.out.println("Titulo:" + libro.getTitulo());
        System.out.println("Autor:" + libro.getAutor());
        System.out.println("Isbn :" + libro.getIsbn());
        System.out.println("Precio:" + libro.getPrecio());
        System.out.println("------------------------------");
    }

    public void readLibros(Set<Libro> setlibros){
        setlibros.forEach(libro -> {readLibro(libro);});
    }
}
