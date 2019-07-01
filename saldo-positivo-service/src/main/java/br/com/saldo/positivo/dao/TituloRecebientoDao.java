package br.com.saldo.positivo.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.saldo.positivo.model.TituloRecebimento;

@Repository
public interface TituloRecebientoDao extends MongoRepository<TituloRecebimento, String>{

	
	List<TituloRecebimento> findTituloByAnoAndMes(Integer ano, Integer mes);
	
}
