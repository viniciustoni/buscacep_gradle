package br.com.buscacep.mock;

import br.com.buscacep.entity.Cep;

/**
 * Classe de criaçao de objeto de mock para o objeto de {@link Cep}
 * 
 * @author Vinicius A Gai
 *
 */
public class CepMock {

	public final static String NUM_CEP = "06213040";
	public final static String NOM_LOGRADOURO = "Rua zuma de sá fernandes";
	public final static String NOM_CIDADE = "Osasco";
	public final static String SGL_UF = "SP";
	public final static String NOM_BAIRRO = "Presidente Altino";

	/**
	 * Cria o objeto de mock para {@link Cep}
	 * 
	 * @return Objeto de {@link Cep}
	 */
	public static Cep createMock() {
		final Cep cep = new Cep();

		cep.setNumCep(NUM_CEP);
		cep.setNomLogradouro(NOM_LOGRADOURO);
		cep.setNomCidade(NOM_CIDADE);
		cep.setNomBairro(NOM_BAIRRO);
		cep.setSglUf(SGL_UF);

		return cep;
	}

}
