package com.time06.escoladeti.Usuario;

import java.util.UUID;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.time06.escoladeti.ModeloBase;

public class CriarUsuarioCommand {

	@Id
	private String id;
	private String email;
	private String senha;
	private String idPessoa;

	@JsonCreator
	public CriarUsuarioCommand(
		@JsonProperty("email") String email,
		@JsonProperty("senha") String senha,
		@JsonProperty("idPessoa") String idPessoa) {
		this.id = UUID.randomUUID().toString();
		this.email = email;
		this.senha = senha;
		this.idPessoa = idPessoa;
	}
	
	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getIdPessoa() {
		return idPessoa;
	}
}
