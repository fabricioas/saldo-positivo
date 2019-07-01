package br.com.saldo.positivo.bo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.saldo.positivo.dao.TituloRecebientoDao;
import br.com.saldo.positivo.model.StatusTituloEnum;
import br.com.saldo.positivo.model.TituloRecebimento;
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
	private TituloRecebientoDao tituloRecebientoDao;
	
	public List<TituloRecebimento> buscaTitulosRecebimento(Integer mes, Integer ano){
		return tituloRecebientoDao.findTituloByAnoAndMes(ano,mes);
	}

	public String enviaTituloRecebimento(LancamentoMes lancamento) {
		TituloRecebimento titulo = null;
		if(lancamento.getId() == null) {
			titulo = new TituloRecebimento();
			titulo.setId(generateUtil.uuid());
		}else {
			titulo = tituloRecebientoDao.findOne(lancamento.getId());
		}
		titulo.setDescricao(lancamento.getNmLancamento());
		titulo.setStatus(enumUtil.statusTitulo(lancamento.getStatusLancamento()));
		titulo.setValorTitulo(lancamento.getValorPlanejado());
		titulo.setDataVencimento(getDataVencimento(lancamento));
		titulo.setMes(lancamento.getMesVencimento());
		titulo.setAno(lancamento.getAnoVencimento());
		titulo.setValorPago(lancamento.getValorEfetivo());
		titulo.setDataLiquidacao(lancamento.getDataPagamento());
		tituloRecebientoDao.save(titulo);
		return titulo.getId();
	}

	private LocalDate getDataVencimento(LancamentoMes lancamento) {
		return LocalDate.of(lancamento.getAnoVencimento(), lancamento.getMesVencimento(), lancamento.getDiaVencimento());
	}

	public String liquidaTituloRecebimento(String id, BigDecimal valorPago, BigDecimal valorTitulo, LocalDate dataLiquidacao) {
		TituloRecebimento titulo = tituloRecebientoDao.findOne(id);
		titulo.setDataLiquidacao(dataLiquidacao);
		titulo.setValorPago(valorPago);
		if (valorTitulo != null && BigDecimal.ZERO.compareTo(valorTitulo) != 0) {
			titulo.setValorTitulo(valorPago);
		}
		titulo.setStatus(StatusTituloEnum.PAGO);
		tituloRecebientoDao.save(titulo);
		return titulo.getId();
	}

	public String deleteTituloRecebimento(String id) {
		tituloRecebientoDao.delete(id);
		return id;
	}

	public List<LancamentoMes> buscaTitulosMes(Integer ano, Integer mes) {
		return tituloRecebientoDao.findTituloByAnoAndMes(ano, mes).stream().map( m -> {
			LancamentoMes result = new LancamentoMes();
			result.setId(m.getId());
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