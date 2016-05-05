package br.com.buscacep.service.impl;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.buscacep.converter.CepConverter;
import br.com.buscacep.converter.CepTOConverter;
import br.com.buscacep.entity.Cep;
import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.repository.CepRepository;
import br.com.buscacep.service.CepService;
import br.com.buscacep.to.CepTO;

/**
 * Implementa os métodos para a Cep.
 * 
 * @author Vinicius A Gai
 */
@Service
public class CepServiceImpl implements CepService {

	private static final Logger log = LoggerFactory.getLogger(CepServiceImpl.class);

	@Autowired
	private CepRepository cepRepository;

	@Override
	public void gravaCep(final CepTO cepTO) {

		// Validação.
		Validate.notNull(cepTO, "Dados do Cep devem ser informado.");

		// Converter para a entidade
		final Cep cep = CepConverter.converterCepTOToCep(cepTO);

		// Grava os dados na base
		cepRepository.save(cep);
	}

	@Override
	public CepTO buscaCep(String numCep) throws CepInvalidoException {

		// Validaçao e formataçao do cep
		final String numCepFormatado = validaFormataCep(numCep);

		// Busca pelo Cep
		final Cep cep = cepRepository.findOne(numCepFormatado);

		return CepTOConverter.converterCepToCepTO(cep);
	}

	/**
	 * Valida pelo cep, se ele está preenchido, se tem tamanho de 8 posiçoes
	 * além de formatar o mesmo.
	 * 
	 * @param numCep
	 *            Numero do cep
	 * @return numero do cep formatado, somente com os numeros
	 */
	private String validaFormataCep(final String numCep) throws CepInvalidoException {

		// Validação
		try {
			Validate.notBlank(numCep, "O numero do CEP deve ser informado.");
		} catch (NullPointerException e) {
			log.error("CEP Nulo", e);
			throw new CepInvalidoException("CEP Inválido.");
		}

		// Carrega somente os numeros
		final String numCepCorreto = numCep.replaceAll("[^0-9]+", "");

		// Caso nao haja 8 caracteres.
		if (numCepCorreto.length() != 8) {
			log.error("Cep diferente de 8 digitos");
			throw new CepInvalidoException("CEP Inválido.");
		}

		return numCepCorreto;

	}

}
