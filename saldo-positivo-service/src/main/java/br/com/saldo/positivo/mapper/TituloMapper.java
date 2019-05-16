package br.com.saldo.positivo.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.saldo.positivo.model.StatusTituloEnum;
import br.com.saldo.positivo.model.TipoTituloEnum;
import br.com.saldo.positivo.model.Titulo;
import br.com.saldo.positivo.swagger.model.LancamentoTitulo;
import br.com.saldo.positivo.util.DateUtil;

@Component
public class TituloMapper {
	@Autowired
	private DateUtil dateUtil;

	public Titulo mapper(LancamentoTitulo lancamento) {
		Titulo titulo = new Titulo();
		titulo.setId(lancamento.getId());
		titulo.setDescricao(lancamento.getDescricao());
		titulo.setAno(dateUtil.getYear(lancamento.getDataVencimento()));
		titulo.setMes(dateUtil.getMonth(lancamento.getDataVencimento()));
		titulo.setDataVencimento(lancamento.getDataVencimento());
		titulo.setDataLiquidacao(lancamento.getDataLiquidacao());
		titulo.setNumParcela(null);
		titulo.setNumTotalParcela(null);
		titulo.setStatus(StatusTituloEnum.PENDENTE);
		titulo.setTipo(TipoTituloEnum.valueOf(lancamento.getTipo()));
		titulo.setTituloRef(titulo.getId());
		titulo.setValorPago(lancamento.getValorPago());
		titulo.setValorTitulo(lancamento.getValorTitulo());
		return titulo;
	}

}
