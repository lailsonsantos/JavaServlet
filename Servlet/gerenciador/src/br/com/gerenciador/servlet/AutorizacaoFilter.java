package br.com.gerenciador.servlet;

import java.io.IOException;
import javax.servlet.http.*;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class AutorizacaoFilter
 */
//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("Autorização");
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String paramAcao = request.getParameter("acao");

		HttpSession sessao = req.getSession();
		boolean usuarioLogado = sessao.getAttribute("usuarioLogado") != null;
		boolean ehAcaoLivre = paramAcao.equals("Login") || paramAcao.equals("LoginForm");
				
		if (!usuarioLogado && !ehAcaoLivre) {
			res.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

}
