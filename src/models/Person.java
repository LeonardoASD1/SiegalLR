/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.SQLException;
import utils.MySQL;

/**
 *
 * @author Frankie
 */
public class Person extends MySQL{
    private int rut_persona;
    private String paterno;
    private String materno;
    private String nombres;
    private String fecha_nacimiento;
    private String fono_contacto;
    
    public Person(){
        
    }

    public Person(int rut_persona, String paterno, String materno, String nombres, String fecha_nacimiento, String fono_contacto) {
        this.rut_persona = rut_persona;
        this.paterno = paterno;
        this.materno = materno;
        this.nombres = nombres;
        this.fecha_nacimiento = fecha_nacimiento;
        this.fono_contacto = fono_contacto;
    }

    public Person(int rut_persona, String paterno, String nombres, String fecha_nacimiento) {
        this.rut_persona = rut_persona;
        this.paterno = paterno;
        this.nombres = nombres;
        this.fecha_nacimiento = fecha_nacimiento;
    }
    
    public int save(){
        try {
            String query = "insert into persona values (";
            query += this.rut_persona+", '"+this.paterno+"', ";
            query += this.materno == null ? "NULL, ": "'"+this.materno+"', ";
            query += "'"+this.nombres+"', '"+this.fecha_nacimiento+"'";
            query += this.fono_contacto == null ? ", NULL);" : ", '"+this.fono_contacto+"');";
            this.s.executeUpdate(query);
           return 1;
        }catch(SQLException ex){
            return -1;
        }
    }
    
}
