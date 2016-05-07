package com.time06.escoladeti.Usuario;

import com.time06.escoladeti.Pessoa.Pessoa;

public class CriarUsuarioEvent {

	private String id;
	private String email;
	private String senha;
	private String idPessoa;

	public CriarUsuarioEvent(String id, String email, String senha) {
		this.id = id;
		this.email = email;
		this.senha = senha;
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

