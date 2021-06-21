package br.com.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.loja.modelo.Produto;

public class ProdutoDao {

	private EntityManager em;

	public ProdutoDao(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Produto produto) {
		this.em.persist(produto);
	}
	
	public void atualizar(Produto produto) {
		this.em.merge(produto);
	}
	
	public void remover(Produto produto) {
		produto = em.merge(produto);
		this.em.remove(produto);
	}
	
	public Produto buscaPorId(Long Id) {
		return em.find(Produto.class, Id);
	}
	
	public List<Produto> buscaTodos(){
		String jpql = "SELECT p FROM Produto p";
		return em.createQuery(jpql, Produto.class).getResultList();
	}
	
	public List<Produto> buscaPorNome(String nome){
		String jpql = "SELECT p FROM Produto p WHERE p.nome = :p_nome";
		return em.createQuery(jpql, Produto.class)
				.setParameter("p_nome", nome)
				.getResultList();
	}
	
	public List<Produto> buscaPorCategoria(String categoria){
		String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = :p_categoria";
		return em.createQuery(jpql, Produto.class)
				.setParameter("p_categoria", categoria)
				.getResultList();
	}
	
	public BigDecimal buscaPrecoProdutoPorNome(String nome){
		String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = :p_nome";
		return em.createQuery(jpql, BigDecimal.class)
				.setParameter("p_nome", nome)
				.getSingleResult();
	}
	
}
