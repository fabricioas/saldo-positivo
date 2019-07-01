package br.com.saldo.positivo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class TituloRecebimento {
	@Id
	private String id;
	private String descricao;
	private StatusTituloEnum status;
	private BigDecimal valorPago;
	private BigDecimal valorTitulo;
	private LocalDate dataLiquidacao;
	private LocalDate dataVencimento;
	private Integer ano;
	private Integer mes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusTituloEnum getStatus() {
		return status;
	}

	public void setStatus(StatusTituloEnum status) {
		this.status = status;
	}

	public BigDecimal getValorPago() {
		return valorPago;
	}

	public void setValorPago(BigDecimal valorPago) {
		this.valorPago = valorPago;
	}

	public BigDecimal getValorTitulo() {
		return valorTitulo;
	}

	public void setValorTitulo(BigDecimal valorTitulo) {
		this.valorTitulo = valorTitulo;
	}

	public LocalDate getDataLiquidacao() {
		return dataLiquidacao;
	}

	public void setDataLiquidacao(LocalDate dataLiquidacao) {
		this.dataLiquidacao = dataLiquidacao;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

}
