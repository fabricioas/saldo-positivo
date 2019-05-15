package br.com.saldo.positivo.bo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.saldo.positivo.dao.TituloDao;
import br.com.saldo.positivo.model.StatusTituloEnum;
import br.com.saldo.positivo.model.Titulo;
import br.com.saldo.positivo.util.GenerateUtil;

@Component
public class TituloBO {
	
	@Autowired
	private GenerateUtil generateUtil;

    @Autowired
    private TituloDao tituloDAO;

	public String createTitulo(Titulo titulo) {
		titulo.setId(generateUtil.uuid());
    	tituloDAO.insert(titulo);
		return titulo.getId();
	}
	
	public String pagamentoTitulo(String id, BigDecimal valorPago, LocalDate dataLiquidacao) {
		Titulo titulo = tituloDAO.findOne(id);
		titulo.setDataLiquidacao(dataLiquidacao);
		titulo.setValorPago(valorPago);
		titulo.setStatus(StatusTituloEnum.PAGO);
    	tituloDAO.save(titulo);
		return titulo.getId();
	}
	
	public String deleteTitulo(Titulo titulo) {
    	tituloDAO.delete(titulo);
		return titulo.getId();
	}
	
	public List<Titulo> buscaTitulosMes(Integer ano, Integer mes){
		return tituloDAO.findTituloByAnoAndMes(ano, mes);
	}

}