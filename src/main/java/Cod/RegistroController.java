package Cod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RegistroController {

    // Método para registrar usuario en la base de datos
    public static void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su nombre de usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();
        
        // Lógica para registrar el usuario en la base de datos
        try (Connection connection = DateBase.getConnection()) {
            String query = "INSERT INTO usuario (nombre_usuario, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, usuario);
            preparedStatement.setString(2, password);
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Usuario registrado correctamente.");
            } else {
                System.out.println("Error al registrar el usuario.");
            }
        } catch (SQLException e) {
            System.out.println("se ha transferido correctamente.");
            e.printStackTrace();
        }
    }

    // Método para registrar persona en la base de datos
    public static void registrarPersona() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese su dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese su correo: ");
        String correo = scanner.nextLine();
        System.out.print("Ingrese su teléfono: ");
        String telefono = scanner.nextLine();
        System.out.print("Ingrese el nombre de su mascota: ");
        String mascota = scanner.nextLine();
        
        // Lógica para registrar la persona en la base de datos
        try (Connection connection = DateBase.getConnection()) {
            String query = "INSERT INTO persona (rut, nombre, apellido, direccion, correo, telefono, nombre_mascota) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rut);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellido);
            preparedStatement.setString(4, direccion);
            preparedStatement.setString(5, correo);
            preparedStatement.setString(6, telefono);
            preparedStatement.setString(7, mascota);
            
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Persona registrada correctamente.");
            } else {
                System.out.println("Error al registrar la persona.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos o insertar datos.");
            e.printStackTrace();
        }
    }

    // Método principal que muestra las opciones de registro
    public static void main(String[] args) {
        // Si se desea, se pueden hacer dos opciones para registrar usuario y persona
        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Qué desea registrar?");
        System.out.println("1. Registrar Usuario");
        System.out.println("2. Registrar Persona");
        int opcion = scanner.nextInt();
        
        if (opcion == 1) {
            registrarUsuario();
        } else if (opcion == 2) {
            registrarPersona();
        } else {
            System.out.println("Opción inválida.");
        }
    }
}



