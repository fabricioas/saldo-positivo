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
			.map( Titulo::getValorTitulo)
			.reduce(BigDecimal::add)
			.orElse(BigDecimal.ZERO);
	}

	public BigDecimal calculoDespesas(List<Titulo> titulos) {
		return titulos
				.stream()
				.filter( p -> p.getTipo().equals(TipoTituloEnum.RECEITA))
				.map( Titulo::getValorTitulo)
				.reduce(BigDecimal::add)
				.orElse(BigDecimal.ZERO);
	}
}
