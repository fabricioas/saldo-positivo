package br.com.saldo.positivo.bo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.stereotype.Component;

import br.com.saldo.positivo.model.StatusTituloEnum;
import br.com.saldo.positivo.model.TipoTituloEnum;
import br.com.saldo.positivo.model.Titulo;
import br.com.saldo.positivo.swagger.model.LancamentoTitulo;
import io.github.benas.randombeans.api.EnhancedRandom;

@Component
public class TituloBO{
	
	public Titulo createTitulo(LancamentoTitulo lancamento){
		Titulo titulo = new Titulo();
		titulo.setId(generateId());
		titulo.setDescricao(lancamento.getDescricao());
		titulo.setAno(getAno(lancamento.getDataVencimento()));
		titulo.setMes(getMes(lancamento.getDataVencimento()));
		titulo.setDataVencimento(lancamento.getDataVencimento());
		titulo.setDataLiquidacao(lancamento.getDataLiquidacao()); 
		titulo.setNumParcela(null);
		titulo.setNumTotalParcela(null);
		titulo.setStatus(StatusTituloEnum.PENDENTE);
		titulo.setTipo(TipoTituloEnum.valueOf(lancamento.getTipo()));
		titulo.setTituloRef(titulo.getId());
		titulo.setValorPago(BigDecimal.valueOf(lancamento.getValorPago()));
		titulo.setValorTitulo(BigDecimal.valueOf(lancamento.getValorTitulo()));
		return titulo;
	}
	
	public String generateId() {
		return UUID.randomUUID().toString();
	}
	
	public Integer getAno(LocalDate data) {
		if( data == null ) {
			return null;
		}
		return data.getYear();
	}

	public Integer getMes(LocalDate data) {
		if( data == null ) {
			return null;
		}
		return data.getMonthValue();
	}
	
}	