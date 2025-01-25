package Cod;

import java.util.Scanner;

public class MainMenu {

    public static void mostrarMenu() {
        System.out.println("----- MENÚ PRINCIPAL -----");
        System.out.println("1. Ingreso Ejecutivo (Login)");
        System.out.println("2. Registro de Usuario");
        System.out.println("3. Registro de Persona");
        System.out.println("4. Realizar Transferencia");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        while (continuar) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Llamamos a LoginController
                    LoginController.main(args);
                    break;
                case 2:
                    // Llamamos a RegistroController para registrar usuario
                    RegistroController.main(args);
                    break;
                case 3:
                    // Llamamos a RegistroController para registrar persona
                    RegistroController.main(args);
                    break;
                case 4:
                    // Llamamos a TransferenciaController para realizar la transferencia
                    TransferenciaController.main(args);
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }
}
