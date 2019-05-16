package br.com.saldo.positivo.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.saldo.positivo.model.Titulo;
import br.com.saldo.positivo.swagger.model.LancamentosMesResponse;
import br.com.saldo.positivo.swagger.model.LancamentosMesResponseLancamentos;
import br.com.saldo.positivo.swagger.model.LancamentosMesResponseLancamentos.StatusEnum;
import br.com.saldo.positivo.swagger.model.LancamentosMesResponseLancamentos.TipeLancamentoEnum;

@Component
public class LancamentosTituloMapper {

	
	public LancamentosMesResponse novo(Integer year, Integer month) {
		return new LancamentosMesResponse()
		.ano(year)
		.mes(month);
	}
	
	public void atualizaValoresTotais(LancamentosMesResponse response, BigDecimal totalReceitas, BigDecimal totalDespesas) {
		response.setValorReceita(totalReceitas);
		response.setValorDespesa(totalReceitas);
		response.setValorSobra(totalReceitas.subtract(totalDespesas));
	}

	public void adicionaLancacamentos(LancamentosMesResponse response, List<Titulo> titulos){
		titulos.stream().map(this::convertTitulo).forEach(response::addLancamentosItem);
	}
	
	public LancamentosMesResponseLancamentos convertTitulo(Titulo titulo) {
		return new LancamentosMesResponseLancamentos()
				.id(titulo.getId())
				.nmLancamento(titulo.getDescricao())
				.tipeLancamento(TipeLancamentoEnum.fromValue(titulo.getTipo().name()))
				.status(StatusEnum.fromValue(titulo.getStatus().name()))
				.dataVencimento(titulo.getDataVencimento())
				.dataLiquidacao(titulo.getDataLiquidacao())
				.valorLancamento(titulo.getValorTitulo());
		
	}

	public void atualizaSaldoLancamentos(List<LancamentosMesResponseLancamentos> lancamentos, final BigDecimal saldoInicial) {
		BigDecimal saldo = BigDecimal.ZERO;
		if(saldoInicial != null) {
			saldo = saldoInicial;
		}
		for(LancamentosMesResponseLancamentos l : lancamentos ) {
			if( l.getTipeLancamento().equals(TipeLancamentoEnum.RECEITA) ) {
				saldo = saldo.add(l.getValorLancamento());
			}else {
				saldo = saldo.subtract(l.getValorLancamento());
			}
			l.setValorSaldo(saldo);
		}
	}

}
