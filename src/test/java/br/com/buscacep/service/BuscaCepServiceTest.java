package br.com.buscacep.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.anyString;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.exception.NenhumCepEncontradoException;
import br.com.buscacep.mock.CepTOMock;
import br.com.buscacep.service.impl.BuscaCepServiceImpl;
import br.com.buscacep.to.CepTO;

/**
 * Executa os Junits para a classe {@link BuscaCepService}.
 * 
 * @author Vinicius A Gai
 */
@RunWith(MockitoJUnitRunner.class)
public class BuscaCepServiceTest {

	private static final String CEP_BUSCA = "06213999";

	private static final String CEP_LOCALIZADO = "06213000";

	@Mock
	private CepService cepService;

	@InjectMocks
	private BuscaCepService buscaCepService = new BuscaCepServiceImpl();

	/**
	 * Busca pelos dados do CEP, onde o retorno é com sucesso na primeira
	 * tentativa.
	 * 
	 * @throws CepInvalidoException
	 * @throws NenhumCepEncontradoException
	 */
	@Test
	public void testBuscaCepComSucesso() throws NenhumCepEncontradoException, CepInvalidoException {

		// Objeto de mock
		final CepTO cepTO = CepTOMock.createMock();

		// Eventos
		when(cepService.buscaCep(eq(CepTOMock.NUM_CEP))).thenReturn(cepTO);

		// Executa o método
		final CepTO cepTORetornado = buscaCepService.buscaCep(CepTOMock.NUM_CEP);

		// Executa verificaçao
		verify(cepService, times(1)).buscaCep(anyString());
		Assert.assertEquals(cepTO, cepTORetornado);
	}

	/**
	 * Busca pelos dados do CEP, onde o retorno é com sucesso na 3 tentativa, ou
	 * seja, o CEP informado será 06213999, porém so será localizado com
	 * 06213000.
	 * 
	 * @throws CepInvalidoException
	 * @throws NenhumCepEncontradoException
	 */
	@Test
	public void testBuscaCepComSucessoZerosADireita() throws NenhumCepEncontradoException, CepInvalidoException {

		// Objeto de mock
		final CepTO cepTO = CepTOMock.createMock();

		// Eventos
		when(cepService.buscaCep(eq(CEP_LOCALIZADO))).thenReturn(cepTO);

		// Executa o método
		final CepTO cepTORetornado = buscaCepService.buscaCep(CEP_BUSCA);

		// Executa verificaçao
		Assert.assertEquals(cepTO, cepTORetornado);
	}
	
	/**
	 * Busca pelos dados do cep, porém nenhum é localizado.
	 * 
	 * @throws CepInvalidoException
	 * @throws NenhumCepEncontradoException
	 */
	@Test(expected = NenhumCepEncontradoException.class)
	public void testBuscaCepNenhumLocalizado() throws NenhumCepEncontradoException, CepInvalidoException {
		// Executa o método
		buscaCepService.buscaCep(CEP_BUSCA);
	}

}
