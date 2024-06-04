package com.framallo90.Model.Entity;

public class Usuario extends Persona {
    private int id;
    private static int idCounter = 0;
    private String nombreDeUsuario;
    private String contrasena;
    private String tipoDeUser;

    public Usuario(String nombre, String apellido, String dni, String nombreDeUsuario, String contrasena, String tipoDeUser) {
        super(nombre, apellido, dni);
        this.id = ++idCounter;
        this.nombreDeUsuario = nombreDeUsuario;
        this.contrasena = contrasena;
        this.tipoDeUser = tipoDeUser;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id + super.toString() +
                ", nombreDeUsuario='" + nombreDeUsuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tipoDeUser='" + tipoDeUser + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }

    public void setNombreDeUsuario(String nombreDeUsuario) {
        this.nombreDeUsuario = nombreDeUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipoDeUser() {
        return tipoDeUser;
    }

    public void setTipoDeUser(String tipoDeUser) {
        this.tipoDeUser = tipoDeUser;
    }
}
