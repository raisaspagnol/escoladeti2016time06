package com.time06.escoladeti.Pessoa;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarPessoaCommand {

	private String id;
	private String nomeRazaoSocial;
	private String email;
	private String senha;

	@JsonCreator
	public CriarPessoaCommand(
		@JsonProperty("nomeRazaoSocial") String nomeRazaoSocial){
		this.id = UUID.randomUUID().toString();
		this.nomeRazaoSocial = nomeRazaoSocial;
	}
	
	//@JsonCreator
	//public CriarUsuarioCommand(
	//	@JsonProperty("nomeRazaoSocial") String nomeRazaoSocial,	
	//	@JsonProperty("email") String email,
	//	@JsonProperty("senha") String senha) {
	//	this.id = UUID.randomUUID().toString();
	//	this.email = email;
	//	this.senha = senha;
	//}
	
	public String getId() {
		return id;
	}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}
}
