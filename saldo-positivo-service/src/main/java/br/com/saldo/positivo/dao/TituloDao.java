package br.com.saldo.positivo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.saldo.positivo.model.Titulo;

@Repository
public interface TituloDao extends MongoRepository<Titulo, String>{

	
}
