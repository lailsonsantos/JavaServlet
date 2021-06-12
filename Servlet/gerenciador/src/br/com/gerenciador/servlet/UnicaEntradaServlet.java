package br.com.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrada unica");
		
//		String paramAcao = request.getParameter("acao");
//		String nomeDaClasse = "br.com.gerenciador.acao." + paramAcao;
//		String jsp = null;
		
//		HttpSession sessao = request.getSession();
//		boolean usuarioLogado = sessao.getAttribute("usuarioLogado") != null;
//		boolean ehAcaoLivre = paramAcao.equals("Login") || paramAcao.equals("LoginForm");
//				
//		if (!usuarioLogado && !ehAcaoLivre) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
		
//		try {
//			Class<?> classe = Class.forName(nomeDaClasse);
//			Acao acao = (Acao) classe.getDeclaredConstructor().newInstance();
//			jsp = acao.executa(request, response);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new ServletException(e);
//		}
//		
//		String[] direcionador = jsp.split(":");
//		if (direcionador[0].equals("forward")) {
//			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+direcionador[1]);
//			rd.forward(request, response);
//		}else {
//			response.sendRedirect("entrada?acao=" + direcionador[1]);
//		}

	}

}
