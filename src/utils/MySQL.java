package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MySQL {
    protected Connection cn;
    protected Statement s;
    protected ResultSet rs;
    
    public MySQL(){
        
        try {
            //Registramos Driver MySQL
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            //Generamos conexión al servidor.
            this.cn = DriverManager.getConnection("jdbc:mysql://localhost/siegal", "root", "");
            //Se crea estamento para recibir consultas
            this.s = this.cn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
