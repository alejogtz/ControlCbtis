/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 *
 * @author Alessio
 */
public class Semana {

    public static boolean esDiaHabil() {
        /*Date fecha = new Date();
        int dia = fecha.getDay();
        int mes = fecha.getMonth();
        int ano = fecha.getYear();*/
        
        String letraD = "";
        /*Calendar c = Calendar.getInstance();
        c.set(ano, mes, dia, 0, 0, 0);
        nD=c.get(Calendar.DAY_OF_WEEK);*/
        TimeZone timezone = TimeZone.getDefault();
        Calendar calendar = Calendar.getInstance(); //new GregorianCalendar(timezone);
        //calendar.set(ano, mes - 1, dia);
        int nD = calendar.get(Calendar.DAY_OF_WEEK);
        //System.out.println("diaSemana: " + nD + " dia:" + dia + " mes:" + mes + "año:" + ano);
        System.err.println(nD);
        switch (nD) {
            //case 1: case 7: return true;
            case 2: case 3: case 4: case 5: case 6: return true;
            default: return false;
            /*    case 2:
                letraD = "L";
                break;
            case 3:
                letraD = "M";
                break;
            case 4:
                letraD = "X";
                break;
            case 5:
                letraD = "J";
                break;
            case 6:
                letraD = "V";
                break;
            case 7:
                letraD = "S";
                break;*/
        }
    }
    
    public static void main(String [] args){
        new Semana().esDiaHabil();
    }
}
