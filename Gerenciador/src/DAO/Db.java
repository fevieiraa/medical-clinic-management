package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.SQLException;

public class Db {

        public Connection ConectBD (){
            Connection conn = null;
            
            try {
                String url = "jdbc:mysql://localhost:3306/BD_CLINICA2?user=root&password=root";
                conn = DriverManager.getConnection(url);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ConectBD: " + e.getMessage());
            }
            return conn;          
        }
    }
