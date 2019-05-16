package br.com.saldo.positivo.mapper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

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
		.mes(month)
		.nmMes(montaDescricaoMes(month,year))
		.lancamentos(new LinkedList<LancamentosMesResponseLancamentos>());
	}
	
	public void atualizaValoresTotais(LancamentosMesResponse response, BigDecimal totalReceitas, BigDecimal totalDespesas) {
		response.setValorReceita(totalReceitas);
		response.setValorDespesa(totalDespesas);
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
		if( CollectionUtils.isEmpty(lancamentos) ) {
			return;
		}
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
	
	public String montaDescricaoMes(Integer mes, Integer ano) {
		return LocalDate.of(ano, mes, 1).format(DateTimeFormatter.ofPattern("MMMM/yyyy",Locale.forLanguageTag("pt-BR")));
	}

}
