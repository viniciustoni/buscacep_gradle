package br.com.buscacep.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Tabela contendo os dados de CEP.
 * 
 * @author Vinicius A Gai
 */
@Entity
@Table(name = "CEP")
public class Cep implements Serializable {

	private static final long serialVersionUID = -1032628849889182427L;

	@Id
	@Column(name = "NUM_CEP", length = 8)
	private String numCep;

	// Logradouro pode ser nulo, pois podem haver cidades de CEP unico.
	@Column(name = "NOM_LOGRADOURO")
	private String nomLogradouro;

	@Column(name = "NOM_CIDADE", nullable = false)
	private String nomCidade;

	@Column(name = "SGL_UF", nullable = false)
	private String sglUf;

	@Column(name = "NOM_BAIRRO")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numCep == null) ? 0 : numCep.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cep other = (Cep) obj;
		if (numCep == null) {
			if (other.numCep != null)
				return false;
		} else if (!numCep.equals(other.numCep))
			return false;
		return true;
	}

}
