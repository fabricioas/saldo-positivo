package br.com.saldo.positivo.api;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.saldo.positivo.swagger.api.TitulosApi;
import br.com.saldo.positivo.swagger.model.LancamentoMes;
import io.github.benas.randombeans.api.EnhancedRandom;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@CrossOrigin(origins = "*")
public class TitulosApiController implements TitulosApi {

    private static final Logger log = LoggerFactory.getLogger(TitulosApiController.class);

    @ApiOperation(value = "Serviço para realizar lançamentos de despesas do mes", nickname = "lancamentosTitulo", notes = "", response = LancamentoMes.class, responseContainer = "List", tags={ "Titulos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso", response = LancamentoMes.class, responseContainer = "List") })
    @RequestMapping(value = "/titulos/lancamentos/{tipo}/{ano}/{mes}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    public ResponseEntity<List<LancamentoMes>> lancamentosTitulo(@ApiParam(value = "",required=true) @PathVariable("tipo") Integer tipo,@ApiParam(value = "",required=true) @PathVariable("ano") Integer ano,@ApiParam(value = "",required=true) @PathVariable("mes") Integer mes) {
        return ResponseEntity.ok(EnhancedRandom.randomListOf(10, LancamentoMes.class));
    }

    @ApiOperation(value = "Serviço para realizar lançamentos de despesas do mes", nickname = "deleteLancamentosTitulo", notes = "", tags={ "Titulos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso") })
    @RequestMapping(value = "/titulos/lancamento/{id}",
        method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLancamentosTitulo(@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Serviço para realizar lançamentos de despesas do mes", nickname = "postLancamentosTitulo", notes = "", tags={ "Titulos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso") })
    @RequestMapping(value = "/titulos/lancamento",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    public ResponseEntity<Void> postLancamentosTitulo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LancamentoMes body) {
        return ResponseEntity.ok().build();
    }


    @ApiOperation(value = "Serviço para realizar lançamentos de despesas do mes", nickname = "putLancamentosTitulo", notes = "", tags={ "Titulos", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Sucesso") })
    @RequestMapping(value = "/titulos/lancamento/{id}",
        method = RequestMethod.PUT)
    public ResponseEntity<Void> putLancamentosTitulo(@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        return ResponseEntity.ok().build();
    }

}
