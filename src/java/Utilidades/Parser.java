package Utilidades;

import java.util.ArrayList;

public class Parser {

    private Parser() {
    }

    public static class DeString {

        public static int aInt(String value) {
            int intValue = 0;
            // Logic code here
            try {
                intValue = Integer.parseInt(value);
            } catch (Exception error) {
                Console.println("DeString a Int", "Error de Parseo: " + value);
            }
            return intValue;
        }

        public static String aString(String cadena) {
            String Value = "";
            // Logic code here
            try {
                Value = String.valueOf(cadena);
            } catch (Exception error) {
                Console.println("DeString a String", "Error de Parseo: " + cadena);
            }
            return Value;
        }
        
        public static boolean aBool(String value) {
            /*String valoresValidos = "true TRUE True 1 false FALSE False 0";
            for (int i = 0; i< valoresValidos.split(" ")){
                if (n.equals(value))
            }*/
            return false;
        }

        public static boolean aBoolean(String parameter) {
            Boolean parsed = Boolean.parseBoolean(parameter);
            return parsed;
                    
        }
    }

    public static class DeObject {

        public static String aString(Object value) {
            String StringValue;
            try {
                StringValue = (String) value;
            } catch (ClassCastException | NullPointerException error) {
                StringValue = "";
            }
            return StringValue;
        }

    }


}
