package br.com.buscacep.converter;

import br.com.buscacep.entity.Cep;
import br.com.buscacep.to.CepTO;

/**
 * Classe contendo os métodos de converter para a classe de {@link CepTO}
 * 
 * @author Vinicius A Gai
 */
public abstract class CepTOConverter {

	/**
	 * Conversão do objeto de {@link Cep} para o objeto de {@link CepTO}
	 * 
	 * @param cep
	 *            Dados do Cep.
	 * @return {@link CepTO} após a conversão
	 */
	public static final CepTO converterCepToCepTO(final Cep cep) {

		CepTO cepTO = null;

		if (cep != null) {

			cepTO = new CepTO();

			cepTO.setNumCep(cep.getNumCep());
			cepTO.setNomLogradouro(cep.getNomLogradouro());
			cepTO.setNomBairro(cep.getNomBairro());
			cepTO.setNomCidade(cep.getNomCidade());
			cepTO.setSglUf(cep.getSglUf());

		}

		return cepTO;
	}

}
