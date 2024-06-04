package com.framallo90.Model.Repository;

import com.framallo90.Interface.RepositoryInterface;
import com.framallo90.Model.Entity.Usuario;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class UsuarioRepository implements RepositoryInterface <Usuario>{
    private Map<String, Usuario> usuarioMap = new HashMap<>();
    private static final String PATH = "src/main/resources/usuarios.json";
    private Gson gson = new Gson();


    @Override
    public void add(Usuario object) {

    }

    @Override
    public void remove(Usuario object) {

    }

    @Override
    public void update(Usuario object) {

    }

    @Override
    public Usuario find(int id) {
        return null;
    }
}
