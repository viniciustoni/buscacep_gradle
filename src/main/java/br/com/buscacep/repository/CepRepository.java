package br.com.buscacep.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.buscacep.entity.Cep;

/**
 * Repositorio para os dados de CEP.
 * 
 * @author Vinicius A Gai
 */
public interface CepRepository extends CrudRepository<Cep, String> {

}
