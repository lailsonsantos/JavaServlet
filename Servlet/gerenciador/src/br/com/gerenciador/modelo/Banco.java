package br.com.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
	
	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList<>();
	private static Integer contadorID = 1;
	
	static {
		Usuario usu = new Usuario();
		usu.setLogin("lailson");
		usu.setSenha("lailson");
		Banco.listaUsuario.add(usu);
	}

	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.contadorID++);
		Banco.lista.add(empresa);
	}

	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = Banco.lista.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				it.remove();
			}
		}
	}
	
	public List<Empresa> getEmpresa(){
		return Banco.lista;
	}

	public Empresa buscaEmpresaId(Integer id) {
		Iterator<Empresa> it = Banco.lista.iterator();
		while (it.hasNext()) {
			Empresa emp = it.next();
			if (emp.getId() == id) {
				return emp;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String paramLogin, String paramSenha) {
		for (Usuario usuario : listaUsuario) {
			if (usuario.ehIgual(paramLogin, paramSenha)) {
				return usuario;
			}
		}
		return null;
	}
}
