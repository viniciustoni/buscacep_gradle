package br.com.buscacep.converter;

import br.com.buscacep.entity.Cep;
import br.com.buscacep.to.CepTO;

/**
 * Classe contendo os métodos de converter para a classe de {@link Cep}
 * 
 * @author Vinicius A Gai
 *
 */
public abstract class CepConverter {

	/**
	 * Converter os dados de {@link CepTO} para {@link Cep}
	 * 
	 * @param cepTO
	 *            Dados do CEP para conversão
	 * @return Objeto de {@link Cep} após a conversão.
	 */
	public static final Cep converterCepTOToCep(final CepTO cepTO) {

		Cep cep = null;

		if (cepTO != null) {

			cep = new Cep();

			cep.setNumCep(cepTO.getNumCep().replaceAll("[^0-9]+", ""));
			cep.setNomLogradouro(cepTO.getNomLogradouro());
			cep.setNomBairro(cepTO.getNomBairro());
			cep.setNomCidade(cepTO.getNomCidade());
			cep.setSglUf(cepTO.getSglUf());

		}

		return cep;

	}

}
