package br.com.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Empresa;

public class AlteraEmpresa implements Acao{

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterando empresa");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("dataAbertura");

		Banco banco = new Banco();
		Empresa emp = banco.buscaEmpresaId(id);

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			emp.setNome(nomeEmpresa);
			emp.setDataAbertura(sdf.parse(dataEmpresa));
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		return "redirect:ListaEmpresa";
	}
	
}
