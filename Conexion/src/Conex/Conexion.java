package Conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;  // Agrega esta línea
import java.sql.ResultSet;  // Agrega esta línea

public class Conexion {
    Connection con;

    public Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Actualiza el nombre de la clase del controlador
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_bd", "root", "12345");
        } catch (Exception e) {
            System.err.println("Error:" + e);
        }
    }

    public static void main(String[] args) {
        Conexion cn = new Conexion();
        Statement st;
        ResultSet rs;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("select * from users");
            while (rs.next()) {                
                System.out.println(rs.getInt("id") + " " + rs.getString("Nombre") + " " + rs.getString("correo"));
            }
            cn.con.close();
        } catch (Exception e) {
            e.printStackTrace();  // Imprime el seguimiento de la pila para identificar la causa del error
        }
    }
}
