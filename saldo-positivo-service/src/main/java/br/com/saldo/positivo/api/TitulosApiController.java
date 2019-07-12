package br.com.saldo.positivo.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.saldo.positivo.bo.TituloBO;
import br.com.saldo.positivo.swagger.api.TitulosApi;
import br.com.saldo.positivo.swagger.model.LancamentoMes;
import br.com.saldo.positivo.swagger.model.PagamentoTitulo;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@CrossOrigin(origins = "*")
public class TitulosApiController implements TitulosApi {

	private static final Logger log = LoggerFactory.getLogger(TitulosApiController.class);

	@Autowired
	private TituloBO tituloBO;


    @ApiOperation(value = "Serviço para realizar lançamentos de despesas do mes", nickname = "deleteLancamentosTitulo", notes = "", tags={ "Titulos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso") })
    @RequestMapping(value = "/titulos/lancamentos/{id}",
        method = RequestMethod.DELETE)
    @Override
    public ResponseEntity<Void> deleteLancamentosTitulo(@ApiParam(value = "",required=true) @PathVariable("id") String id) {
		tituloBO.deleteTitulo(id);
		return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "Serviço para realizar lançamentos de despesas do mes", nickname = "lancamentosTitulo", notes = "", response = LancamentoMes.class, responseContainer = "List", tags={ "Titulos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso", response = LancamentoMes.class, responseContainer = "List") })
    @RequestMapping(value = "/titulos/lancamentos/{ano}/{mes}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    @Override
    public ResponseEntity<List<LancamentoMes>> lancamentosTitulo(@ApiParam(value = "",required=true) @PathVariable("ano") Integer ano,@ApiParam(value = "",required=true) @PathVariable("mes") Integer mes) {
		List<LancamentoMes> result = null;
		result = tituloBO.buscaTitulos(ano, mes);
		return ResponseEntity.ok(result);
    }


    @ApiOperation(value = "Serviço para realizar lançamentos de despesas do mes", nickname = "putLancamentosTitulo", notes = "", tags={ "Titulos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso") })
    @RequestMapping(value = "/titulos/lancamentos",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Void> putLancamentosTitulo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LancamentoMes body) {
		tituloBO.enviaTitulo(body);
		return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "Serviço para realizar lançamentos de despesas do mes", nickname = "putPagamentoTitulo", notes = "", tags={ "Titulos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso") })
    @RequestMapping(value = "/titulos/lancamentos/pagar",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    @Override
    public ResponseEntity<Void> putPagamentoTitulo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody PagamentoTitulo body) {
		tituloBO.liquidaTitulo(body.getId(),body.getValorPago(),body.getValorTitulo(),body.getDataPagamento());
		return ResponseEntity.ok().build();
    }

}
