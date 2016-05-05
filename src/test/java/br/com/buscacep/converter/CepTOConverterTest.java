package br.com.buscacep.converter;

import org.junit.Assert;
import org.junit.Test;

import br.com.buscacep.entity.Cep;
import br.com.buscacep.mock.CepMock;
import br.com.buscacep.to.CepTO;

/**
 * Efetua os testes para a classe de conversão {@link CepTOConverter}
 * 
 * @author Vinicius A Gai
 */
public class CepTOConverterTest {

	/**
	 * Efetua a conversão de {@link CepTO} para {@link Cep}.
	 */
	@Test
	public void testConverterCepToCepTO() {
		
		// Cria o objeto para teste.
		final Cep cep = CepMock.createMock();
		
		// Efetua a conversao.
		final CepTO cepTO = CepTOConverter.converterCepToCepTO(cep);
		
		// Efetua as validaçoes
		Assert.assertEquals(CepMock.NUM_CEP, cepTO.getNumCep());
		Assert.assertEquals(CepMock.NOM_LOGRADOURO, cepTO.getNomLogradouro());
		Assert.assertEquals(CepMock.NOM_CIDADE, cepTO.getNomCidade());
		Assert.assertEquals(CepMock.NOM_BAIRRO, cepTO.getNomBairro());
		Assert.assertEquals(CepMock.SGL_UF, cepTO.getSglUf());
		
	}
	
	/**
	 * Efetua a conversão de {@link Cep} para {@link CepTO}.
	 */
	@Test
	public void testConverterCepToCepTONulo() {
		
		// Cria o objeto para teste.
		final Cep cep = null;
		
		// Efetua a conversao.
		final CepTO cepTO = CepTOConverter.converterCepToCepTO(cep);
		
		// Efetua as validaçoes
		Assert.assertNull(cepTO);
		
	}
	
}
