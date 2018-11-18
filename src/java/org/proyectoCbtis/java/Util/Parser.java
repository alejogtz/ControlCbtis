package org.proyectoCbtis.java.Util;

import java.util.ArrayList;


public class Parser {
    
    private Parser(){}
    
    static class DeString{        
        public static int aInt(String value){
            // Logic code here
            return 0;
        }
        
        public static boolean aBool(String value){
            /*String valoresValidos = "true TRUE True 1 false FALSE False 0";
            for (int i = 0; i< valoresValidos.split(" ")){
                if (n.equals(value))
            }*/
            return false;
        }
    }
    
    
        public static class DeObject{
            
            public static String aString(Object value){
                String StringValue;
                try{
                    StringValue = (String)value;
                }catch( ClassCastException | NullPointerException error ){
                    StringValue = "";
                }
                return StringValue;
            }
            
        }

    
}
