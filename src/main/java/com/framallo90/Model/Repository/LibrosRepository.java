package com.framallo90.Model.Repository;

import com.framallo90.Interface.RepositoryInterface;
import com.framallo90.Model.Entity.Libro;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

public class LibrosRepository implements RepositoryInterface <Libro>{
    private Set<Libro> listaLibros = new HashSet<>();
    private static final String PATH = "src/main/resources/libros.json";
    private Gson gson = new Gson();

    public LibrosRepository(){
        this.loadFile();
    }

    public void loadFile(){
        try (Reader reader = new FileReader(PATH)) {
            Type setType = new TypeToken<Set<Libro>>(){}.getType();
            listaLibros = gson.fromJson(reader,setType);
            if(listaLibros == null){
                listaLibros = new HashSet<>();
            }
        }catch (FileNotFoundException e) {
            listaLibros = new HashSet<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateFile(){
        try (Writer writer = new FileWriter(PATH)){
            gson.toJson(listaLibros,writer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void add(Libro object) {
        this.listaLibros.add(object);
        updateFile();
    }

    @Override
    public void remove(Libro object) {
        this.listaLibros.remove(object);
        updateFile();
    }

    @Override
    public void update(Libro object) {
    }


    @Override
    public Libro find(int id) {
        return null;
    }

    public Libro findLibros(String isbn) {
        Libro libroBuscado = null;
        for(Libro libro : listaLibros){
            if(libro.getIsbn().equals(isbn)){
                libroBuscado = libro;
            }
        }
        return libroBuscado;
    }

    public void updatePrice(Libro modificado, float nuevoPrecio){
        modificado.setPrecio(nuevoPrecio);
        updateFile();
    }

    public void updateCopias(Libro modificado, int numeroNuevo){
        modificado.setCopias(numeroNuevo);
        updateFile();
    }

    public Set<Libro> getListaLibros() {
        return listaLibros;
    }

}
