package com.framallo90.Controller;

import com.framallo90.Model.Entity.Libro;
import com.framallo90.Model.Repository.LibrosRepository;
import com.framallo90.View.LibrosView;

import java.util.Scanner;

public class LibrosController {
    private LibrosRepository librosRepository;
    private LibrosView librosView;

    public LibrosController(LibrosRepository librosRepository, LibrosView librosView) {
        this.librosRepository = librosRepository;
        this.librosView = librosView;
    }
    public void menuLibro(){
        Scanner scanner = new Scanner(System.in);
        int opt;
        do{
            System.out.println("1. Agregar Libro.");
            System.out.println("2. Modificar Libro.");
            System.out.println("3. Borrar Libro.");
            System.out.println("4. Ver Stock.");
            System.out.println("5. SALIR.");
            System.out.println("Ingrese una opcion.");
            opt = scanner.nextInt();
            switch (opt){
                case 1:
                    addLibro();
                    break;

                case 2:
                    updateLibro();
                    break;

                case 3:
                    removeLibro();
                    break;

                case 4:
                    mostrarLibros();
                    break;

                case 5:
                    System.out.println("SALIENDO...");
                    break;

                default:
                    System.out.println("Opcion invalida! vuelva a intentarlo...");
                    break;
            }

        }while (opt!=5);
    }

    public void addLibro(){
        String titulo = librosView.ingresoTitulo();
        String isbn = librosView.ingresoIsbn();
        String autor = librosView.ingresoAutor();
        float precio = librosView.ingresoPrecio();
        int copia = librosView.ingresoNroCopias();

        librosRepository.add(new Libro(titulo, isbn,autor,precio,copia));
    }

    public void removeLibro(){
        String isbn = librosView.ingresoIsbn();
        Libro delete = librosRepository.findLibros(isbn);
        librosRepository.remove(delete);
    }

    public void updateLibro(){
        Scanner scanner = new Scanner(System.in);
        String isbn = librosView.ingresoIsbn();
        Libro toUpdate = librosRepository.findLibros(isbn);
        int opt;
        do{
            System.out.println("1. cambiar precio.");
            System.out.println("2. modificar copias.");
            System.out.println("3. salir.");
            System.out.println("Ingrese una opcion: ");
            opt=scanner.nextInt();
            switch (opt){
                case 1:
                    float nuevoPrecio = librosView.ingresoPrecio();
                    librosRepository.updatePrice(toUpdate,nuevoPrecio);
                    break;

                case 2:
                    int nuevaCopia = librosView.ingresoNroCopias();
                    librosRepository.updateCopias(toUpdate,nuevaCopia);
                    break;

                case 3:
                    System.out.println("saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida, vuelva a intentarlo.");
                    break;
            }
        }while (opt!=3);
    }

    public void mostrarLibros(){
        librosView.readLibros(librosRepository.getListaLibros());
    }

}
