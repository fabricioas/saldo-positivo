package br.com.saldo.positivo.api;

import java.util.List;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.saldo.positivo.bo.LancamentosTituloBO;
import br.com.saldo.positivo.bo.TituloBO;
import br.com.saldo.positivo.dao.TituloDao;
import br.com.saldo.positivo.mapper.LancamentosTituloMapper;
import br.com.saldo.positivo.mapper.TituloMapper;
import br.com.saldo.positivo.model.Titulo;
import br.com.saldo.positivo.swagger.api.TitulosApi;
import br.com.saldo.positivo.swagger.model.LancamentoTitulo;
import br.com.saldo.positivo.swagger.model.LancamentosMesResponse;
import br.com.saldo.positivo.swagger.model.LiquidacaoTitulo;
import io.swagger.annotations.ApiParam;

@Controller
public class TitulosApiController implements TitulosApi {

    private static final Logger log = LoggerFactory.getLogger(TitulosApiController.class);

    @Autowired
    private TituloMapper tituloMapper;

    @Autowired
    private TituloBO tituloBO;
    
    @Autowired
    private LancamentosTituloMapper lancamentosTituloMapper;

    @Autowired
    private LancamentosTituloBO lancamentosTituloBO;

    @Autowired
    private TituloDao tituloDao;

    @Override
    public ResponseEntity<Object> lancamentoTitulo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LancamentoTitulo body) {
    	Titulo titulo = tituloMapper.mapper(body);
    	String id = tituloBO.createTitulo(titulo);
    	return ResponseEntity.ok((Object)id);
    }


    @Override
    public ResponseEntity<LancamentosMesResponse> lancamentosTitulo(@ApiParam(value = "",required=true) @PathVariable("ano") Integer ano,@ApiParam(value = "",required=true) @PathVariable("mes") Integer mes) {
    	List<Titulo> titulos = tituloDao.findTituloByAnoAndMes(ano, mes);
    	LancamentosMesResponse lancamentosMes = lancamentosTituloMapper.novo(ano, mes);
    	lancamentosTituloMapper.adicionaLancacamentos(lancamentosMes, titulos);
    	lancamentosTituloMapper.atualizaSaldoLancamentos(lancamentosMes.getLancamentos(), null);
    	lancamentosTituloMapper.atualizaValoresTotais(lancamentosMes, lancamentosTituloBO.calculoReceitas(titulos),lancamentosTituloBO.calculoDespesas(titulos));
    	return ResponseEntity.ok(lancamentosMes);
    }


    @Override
    public ResponseEntity<Object> liquidacaoTitulo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LiquidacaoTitulo body,@ApiParam(value = "",required=true) @PathVariable("id") String id) {
    	String idTitulo = tituloBO.pagamentoTitulo(id, body.getValorPago(),body.getValorTitulo(), body.getDataLiquidacao());
    	return ResponseEntity.ok((Object)idTitulo);
    }

}
