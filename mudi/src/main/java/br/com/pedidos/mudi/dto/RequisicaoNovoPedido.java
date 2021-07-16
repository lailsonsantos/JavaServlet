package br.com.pedidos.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.pedidos.mudi.model.Pedido;
import br.com.pedidos.mudi.model.StatusPedido;

public class RequisicaoNovoPedido {

	@NotBlank
	private String nome;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getUrlProduto() {
		return urlProduto;
	}
	
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setDescricao(descricao);
		pedido.setNome(nome);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}
}
