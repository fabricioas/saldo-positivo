package br.com.saldo.positivo.bo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.saldo.positivo.dao.TituloDao;
import br.com.saldo.positivo.model.EnumClasseTitulo;
import br.com.saldo.positivo.model.EnumStatusTitulo;
import br.com.saldo.positivo.model.Titulo;
import br.com.saldo.positivo.swagger.model.LancamentoMes;
import br.com.saldo.positivo.swagger.model.LancamentoMes.StatusLancamentoEnum;
import br.com.saldo.positivo.util.EnumUtil;
import br.com.saldo.positivo.util.GenerateUtil;

@Component
public class TituloBO {

	@Autowired
	private GenerateUtil generateUtil;
	
	@Autowired
	private EnumUtil enumUtil;
	
	@Autowired
	private TituloDao tituloDao;
	
	public String enviaTitulo(LancamentoMes lancamento) {
		Titulo titulo = null;
		if(lancamento.getId() == null) {
			titulo = new Titulo();
			titulo.setId(generateUtil.uuid());
		}else {
			titulo = tituloDao.findOne(lancamento.getId());
		}
		titulo.setDescricao(lancamento.getNmLancamento());
		titulo.setClasseTitulo(EnumClasseTitulo.of(lancamento.getClasseLancamento()));
		titulo.setStatus(enumUtil.statusTitulo(lancamento.getStatusLancamento()));
		titulo.setValorTitulo(lancamento.getValorPlanejado());
		titulo.setDataVencimento(getDataVencimento(lancamento));
		titulo.setMes(lancamento.getMesVencimento());
		titulo.setAno(lancamento.getAnoVencimento());
		titulo.setValorPago(lancamento.getValorEfetivo());
		titulo.setDataLiquidacao(lancamento.getDataPagamento());
		tituloDao.save(titulo);
		return titulo.getId();
	}

	private LocalDate getDataVencimento(LancamentoMes lancamento) {
		return LocalDate.of(lancamento.getAnoVencimento(), lancamento.getMesVencimento(), lancamento.getDiaVencimento());
	}

	public String liquidaTitulo(String id, BigDecimal valorPago, BigDecimal valorTitulo, LocalDate dataLiquidacao) {
		Titulo titulo = tituloDao.findOne(id);
		titulo.setDataLiquidacao(dataLiquidacao);
		titulo.setValorPago(valorPago);
		if (valorTitulo != null && BigDecimal.ZERO.compareTo(valorTitulo) != 0) {
			titulo.setValorTitulo(valorPago);
		}
		titulo.setStatus(EnumStatusTitulo.PAGO);
		tituloDao.save(titulo);
		return titulo.getId();
	}

	public String deleteTitulo(String id) {
		tituloDao.delete(id);
		return id;
	}

	public List<LancamentoMes> buscaTitulos(Integer ano, Integer mes) {
		return tituloDao.findTituloByAnoAndMes(ano, mes).stream().map( m -> {
			LancamentoMes result = new LancamentoMes();
			result.setId(m.getId());
			result.categoriaLancamento(enumUtil.getEnumValor(m.getCategoriaTitulo()));
			result.classeLancamento(enumUtil.getEnumValor(m.getClasseTitulo()));
			result.setAnoVencimento(m.getAno());
			result.setMesVencimento(m.getMes());
			result.setDiaVencimento(m.getDataVencimento().getDayOfMonth());
			result.setDataPagamento(m.getDataLiquidacao());
			result.setNmLancamento(m.getDescricao());
			result.setStatusLancamento(StatusLancamentoEnum.valueOf(m.getStatus().name()));
			result.setValorEfetivo(m.getValorPago());
			result.setValorPlanejado(m.getValorTitulo());
			return result;
		}).collect(Collectors.toList());
	}

}