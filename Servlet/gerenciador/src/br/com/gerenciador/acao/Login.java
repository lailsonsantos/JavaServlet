package br.com.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import br.com.gerenciador.modelo.Banco;
import br.com.gerenciador.modelo.Usuario;


public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login no sistema");
		
		String paramLogin = request.getParameter("login");
		String paramSenha = request.getParameter("senha");
		
		Banco banco = new Banco();
		Usuario usuario = banco.existeUsuario(paramLogin, paramSenha);
		
		if (usuario != null) {
			System.out.println("Usuario logado com sucesso");
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuarioLogado", usuario);
			return "redirect:ListaEmpresa";
		}else {
			return "redirect:LoginForm";
		}

	}

}
