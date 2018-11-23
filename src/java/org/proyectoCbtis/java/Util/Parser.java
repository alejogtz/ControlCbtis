package org.proyectoCbtis.java.Util;

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
                System.out.println("Error Desconocido");
            }
            return intValue;
        }

        public static String aString(String String) {
            String Value = "";
            // Logic code here
            try {
                Value = String.valueOf(Value);
            } catch (Exception error) {
                System.out.println("Error Desconocido");
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
