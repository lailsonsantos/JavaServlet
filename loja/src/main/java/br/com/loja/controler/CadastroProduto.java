package br.com.loja.controler;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;

public class CadastroProduto {

	public static void main(String[] args) {
		cadastrarProduto();
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		
		Produto produto = new Produto();
				
		produto = produtoDao.buscaPorId(2l);
		System.out.println(produto.toString());
		
		List<Produto> listaProduto = produtoDao.buscaTodos();
		for (Produto produto2 : listaProduto) {
			System.out.println(produto2.toString());
		}
	}

	private static void cadastrarProduto() {
		Categoria celular = new Categoria("CELULAR");
		Produto produto = new Produto("celular", "novo", new BigDecimal(12), celular);

		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celular);
		produtoDao.cadastrar(produto);
		
		em.getTransaction().commit();
		em.close();
	}

}
