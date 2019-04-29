package br.com.saldo.positivo.swagger.api;

import br.com.saldo.positivo.swagger.model.LiquidacaoTitulo;
import br.com.saldo.positivo.swagger.model.Titulo;

import java.util.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TitulosApiControllerIntegrationTest {

    @Autowired
    private TitulosApi api;

    @Test
    public void liquidacaoTituloTest() throws Exception {
        LiquidacaoTitulo body = new LiquidacaoTitulo();
        String id = "id_example";
        ResponseEntity<Titulo> responseEntity = api.liquidacaoTitulo(body, id);
        assertEquals(HttpStatus.NOT_IMPLEMENTED, responseEntity.getStatusCode());
    }

}
