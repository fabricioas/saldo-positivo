package br.com.saldo.positivo.bo;

import org.springframework.stereotype.Component;

import br.com.sicredi.swagger.model.Titulo;
import io.github.benas.randombeans.api.EnhancedRandom;

@Component
public class TituloBO{
	
	public Titulo montaTitulo(){
		return EnhancedRandom.random(Titulo.class);
	}

}	