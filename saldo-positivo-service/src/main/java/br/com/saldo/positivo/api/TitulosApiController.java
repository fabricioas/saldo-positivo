package br.com.saldo.positivo.api;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.saldo.positivo.bo.TituloBO;
import br.com.sicredi.swagger.api.TitulosApi;
import br.com.sicredi.swagger.model.LiquidacaoTitulo;
import br.com.sicredi.swagger.model.Titulo;
import io.swagger.annotations.ApiParam;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-04-10T18:21:28.222Z[GMT]")
@Controller
public class TitulosApiController implements TitulosApi {

    private static final Logger log = LoggerFactory.getLogger(TitulosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    
    @Autowired
    private TituloBO tituloBO;

    @org.springframework.beans.factory.annotation.Autowired
    public TitulosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Titulo> liquidacaoTitulo(@ApiParam(value = "" ,required=true )  @Valid @RequestBody LiquidacaoTitulo body,@ApiParam(value = "",required=true) @PathVariable("id") String id) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default TitulosApi interface so no example is generated");
        }
        return ResponseEntity.ok(tituloBO.montaTitulo());
    }	
}
