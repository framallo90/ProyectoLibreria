package com.framallo90.Model.Repository;

import com.framallo90.Interface.RepositoryInterface;
import com.framallo90.Model.Entity.Libros;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class LibrosRepository implements RepositoryInterface <Libros>{
    private Set<Libros> listaLibros = new HashSet<>();
    private static final String PATH = "src/main/resources/libros.json";
    private Gson gson = new Gson();

    public LibrosRepository(){
        this.loadFile();
    }

    public void loadFile(){
        try (Reader reader = new FileReader(PATH)) {
            Type setType = new TypeToken<Set<Libros>>(){}.getType();
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
    public void add(Libros object) {

    }

    @Override
    public void remove(Libros object) {

    }

    @Override
    public void update(Libros object) {

    }

    @Override
    public Libros find(int id) {
        return null;
    }
}
