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
		"/WebProjectCbtis/index.jsp"
	}
)
public class FilterLogin implements Filter {
       
    public FilterLogin() {}    
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        
        HttpSession sesion = httpRequest.getSession(false);
        
       
        boolean existeUnaSesion = (    sesion!=null 
                && sesion.getAttribute("usuario")!=null 
                && !sesion.getAttribute("usuario").equals("")    );
        
        
        if (existeUnaSesion){
            Console.println("Filter Login", "Sesion Sí existe");
            String PaginaPrincipalDelaSesion = (String) sesion.getAttribute("relativeIndex");
            httpResponse.sendRedirect(PaginaPrincipalDelaSesion);
        }else {
            Console.println("Filter Login", "Sesion No existe");
            chain.doFilter(request, response);
        }
    }

    public void destroy() {}

    public void init(FilterConfig filterConfig) {}
}
