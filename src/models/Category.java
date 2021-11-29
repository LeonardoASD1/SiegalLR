
package models;


import java.sql.SQLException;
import java.util.HashMap;
import utils.MySQL;

public class Category extends MySQL {
    
    private int id_categoria;
    private String nombre;
    
    public Category() {
        
    }
    
    public Category(int id_categoria , String nombre){
        this.id_categoria = id_categoria;
        this.nombre = nombre;
    }
    
    public HashMap<String, Integer> getCategories(){
        HashMap<String, Integer> mapa = new HashMap<String, Integer>();
        
        String query = "SELECT * FROM categoria;";
        try {
            //Creamos un juego de registros para resultados de consultas
            this.rs = this.s.executeQuery(query);
            //Recorremos los resultados

            while(this.rs.next()){
                Category s = new Category(rs.getInt("id_categoria"), rs.getString("nombre"));
                
                 mapa.put(rs.getString("nombre"), rs.getInt("id_categoria"));
            }
        
        } catch(SQLException ex){
            
        }
        return mapa;
    }
    
}
