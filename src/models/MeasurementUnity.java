
package models;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import utils.MySQL;


public class MeasurementUnity extends MySQL {
    private int id_unidad_medida;
    private String nombre;
    
    public MeasurementUnity(){
        
    }
    
    public MeasurementUnity(int id_unidad_medida, String nombre){
        this.id_unidad_medida = id_unidad_medida;
        this.nombre = nombre;
    }
    
    public HashMap<String, Integer> getUList(){
        HashMap<String, Integer> mapa = new HashMap<String, Integer>();
        
        String query = "SELECT * FROM unidad_medida;";
        try {
            //Creamos un juego de registros para resultados de consultas
            this.rs = this.s.executeQuery(query);
            //Recorremos los resultados

            while(this.rs.next()){
                Category s = new Category(rs.getInt("id_unidad_medida"), rs.getString("nombre"));
                
                 mapa.put(rs.getString("nombre"), rs.getInt("id_unidad_medida"));
            }
        
        } catch(SQLException ex){
            
        }
        return mapa;
    }
    
   public DefaultTableModel getMovimiento(){
        
        String[] columnsNames = {"ID Mmovimiento", "Codigo", "ID Bodega", "ID Usuario", "ID Tipo de Movimiento", "Fecha", "Cantidad"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsNames, 0);
        try {
            this.rs = this.s.executeQuery("select * from movimiento");
            
         while(this.rs.next()){
                 String id_movimiento = rs.getString("id_movimiento");
                 String codigo = rs.getString("codigo");
                 String id_bodega = rs.getString("id_bodega");
                 String id_usuario = rs.getString("id_usuario");
                 String id_movimiento_tipo = rs.getString("id_movimiento_tipo");
                 String fecha = rs.getString("fecha");
                 String cantidad = rs.getString("cantidad");
                 String[] data = {id_movimiento, codigo, id_bodega, id_usuario, id_movimiento_tipo, fecha, cantidad};
                 tableModel.addRow(data);
            }
        
        } catch(SQLException ex){
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableModel;
     }  
    
   public DefaultTableModel getBoleta(){ 
        
        String[] columnsNames = {"ID Venta", "ID usuario", "fecha", "total", "Vigente"};
        DefaultTableModel tableModel = new DefaultTableModel(columnsNames, 0);
        try {
            this.rs = this.s.executeQuery("select * from venta");
            
         while(this.rs.next()){
                 String id_venta = rs.getString("id_venta");
                 String id_usuario = rs.getString("id_usuario");
                 String fecha = rs.getString("fecha");
                 String total = rs.getString("total");
                 String vigente = rs.getString("vigente");
                 String[] data = {id_venta, id_usuario, fecha, total, vigente};
                 tableModel.addRow(data);
            }
        
        } catch(SQLException ex){
            Logger.getLogger(MySQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tableModel;
    }
}


