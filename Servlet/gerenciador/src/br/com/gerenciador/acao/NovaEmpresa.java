package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("dataAbertura");
		
		Empresa emp = new Empresa();
		Banco banco = new Banco();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			emp.setNome(nomeEmpresa);
			emp.setDataAbertura(sdf.parse(dataEmpresa));
			banco.adicionar(emp);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		return "redirect:ListaEmpresa";
	}
	
}
