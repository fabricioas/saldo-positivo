package br.com.saldo.positivo.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.saldo.positivo.bo.TituloBO;
import br.com.saldo.positivo.dao.TituloDao;
import br.com.saldo.positivo.model.Titulo;
import br.com.saldo.positivo.swagger.api.TitulosApi;
import br.com.saldo.positivo.swagger.model.LancamentoTitulo;
import br.com.saldo.positivo.swagger.model.LancamentosMesResponse;
import br.com.saldo.positivo.swagger.model.LiquidacaoTitulo;
import io.swagger.annotations.ApiParam;

@Controller
public class TitulosApiController implements TitulosApi {

    private static final Logger log = LoggerFactory.getLogger(TitulosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private TituloBO tituloBO;

    @Autowired
    private TituloDao tituloDAO;

    @org.springframework.beans.factory.annotation.Autowired
    public TitulosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Object> lancamentoTitulo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LancamentoTitulo body) {
    	Titulo titulo = tituloBO.createTitulo(body);
    	tituloDAO.insert(titulo);
    	return ResponseEntity.ok((Object)titulo.getId());
    }


    public ResponseEntity<LancamentosMesResponse> lancamentosTitulo(@ApiParam(value = "",required=true) @PathVariable("ano") Integer ano,@ApiParam(value = "",required=true) @PathVariable("mes") Integer mes) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default TitulosApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    public ResponseEntity<Object> liquidacaoTitulo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LiquidacaoTitulo body,@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default TitulosApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
