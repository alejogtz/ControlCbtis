/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyectoCbtis.java.filter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public final class SesionHttp {

	public static boolean iniciada(HttpServletRequest request) {
		HttpSession sesion = request.getSession(false);
		if (sesion == null) {
			return false;
		}
		return true;
	}
	
	public static boolean noIniciada(HttpServletRequest request) {
		return !iniciada(request);
	}
}