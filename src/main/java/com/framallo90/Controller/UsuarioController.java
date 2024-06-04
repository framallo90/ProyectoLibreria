package com.framallo90.Controller;

import com.framallo90.Model.Entity.Usuario;
import com.framallo90.Model.Repository.UsuarioRepository;
import com.framallo90.View.UsuarioView;

import java.util.Scanner;

public class UsuarioController {
    private UsuarioRepository usuarioRepository;
    private UsuarioView usuarioView;

    public UsuarioController(UsuarioRepository usuarioRepository, UsuarioView usuarioView) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioView = usuarioView;
    }

    public void ingresoUsuarioEmpleado(){
        String nombre = usuarioView.ingresoNombre();
        String apellido = usuarioView.ingresoApellido();
        String dni = usuarioView.ingresoDni();
        String nombreDeUsuario = usuarioView.ingresoNomUsuario();
        String contrasena = usuarioView.ingresoContrasena();
        String tipoDeUser = "Cliente";
        usuarioRepository.add(new Usuario(nombre, apellido, dni, nombreDeUsuario, contrasena,tipoDeUser));
    }

    public void ingresoUsuarioAdmin(){
        String nombre = usuarioView.ingresoNombre();
        String apellido = usuarioView.ingresoApellido();
        String dni = usuarioView.ingresoDni();
        String nombreDeUsuario = usuarioView.ingresoNomUsuario();
        String contrasena = usuarioView.ingresoContrasena();
        String tipoDeUser = usuarioView.ingresoTipoDeUsuario();
        usuarioRepository.add(new Usuario(nombre, apellido, dni, nombreDeUsuario, contrasena,tipoDeUser));
    }

    public void removeUsusarioEmpleado(){
        String dni = usuarioView.ingresoDni();
        Usuario remove = usuarioRepository.findDni(dni);
        if (remove.getTipoDeUser().equals("Cliente")){
            usuarioRepository.remove(remove);
        }else{
            System.out.println("No tiene permiso para eliminar este usuario.");
        }
    }

    public void removeUsuarioAdmin(){
        String dni = usuarioView.ingresoDni();
        Usuario remove = usuarioRepository.findDni(dni);
        usuarioRepository.remove(remove);
    }


    public void menuUsuarioCliente(){
        String dni = usuarioView.ingresoDni();
        String nuevaPass = usuarioView.ingresoContrasena();
        usuarioRepository.cambioDePass(dni,nuevaPass);
    }
    public void menuUsuarioAdmin(){
        Scanner scanner = new Scanner(System.in);
        int opt;
        do {
            System.out.println("1. Alta Usuario.");
            System.out.println("2. Baja Usuario.");
            System.out.println("3. Modificar Usuario.");
            System.out.println("4. Salir.");
            opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    ingresoUsuarioAdmin();
                    break;

                case 2:
                    removeUsuarioAdmin();
                    break;

                case 3:
                    updateUsuarioAdmin();
                    break;

                case 4:
                    System.out.println("Saliendo.........");
                    break;

                default:
                    System.out.println("Opcion no valida, vuelva a intentarlo.");
                    break;
            }

        }while (opt!=4);
    }

    public void menuUsuarioEmpleado(){
        Scanner scanner = new Scanner(System.in);
        int opt;
        do{
            System.out.println("1. Alta Cliente.");
            System.out.println("2. Baja Cliente.");
            System.out.println("3. Modificar Cliente.");
            System.out.println("4. Salir.");
            opt = scanner.nextInt();
            switch (opt){
                case 1:
                    ingresoUsuarioEmpleado();
                    break;

                case 2:
                    removeUsusarioEmpleado();
                    break;

                case 3:
                    updateUsuarioEmpleado();
                    break;

                case 4:
                    System.out.println("Saliend.....");
                    break;

                default:
                    System.out.println("Opcion invalida, vuelva a intentarlo.");
                    break;
            }
        }while (opt!=4);
    }

    public void updateUsuarioEmpleado(){
        Scanner scanner = new Scanner(System.in);
        String dni = usuarioView.ingresoDni();
        int opt;
        do{
            System.out.println("1. modificar nombre.");
            System.out.println("2. modificar apellido.");
            System.out.println("3. modificar dni.");
            System.out.println("4. SALIR.");
            System.out.println("Ingrese una opcion: ");
            opt = scanner.nextInt();
            switch (opt){
                case 1:
                    String nombre = usuarioView.ingresoNombre();
                    usuarioRepository.cambioNombre(dni, nombre);
                    break;

                case 2:
                    String apellido = usuarioView.ingresoApellido();
                    usuarioRepository.cambioApellido(dni,apellido);
                    break;

                case 3:
                    String nuevoDni = usuarioView.ingresoDni();
                    usuarioRepository.cambioDni(dni,nuevoDni);

                case 4:
                    System.out.println("Saliendo........");
                    break;

                default:
                    System.out.println("Opcion invalida, vuelva a intentarlo.");
                    break;
            }
        }while (opt != 4);
    }

    public void updateUsuarioAdmin(){
        Scanner scanner = new Scanner(System.in);
        String dni = usuarioView.ingresoDni();
        int opt;
        do{
            System.out.println("1. modificar nombre.");
            System.out.println("2. modificar apellido.");
            System.out.println("3. modificar dni.");
            System.out.println("4. modificar nombre de usuario.");
            System.out.println("5. modificar contrasena.");
            System.out.println("6. modificar tipo de usuario.");
            System.out.println("7. SALIR.");
            System.out.println("Ingrese una opcion: ");
            opt = scanner.nextInt();
            switch (opt){
                case 1:
                    String nombre = usuarioView.ingresoNombre();
                    usuarioRepository.cambioNombre(dni, nombre);
                    break;

                case 2:
                    String apellido = usuarioView.ingresoApellido();
                    usuarioRepository.cambioApellido(dni,apellido);
                    break;

                case 3:
                    String nuevoDni = usuarioView.ingresoDni();
                    usuarioRepository.cambioDni(dni,nuevoDni);
                    break;

                case 4:
                    String nuevoNombreUser = usuarioView.ingresoNomUsuario();
                    usuarioRepository.cambioNombreUsuario(dni, nuevoNombreUser);
                    break;

                case 5:
                    String nuevaPass = usuarioView.ingresoContrasena();
                    usuarioRepository.cambioDePass(dni,nuevaPass);
                    break;

                case 6:
                    String nuevoTipoUser = usuarioView.ingresoTipoDeUsuario();
                    usuarioRepository.cambioTipoDeUser(dni, nuevoTipoUser);
                    break;

                case 7:
                    System.out.println("Saliendo........");
                    break;

                default:
                    System.out.println("Opcion invalida, vuelva a intentarlo.");
                    break;
            }
        }while (opt != 7);
    }
}
