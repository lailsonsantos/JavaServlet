package br.com.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class ListaEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Listando empresa");
		
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresa();

		request.setAttribute("empresas", lista);

		return "forward:listaEmpresas.jsp";
		
	}
	
}
