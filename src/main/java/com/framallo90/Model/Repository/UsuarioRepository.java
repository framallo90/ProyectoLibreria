package com.framallo90.Model.Repository;

import com.framallo90.Interface.RepositoryInterface;
import com.framallo90.Model.Entity.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.Map;

public class UsuarioRepository implements RepositoryInterface <Usuario>{
    private Map<String, Usuario> usuarioMap = new HashMap<>();
    private static final String PATH = "src/main/resources/usuarios.json";
    private Gson gson = new Gson();

    public UsuarioRepository(){
        loadFile();
    }

    public void loadFile(){
        try (Reader reader = new FileReader(PATH)){
            Type mapType = new TypeToken<Map<String,Usuario>>(){}.getType();
            usuarioMap = gson.fromJson(reader,mapType);

            if(usuarioMap == null){
                usuarioMap = new HashMap<>();
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void updateFile(){
        try (Writer writer = new FileWriter(PATH)){
            gson.toJson(usuarioMap,writer);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    @Override
    public void add(Usuario object) {
        usuarioMap.put(object.getDni(),object);
        updateFile();
    }

    @Override
    public void remove(Usuario object) {
        usuarioMap.remove(object.getDni());
        updateFile();
    }

    @Override
    public void update(Usuario object) {
    }

    @Override
    public Usuario find(int id) {
        for(Map.Entry<String, Usuario> entry : usuarioMap.entrySet()){
            if (entry.getValue().getId() == id){
                return entry.getValue();
            }
        }
        return null;
    }

    public Usuario findDni(String dni) {
        for(Map.Entry<String, Usuario> entry : usuarioMap.entrySet()){
            if (entry.getValue().getDni().equals(dni)){
                return entry.getValue();
            }
        }
        return null;
    }

    public void cambioDePass(String dni, String nuevaPass){
        Usuario usuario = findDni(dni);
        usuario.setContrasena(nuevaPass);
        updateFile();
    }

    public void cambioNombre(String dni, String nuevoNombre){
        Usuario usuario = findDni(dni);
        usuario.setNombre(nuevoNombre);
        updateFile();
    }

    public void cambioNombreUsuario(String dni, String nuevoNombreUser){
        Usuario usuario = findDni(dni);
        usuario.setNombreDeUsuario(nuevoNombreUser);
        updateFile();
    }

    public void cambioApellido(String dni, String nuevoApellido){
        Usuario usuario = findDni(dni);
        usuario.setApellido(nuevoApellido);
        updateFile();
    }

    public void cambioDni(String dni, String nuevoDni){
        Usuario usuario = findDni(dni);
        usuario.setDni(nuevoDni);
        updateFile();
    }

    public void cambioTipoDeUser(String dni, String nuevoTipo){
        Usuario usuario = findDni(dni);
        usuario.setTipoDeUser(nuevoTipo);
        updateFile();
    }

    public Map<String, Usuario> getUsuarioMap() {
        return usuarioMap;
    }

    public void setUsuarioMap(Map<String, Usuario> usuarioMap) {
        this.usuarioMap = usuarioMap;
    }
}
