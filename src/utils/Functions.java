/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Frankie
 */
public class Functions {
    
    
    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    
    public static String getRutDV(int rut){
        char[] tur = String.valueOf(rut).toCharArray();
        //76441664 - (8 caracteres)
        int paso = 0;
        int[] op = {2, 3, 4, 5, 6, 7};
        int acomulado = 0;
        for(int i = tur.length-1; i >= 0; i--){
            int posicion = Character.getNumericValue(tur[i]);
            acomulado +=  posicion * op[paso];
            if(paso < 5){
                paso++;
            } else {
                paso = 0;
            }
        }
        int predigito = 11 - (acomulado % 11);
        if(predigito == 11){
            return "0";
        }else if(predigito == 10){
            return "K";
        } else {
            return String.valueOf(predigito);
        }
        
    }
    
}
