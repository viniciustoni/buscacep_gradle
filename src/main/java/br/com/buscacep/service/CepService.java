package br.com.buscacep.service;

import br.com.buscacep.entity.Cep;
import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.to.CepTO;

/**
 * Interface para declarar os métodos para as rotinas de {@link Cep}
 * 
 * @author Vinicius A Gai
 *
 */
public interface CepService {

	/**
	 * Grava os dados de Cep na base de dados.
	 * 
	 * @param cepTO
	 *            Dados do Cep.
	 */
	void gravaCep(final CepTO cepTO);

	/**
	 * Busca pelos dados de Cep.
	 * 
	 * @param numCep
	 *            Numero do CEP para consulta no banco
	 * @return Dados do {@link CepTO}, nulo caso nenhum Cep localizado.
	 * @throws CepInvalidoException Caso o cep esteja inválido.
	 */
	CepTO buscaCep(final String numCep) throws CepInvalidoException ;

}
