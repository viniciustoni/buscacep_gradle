package br.com.buscacep.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.exception.NenhumCepEncontradoException;
import br.com.buscacep.service.BuscaCepService;
import br.com.buscacep.service.CepService;
import br.com.buscacep.to.CepTO;

/**
 * Servicos para a busca de cep.
 * 
 * @author Vinicius A Gai
 */
@RestController
public class BuscaCepController {

	private final Logger logger = LoggerFactory.getLogger(BuscaCepController.class);

	@Autowired
	private CepService cepService;

	@Autowired
	private BuscaCepService buscaCepService;

	/**
	 * Cadastra o cep.
	 * 
	 * @param cepTO
	 *            Dados do CEP.
	 */
	@RequestMapping(value = "/buscacep/cadastraCep", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Cadastra um cep na base de dados", notes = "Cadastra um cep na base de dados.")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Cadastro efetuado com sucesso") })
	@Transactional
	public @ResponseBody void cadastraCep(@RequestBody @Valid CepTO cepTO) {
		logger.info("Cadastra o Cep.");
		cepService.gravaCep(cepTO);
	}

	/**
	 * Busca pelo Cep.
	 * 
	 * @param num
	 *            Dados do CEP.
	 * @throws NenhumCepEncontradoException
	 * @throws CepInvalidoException
	 */
	@RequestMapping(value = "/buscacep/buscaCep/{numCep}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Busca o cep na base de dados", notes = "Busca um cep na base de dados.")
	@ApiResponses(value = { @ApiResponse(code = 200, response = CepTO.class, message = "Cadastro efetuado com sucesso"),
			@ApiResponse(code = ExceptionResponseResolver.NENHUM_CEP_ENCONTRADO_EXCEPTION, message = "CEP não encontrado"),
			@ApiResponse(code = ExceptionResponseResolver.CEP_INVALIDO_EXCEPTION, message = "CEP Inválido") })
	@Transactional
	public @ResponseBody CepTO buscaCep(
			@ApiParam(value = "numCep", required = true) @PathVariable("numCep") String numCep)
					throws NenhumCepEncontradoException, CepInvalidoException {
		logger.info("Busca pelos dados do Cep.");
		return buscaCepService.buscaCep(numCep);
	}

}
