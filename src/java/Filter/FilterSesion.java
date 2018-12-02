package Filter;

import Utilidades.Console;
import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(
	dispatcherTypes = {
		DispatcherType.REQUEST,
		DispatcherType.FORWARD
	},
	description = "Filtro sobre /*",
	urlPatterns = {
		"/WebProjectCbtis/Portero.jsp", "/WebProjectCbtis/Coordinadora.jsp"
	}
)
public class FilterSesion implements Filter {
       
    public FilterSesion() {}    
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Console.println("Filter Sesion file", ">>>>>>>>>>>>>>>Iniciando<<<<<<<<<<<<<<<<<<<<<<<<<");
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession sesion = httpRequest.getSession(false);
       
        if (sesion!=null){
            String usuario = (String) sesion.getAttribute("usuario");
        }
        
        chain.doFilter(request, response);
        Console.println("Filter Sesion file", ">>>>>>>>>>>>>>>Ending<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    public void destroy() {}

    public void init(FilterConfig filterConfig) {}
}
