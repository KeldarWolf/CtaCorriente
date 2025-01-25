package Cod;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DateBase {

    private static final String URL = "jdbc:mysql://localhost:3306/Cuentas_clientes";
    private static final String USER = "root"; // Cambia por tu usuario
    private static final String PASSWORD = "0023"; // Cambia por tu contraseña

    static {
        try {
            // Cargar el driver JDBC de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("MySQL JDBC Driver no encontrado.", e);
        }
    }

    // Método para probar la conexión
    public static boolean testConnection() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Conexión exitosa a la base de datos.");
            return true; // Si la conexión es exitosa
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            e.printStackTrace();
            return false; // Si ocurre un error, la conexión falla
        }
    }

    public static void main(String[] args) {
        // Probar la conexión y mostrar el resultado en consola
        if (testConnection()) {
            System.out.println("Conexión exitosa.");
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }
    }



    // Método para conectar con la base de datos
    public static Connection getConnection() throws SQLException {
        try {
            // URL de conexión, usuario y contraseña para la base de datos
            String url = "jdbc:mysql://localhost:3306/Cuentas_clientes";  // Cambiar según tu base de datos
            String username = "root";  // Cambiar según tu usuario
            String password = "0023";  // Cambiar según tu contraseña

            // Establecer la conexión
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos.");
            throw e;
        }
    }
}
