package com.framallo90.View;

import com.framallo90.Model.Entity.Usuario;

import java.sql.ClientInfoStatus;
import java.util.Map;
import java.util.Scanner;

public class UsuarioView {

    public String ingresoNombre(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        return nombre;
    }

    public String ingresoApellido(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese apellido: ");
        String apellido = scanner.nextLine();
        return apellido;
    }

    public String ingresoDni(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese dni: ");
        String dni = scanner.nextLine();
        return dni;
    }

    public String ingresoNomUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        return nombreUsuario;
    }

    public String ingresoContrasena(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese contrasena: ");
        String contrasena = scanner.nextLine();
        return contrasena;
    }

    public String ingresoTipoDeUsuario(){
        Scanner scanner = new Scanner(System.in);
        try {
            String tipoUsuario = null;
            System.out.println("Ingrese tipo de usuario (1.Cliente, 2.Admin, 3.Empleado): ");
            int opt = scanner.nextInt();
            if(opt == 1){
                tipoUsuario = "Cliente";
            }
            if(opt == 2){
                tipoUsuario = "Admin";
            }
            if(opt == 3){
                tipoUsuario = "Empleado";
            }
            return tipoUsuario;
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }catch (Exception e){
            System.out.println("Ha ocurrido un error inesperado" + e.getMessage());
        }
        return null;
    }

    public void readUsuario(Usuario usuario){
        System.out.println("----------------------------------------");
        System.out.println("Nombre: " + usuario.getApellido() + ", " + usuario.getNombre());
        System.out.println("Dni: " + usuario.getDni());
        System.out.println("NombreUsuario: "+ usuario.getNombreDeUsuario());
        System.out.println("TipoDeUsuario: "+usuario.getTipoDeUser());
        System.out.println("----------------------------------------");
    }

    public void readUsuarios(Map<String, Usuario> usuarioMap){
        for(Map.Entry<String, Usuario> entry : usuarioMap.entrySet()){
            readUsuario(entry.getValue());
        }
    }
}
