package br.com.buscacep.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.buscacep.exception.CepInvalidoException;
import br.com.buscacep.exception.NenhumCepEncontradoException;

/**
 * Configura as exceptions para o servico de busca cep.
 * 
 * @author Vinicius A Gai
 *
 */
@ControllerAdvice
public class ExceptionResponseResolver {

	public final static int NENHUM_CEP_ENCONTRADO_EXCEPTION = 430;
	public final static int CEP_INVALIDO_EXCEPTION = 431;
	
	@ExceptionHandler(NenhumCepEncontradoException.class)
	public void configureNenhumCepEncontradoException(Exception exception, HttpServletResponse response)
			throws IOException {
		response.setStatus(NENHUM_CEP_ENCONTRADO_EXCEPTION);
		IOUtils.write(exception.getMessage(), response.getOutputStream());
	}
	
	@ExceptionHandler(CepInvalidoException.class)
	public void configureCepInvalidoException(Exception exception, HttpServletResponse response)
			throws IOException {
		response.setStatus(CEP_INVALIDO_EXCEPTION);
		IOUtils.write(exception.getMessage(), response.getOutputStream());
	}
}
