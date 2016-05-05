package br.com.buscacep.service.impl;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.exception.NenhumCepEncontradoException;
import br.com.buscacep.service.BuscaCepService;
import br.com.buscacep.service.CepService;
import br.com.buscacep.to.CepTO;

/**
 * Implementações para os métodos de Busca de cep.
 * 
 * @author Vinicius A Gai
 */
@Service
public class BuscaCepServiceImpl implements BuscaCepService {

	private static final int TAMANHO_CEP = 8;

	@Autowired
	private CepService cepService;

	@Override
	public CepTO buscaCep(final String numCep) throws NenhumCepEncontradoException, CepInvalidoException {

		// Efetua a primeira busca ao cep.
		CepTO cepTO = cepService.buscaCep(numCep);

		// Caso nao encontre ele efetua a busca, alterando os ultimos digitos
		// para 0
		if (cepTO == null) {
			cepTO = buscaCepZerosAoFinal(numCep);
		}

		// Caso o cep Ainda nao for localizado, lança exception
		if (cepTO == null) {
			throw new NenhumCepEncontradoException(
					MessageFormat.format("Nenhuma informação de CEP encontrado para o CEP: {0}", numCep));
		}

		return cepTO;
	}

	/**
	 * Busca pelo CEP, onde caso nao encontre o sistema irá alterando os
	 * caracteres da direita para 0 a cada nova tentativa, exemplo 06213444,
	 * 06213440, 06213400,..
	 * 
	 * @param numCep
	 *            Numero do Cep.
	 * @return CepTO Caso localizado
	 * @throws NenhumCepEncontradoException
	 * @throws CepInvalidoException
	 */
	private CepTO buscaCepZerosAoFinal(final String numCep) throws CepInvalidoException {

		// Efetua a primeira busca ao cep.
		CepTO cepTO = null;

		int index = numCep.length() - 1;
		String numCepAux = numCep.replaceAll("[^0-9]+", "");

		while (index >= 0 && cepTO == null) {

			// Ajusta o CEP.
			numCepAux = numCepAux.substring(0, index);
			numCepAux = StringUtils.rightPad(numCepAux, TAMANHO_CEP, "0");

			// Busca novamente pelo CEP
			cepTO = cepService.buscaCep(numCepAux);

			index--;
		}

		return cepTO;

	}

}
