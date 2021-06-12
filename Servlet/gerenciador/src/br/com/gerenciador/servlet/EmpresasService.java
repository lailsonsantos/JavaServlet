package br.com.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Empresa> listaEmpresa = new Banco().getEmpresa();
		
		String formato = request.getHeader("accept");
		
		if (formato.contains("json")) {
			
			Gson gson = new Gson();
			String json = gson.toJson(listaEmpresa);
			
			response.setContentType("application/json");
			response.getWriter().print(json);
			
		}else if (formato.contains("xml")) {
			
			XStream xstream = new XStream();
			xstream.alias("empresa", Empresa.class);
			String xml = xstream.toXML(listaEmpresa);
			
			response.setContentType("application/xml");
			response.getWriter().print(xml);
		}else {
			response.setContentType("application/json");
			response.getWriter().print(" {'message' : 'no content'} ");
		}
		
	}

}
