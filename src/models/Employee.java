/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utils.MySQL;

/**
 *
 * @author Frankie
 */
public class Employee extends MySQL{
    private int id_empleado;
    private int rut_persona;
    private int id_sucursal;
    private boolean es_encargado;
    private boolean activo; 
    
    public Employee(){
        //Constructor vacio
    }

    public Employee(int rut_persona, int id_sucursal, boolean es_encargado) {
        this.rut_persona = rut_persona;
        this.id_sucursal = id_sucursal;
        this.es_encargado = es_encargado;
        this.activo = true;
    }    
    
    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getRut_persona() {
        return rut_persona;
    }

    public void setRut_persona(int rut_persona) {
        this.rut_persona = rut_persona;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public boolean isEs_encargado() {
        return es_encargado;
    }

    public void setEs_encargado(boolean es_encargado) {
        this.es_encargado = es_encargado;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
     public DefaultTableModel getEmployees(){
        
        String[] columnsNames = {"ID Empleado", "RUT Persona", "ID Sucursal", "Es Encargado", "Activo"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsNames, 0);
        try {
            //Creamos un juego de registros para resultados de consultas
            this.rs = this.s.executeQuery("select * from empleado");
            //Recorremos los resultados

            while(this.rs.next()){
                 String id_empleado = rs.getString("id_empleado");
                 String rut_persona = rs.getString("rut_persona");
                 String id_sucursal = rs.getString("id_sucursal");
                 String es_encargado = rs.getString("es_encargado");
                 String activo = rs.getString("activo");
                 String[] data = {id_empleado, rut_persona, id_sucursal, es_encargado, activo};
                 tableModel.addRow(data);
            }
        
        } catch(SQLException ex){
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableModel;
    }
    
    public int save(){
        try {
            String query = "insert into empleado values (";
            query += "NULL, "+this.rut_persona+", "+this.id_sucursal;
            query += ", "+(this.es_encargado ? "1" : "0")+", "+(this.activo ? "1" : "0")+");";
            this.s.executeUpdate(query);
            this.rs = this.s.getGeneratedKeys();
            if (rs.next()) {
                this.id_empleado = rs.getInt(1);
                return this.id_empleado;
            }
            return 0;
        }catch(SQLException ex){
            return -1;
        }
    }
    
}
