package br.com.buscacep.converter;

import org.junit.Assert;
import org.junit.Test;

import br.com.buscacep.entity.Cep;
import br.com.buscacep.mock.CepTOMock;
import br.com.buscacep.to.CepTO;

/**
 * Testa a classe de conversão.
 * 
 * @author Vinicius A Gai
 */
public class CepConverterTest {

	/**
	 * Efetua a conversão de {@link CepTO} para {@link Cep}.
	 */
	@Test
	public void testConverterCepTOToCep() {
		
		// Cria o objeto para teste.
		final CepTO cepTO = CepTOMock.createMock();
		
		// Efetua a conversao.
		final Cep cep = CepConverter.converterCepTOToCep(cepTO);
		
		// Efetua as validaçoes
		Assert.assertEquals(CepTOMock.NUM_CEP, cep.getNumCep());
		Assert.assertEquals(CepTOMock.NOM_LOGRADOURO, cep.getNomLogradouro());
		Assert.assertEquals(CepTOMock.NOM_CIDADE, cep.getNomCidade());
		Assert.assertEquals(CepTOMock.NOM_BAIRRO, cep.getNomBairro());
		Assert.assertEquals(CepTOMock.SGL_UF, cep.getSglUf());
		
	}
	
	/**
	 * Efetua a conversão de {@link CepTO} para {@link Cep}.
	 */
	@Test
	public void testConverterCepTOToCepNulo() {
		
		// Cria o objeto para teste.
		final CepTO cepTO = null;
		
		// Efetua a conversao.
		final Cep cep = CepConverter.converterCepTOToCep(cepTO);
		
		// Efetua as validaçoes
		Assert.assertNull(cep);
		
	}
	
}
