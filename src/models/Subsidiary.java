/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import java.util.HashMap;
import utils.MySQL;
/**
 *
 * @author Frankie
 */
public class Subsidiary extends MySQL{
    private int id_sucursal;
    private int rut_empresa;
    private String nombre;
    private String direccion;
    private String telefono;
    private boolean es_matriz;
    
    public Subsidiary(){
        
    }
    
    public Subsidiary(int id_sucursal, String nombre){
        this.id_sucursal = id_sucursal;
        this.nombre = nombre;
    }
    
    public HashMap<String, Integer> getSubsidiaries(){
        HashMap<String, Integer> mapa = new HashMap<String, Integer>();
        
        String query = "SELECT * FROM sucursal;";
        try {
            //Creamos un juego de registros para resultados de consultas
            this.rs = this.s.executeQuery(query);
            //Recorremos los resultados

            while(this.rs.next()){
                Subsidiary s = new Subsidiary(rs.getInt("id_sucursal"), rs.getString("nombre"));
                
                 mapa.put(rs.getString("nombre"), rs.getInt("id_sucursal"));
            }
        
        } catch(SQLException ex){
            
        }
        return mapa;
    }
}
