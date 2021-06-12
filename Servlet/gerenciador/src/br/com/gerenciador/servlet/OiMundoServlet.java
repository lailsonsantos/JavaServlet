package br.com.gerenciador.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/oi") //Nome do Servlet ao ser chamado no navegador
public class OiMundoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		// Escreve no navegador
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println(" Oi Mundo! ");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("Servidor rodando!!!");
	}

}
