package Cod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TransferenciaController {

    // Método para realizar una transferencia y guardarla en la base de datos
    public static void realizarTransferencia() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese su RUT: ");
        String rutCliente = scanner.nextLine();
        System.out.print("Ingrese el RUT del dueño de la cuenta destino: ");
        String rutDueño = scanner.nextLine();
        System.out.print("Ingrese el número de la cuenta destino: ");
        String cuentaDestino = scanner.nextLine();
        System.out.print("Ingrese el monto de la transferencia: ");
        double monto = scanner.nextDouble();
        System.out.print("Ingrese el tipo de cuenta (Ahorro/Corriente): ");
        scanner.nextLine(); // Limpiar el buffer
        String tipoCuenta = scanner.nextLine();
        
        // Lógica para insertar la transferencia en la base de datos
        try (Connection connection = DateBase.getConnection()) {
            String query = "INSERT INTO transaccion (rut_cliente, rut_dueño, cuenta_transferencia, monto_transferencia, tipo_cuenta) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, rutCliente);
            preparedStatement.setString(2, rutDueño);
            preparedStatement.setString(3, cuentaDestino);
            preparedStatement.setDouble(4, monto);
            preparedStatement.setString(5, tipoCuenta);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Transferencia realizada correctamente.");
            } else {
                System.out.println("Error al realizar la transferencia.");
            }
        } catch (SQLException e) {
            System.out.println("Transferencia realizada correctamente.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        realizarTransferencia();
    }
}
