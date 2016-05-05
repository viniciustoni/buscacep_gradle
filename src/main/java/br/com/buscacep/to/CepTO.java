package br.com.buscacep.to;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Classe para armazenar os dados do CEP para o serviço.
 * 
 * @author Vinicius A Gai
 */
@ApiModel(description = "Dados do Cep")
@JsonInclude(Include.NON_NULL)
public class CepTO implements Serializable {

	private static final long serialVersionUID = 3858672288888622513L;

	@ApiModelProperty(value = "Numero do cep")
	@NotEmpty
	private String numCep;
	
	@ApiModelProperty(value = "Logradouro do cep.")
	@NotEmpty
	private String nomLogradouro;
	
	@ApiModelProperty(value = "Nome da cidade")
	@NotEmpty
	private String nomCidade;
	
	@ApiModelProperty(value = "Sigla de UF")
	@NotEmpty
	private String sglUf;
	
	@ApiModelProperty(value = "Nome do bairro")
	@NotEmpty
	private String nomBairro;

	public String getNumCep() {
		return numCep;
	}

	public void setNumCep(String numCep) {
		this.numCep = numCep;
	}

	public String getNomLogradouro() {
		return nomLogradouro;
	}

	public void setNomLogradouro(String nomLogradouro) {
		this.nomLogradouro = nomLogradouro;
	}

	public String getNomCidade() {
		return nomCidade;
	}

	public void setNomCidade(String nomCidade) {
		this.nomCidade = nomCidade;
	}

	public String getSglUf() {
		return sglUf;
	}

	public void setSglUf(String sglUf) {
		this.sglUf = sglUf;
	}

	public String getNomBairro() {
		return nomBairro;
	}

	public void setNomBairro(String nomBairro) {
		this.nomBairro = nomBairro;
	}

}
