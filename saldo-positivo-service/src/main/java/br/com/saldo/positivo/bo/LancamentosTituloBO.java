package br.com.saldo.positivo.bo;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.saldo.positivo.model.TipoTituloEnum;
import br.com.saldo.positivo.model.Titulo;

@Component
public class LancamentosTituloBO {

	public BigDecimal calculoReceitas(List<Titulo> titulos) {
		return titulos
			.stream()
			.filter( p -> p.getTipo().equals(TipoTituloEnum.RECEITA))
			.map( this::buscaValor)
			.reduce(BigDecimal::add)
			.orElse(BigDecimal.ZERO);
	}

	public BigDecimal calculoDespesas(List<Titulo> titulos) {
		return titulos
				.stream()
				.filter( p -> p.getTipo().equals(TipoTituloEnum.DESPESA))
				.map( this::buscaValor)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
	
	private BigDecimal buscaValor(Titulo t) {
		if( t.getValorPago() != null && !t.getValorPago().equals(BigDecimal.ZERO)) {
			return t.getValorPago();
		}else {
			return t.getValorTitulo();
		}
	}
}
