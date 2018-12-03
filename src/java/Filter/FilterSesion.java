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
import javax.servlet.http.HttpServletResponse;
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
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Console.println("Filter Sesion file", ">>>>>>>>>>>>>>>Iniciando<<<<<<<<<<<<<<<<<<<<<<<<<");
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpSession sesion = httpRequest.getSession(false);
        try{
        if (sesion!=null){
            String usuario = (String) sesion.getAttribute("usuario"); 
            
            /*if(usuario.equalsIgnoreCase("coordinador")){
                httpResponse.sendRedirect("Coordinadora.jsp");
            }else {
                httpResponse.sendRedirect("Portero.jsp");
            }*/
            
            
        }
         }catch(NullPointerException e){
            httpResponse.sendRedirect("index.jsp");
         }
        chain.doFilter(request, response);
        Console.println("Filter Sesion file", ">>>>>>>>>>>>>>>Ending<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    public void destroy() {}

    public void init(FilterConfig filterConfig) {}
}
