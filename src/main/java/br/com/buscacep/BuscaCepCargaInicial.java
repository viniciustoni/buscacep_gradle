package br.com.buscacep;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.buscacep.service.CepService;
import br.com.buscacep.to.CepTO;

/**
 * Cadastra alguns CEPs, na base de dados
 * 
 * @author Vinicius A Gai
 *
 */
@Component
public class BuscaCepCargaInicial {

	@Autowired
	private CepService cepService;

	@PostConstruct
	@Transactional
	public void init() {

		gravaCep("06213040", "Rua Zuma De Sá Fernandes", "Presidente Altino", "Osasco", "SP");
		gravaCep("81490000", "Estrada Delegado Bruno de Almeida", "Caximba", "Curitiba", "PR");
		gravaCep("04143040", "Rua General Camisão ", "Saude", "São Paulo", "SP");
		
	}

	/**
	 * Grava os dados do CEP.
	 * 
	 * @param numCep
	 * @param nomLogradouro
	 * @param nomBairro
	 * @param nomCidade
	 * @param sglUf
	 */
	private void gravaCep(final String numCep, final String nomLogradouro, final String nomBairro,
			final String nomCidade, final String sglUf) {

		final CepTO cepTO = new CepTO();

		cepTO.setNumCep(numCep);
		cepTO.setNomBairro(nomBairro);
		cepTO.setNomCidade(nomCidade);
		cepTO.setNomLogradouro(nomLogradouro);
		cepTO.setSglUf(sglUf);

		// sava os dados
		cepService.gravaCep(cepTO);

	}

}
