package br.com.loja.vo;

import java.util.Date;

public class RelatorioDeVendasVo {
	
	private String nomeProduto;
	private Long quantidadeVendida;
	private Date dataUltimaVenda;

	public RelatorioDeVendasVo() {}

	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, Date dataUltimaVenda) {
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUltimaVenda = dataUltimaVenda;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}

	public Date getDataUltimaVenda() {
		return dataUltimaVenda;
	}

	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUltimaVenda=" + dataUltimaVenda + "]";
	}
	
}
