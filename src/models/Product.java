/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utils.MySQL;

public class Product extends MySQL{
    private int codigo;
    private String nombre;
    private int id_categoria;
    private int id_unidad_medida;
    private String fecha_registro;
    
    public Product(){
        
    }
    
    public Product(int codigo, String nombre, int idCategoria, int idUnidadMedida){
        this.codigo = codigo;
        this.nombre = nombre;
        this.id_categoria = idCategoria;
        this.id_unidad_medida = idUnidadMedida;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_unidad_medida() {
        return id_unidad_medida;
    }

    public void setId_unidad_medida(int id_unidad_medida) {
        this.id_unidad_medida = id_unidad_medida;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    public DefaultTableModel getProducts() {
        String[] columnsNames = {"Codigo", "Nombre Producto", "Categoria", "Unidad de Medida", "Fecha Registro"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsNames, 0);
        try {
            String query = "SELECT p.codigo, p.nombre as 'nombre_producto', "
                    + "c.nombre as 'nombre_categoria', u.nombre as 'nombre_unidadmedida', "
                    + "fecha_registro FROM producto p "
                    + "INNER JOIN categoria c ON p.id_categoria = c.id_categoria "
                    + "INNER JOIN unidad_medida u ON p.id_unidad_medida = u.id_unidad_medida";
            //Creamos un juego de registros para resultados de consultas
            this.rs = this.s.executeQuery(query);
            //Recorremos los resultados

            while(this.rs.next()){
                 String codigo = rs.getString("codigo");
                 String nombre = rs.getString("nombre_producto");
                 String id_categoria = rs.getString("nombre_categoria");
                 String id_unidad_medida = rs.getString("nombre_unidadmedida");
                 String fecha_registro = rs.getString("fecha_registro");
                 String[] data = {codigo, nombre, id_categoria, id_unidad_medida, fecha_registro};
                 tableModel.addRow(data);
            }
        
        } catch(SQLException ex){
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableModel;
    }
                    
    
    
    public int save(){
        try {
            String query = "insert into producto values (";
            query += this.codigo+", '"+this.nombre;
            query += "', "+this.id_categoria+", "+this.id_unidad_medida+");";
            this.s.executeUpdate(query);
            this.rs = this.s.getGeneratedKeys();
            return 0;
        }catch(SQLException ex){
            return -1;
        }
    }
}
