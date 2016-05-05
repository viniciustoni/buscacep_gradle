package br.com.buscacep.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.eq;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.buscacep.entity.Cep;
import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.mock.CepMock;
import br.com.buscacep.mock.CepTOMock;
import br.com.buscacep.repository.CepRepository;
import br.com.buscacep.service.impl.CepServiceImpl;
import br.com.buscacep.to.CepTO;

/**
 * Junits para a classe de {@link CepService}.
 * 
 * @author Vinicius A Gai
 */
@RunWith(MockitoJUnitRunner.class)
public class CepServiceTest {

	@Mock
	private CepRepository cepRepository;
	
	@Captor
	private ArgumentCaptor<Cep> cepCaptor;
	
	@InjectMocks
	private CepService cepServices = new CepServiceImpl();
	
	/**
	 * Testa a gravaçao de CEP com sucesso.
	 */
	@Test
	public void testGravaCepComSucesso() {
		
		// Cria o objeto de mock
		final CepTO cepTO = CepTOMock.createMock();
		
		// executa o método
		cepServices.gravaCep(cepTO);
		
		// Verificação
		verify(cepRepository, times(1)).save(cepCaptor.capture());
		
		final Cep cepVerificacao = cepCaptor.getValue();
		
		// Efetua as validaçoes
		Assert.assertEquals(CepTOMock.NUM_CEP, cepVerificacao.getNumCep());
		Assert.assertEquals(CepTOMock.NOM_LOGRADOURO, cepVerificacao.getNomLogradouro());
		Assert.assertEquals(CepTOMock.NOM_CIDADE, cepVerificacao.getNomCidade());
		Assert.assertEquals(CepTOMock.NOM_BAIRRO, cepVerificacao.getNomBairro());
		Assert.assertEquals(CepTOMock.SGL_UF, cepVerificacao.getSglUf());
	}
	
	/**
	 * Testa a gravaçao do CEP, porém com os dados do CEP nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testGravaCepCepTONulo() {
		
		// Cria o objeto de mock
		final CepTO cepTO = null;
		
		// executa o método
		cepServices.gravaCep(cepTO);
	}

	/**
	 * Testa a busca pelo cep, retorno com sucesso.
	 * 
	 * @throws CepInvalidoException
	 */
	@Test
	public void testBuscaCepSucesso() throws CepInvalidoException {
		
		// Objetos para retorno
		final Cep cep = CepMock.createMock();
		
		// Eventos
		when(cepRepository.findOne(eq(CepMock.NUM_CEP))).thenReturn(cep);
		
		// Executa o método
		final CepTO cepTOEncontrado = cepServices.buscaCep(CepMock.NUM_CEP);
		
		// Validaçao
		Assert.assertEquals(CepMock.NUM_CEP, cepTOEncontrado.getNumCep());
		Assert.assertEquals(CepMock.NOM_LOGRADOURO, cepTOEncontrado.getNomLogradouro());
		Assert.assertEquals(CepMock.NOM_CIDADE, cepTOEncontrado.getNomCidade());
		Assert.assertEquals(CepMock.NOM_BAIRRO, cepTOEncontrado.getNomBairro());
		Assert.assertEquals(CepMock.SGL_UF, cepTOEncontrado.getSglUf());
		
	}
	
	/**
	 * Testa a busca pelo cep, retorno com erro por cep nulo.
	 * 
	 * @throws CepInvalidoException
	 */
	@Test(expected = CepInvalidoException.class)
	public void testBuscaCepNulo() throws CepInvalidoException {
		// Executa o método
		cepServices.buscaCep(null);
	}
	
	/**
	 * Testa a busca pelo cep, retorno com erro por cep Invalido.
	 * 
	 * @throws CepInvalidoException
	 */
	@Test(expected = CepInvalidoException.class)
	public void testBuscaCepInvalido() throws CepInvalidoException {
		// Executa o método
		cepServices.buscaCep("123-122");
	}
	
}
