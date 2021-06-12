package br.com.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.http.*;

import br.com.gerenciador.acao.Acao;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
@WebFilter("/entrada")
public class ControladorFilter implements Filter {
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Controlador");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String jsp = null;
		String paramAcao = request.getParameter("acao");
		String nomeDaClasse = "br.com.gerenciador.acao." + paramAcao;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
			jsp = acao.executa(req, res);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
		
		String[] direcionador = jsp.split(":");
		if (direcionador[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+direcionador[1]);
			rd.forward(request, response);
		}else {
			res.sendRedirect("entrada?acao=" + direcionador[1]);
		}
	}

}
