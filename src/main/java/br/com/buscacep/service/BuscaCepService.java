package br.com.buscacep.service;

import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.exception.NenhumCepEncontradoException;
import br.com.buscacep.to.CepTO;

/**
 * Interface que declara os métodos para a busca de Cep
 * 
 * @author Vinicius A Gai
 */
public interface BuscaCepService {

	/**
	 * Busca pelos dados do Cep. <br>
	 * Caso nao encontre ele vai alterando os dados numeros da esquerda com 0.
	 * 
	 * @param numCep
	 *            Número do Cep.
	 * @return Dados do {@link CepTO}.
	 * @throws NenhumCepEncontradoException
	 *             Lançado caso nenhum cep seja localizado.
	 * @throws CepInvalidoException
	 *             Dados do cep estão invalidos.
	 */
	CepTO buscaCep(final String numCep) throws NenhumCepEncontradoException, CepInvalidoException;

}
