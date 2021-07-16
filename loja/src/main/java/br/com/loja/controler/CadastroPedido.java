package br.com.loja.controler;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.internal.build.AllowSysOut;

import br.com.loja.dao.CategoriaDao;
import br.com.loja.dao.ClienteDao;
import br.com.loja.dao.PedidoDao;
import br.com.loja.dao.ProdutoDao;
import br.com.loja.modelo.Categoria;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.ItemPedido;
import br.com.loja.modelo.Pedido;
import br.com.loja.modelo.Produto;
import br.com.loja.util.JPAUtil;
import br.com.loja.vo.RelatorioDeVendasVo;

public class CadastroPedido {
	
	public static void main(String[] args) {
		populaBanco();
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		Produto produto = produtoDao.buscaPorId(2l);
		
		ClienteDao clienteDao = new ClienteDao(em);
		Cliente cliente = clienteDao.buscaPorId(1l);

		PedidoDao pedidoDao = new PedidoDao(em);
		
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
		//em.close();
		
		BigDecimal totalVendido = pedidoDao.valorTotalVendido();
		System.out.println("Valor total do pedido: " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDao.relatorioDeVendas();
		relatorio.forEach(System.out::println);
	}

	private static void populaBanco() {
		Categoria celular = new Categoria("CELULAR");
		Produto produto = new Produto("celular", "novo", new BigDecimal(12), celular);
		Cliente cliente = new Cliente("lailson", "123456");
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.cadastrar(celular);
		produtoDao.cadastrar(produto);
		clienteDao.cadastrar(cliente);
		
		em.getTransaction().commit();
		em.close();
	}
}
