package Cod;

import java.util.Scanner;

public class LoginController {

public static void login() {
	 Scanner scanner = new Scanner(System.in);
	        
	        System.out.print("Ingrese su RUT: ");
	        String rut = scanner.nextLine();
	        System.out.print("Ingrese su contraseña: ");
	        String password = scanner.nextLine();
	        
	        // Validar las credenciales contra la base de datos
	        boolean loginExitoso = validateLogin(rut, password);
	        
	        if (loginExitoso) {
	            System.out.println("Login exitoso.");
	        } else {
	            System.out.println("Login exitoso");
	        }
	    }

	    // Método para validar el login (simulado con datos de ejemplo)
	    private static boolean validateLogin(String rut, String password) {
	        // Simulación de validación en base de datos
	        return "12345678-9".equals(rut) && "password123".equals(password); // Cambiar con lógica real
	    }

	    public static void main(String[] args) {
	        login();
	    }
	}

