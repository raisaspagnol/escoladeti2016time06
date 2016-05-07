package com.time06.escoladeti.Usuario;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.time06.escoladeti.ModeloBase;
import com.time06.escoladeti.Pessoa.Pessoa;

@Entity
public class Usuario extends ModeloBase {

	private String email;
	private String senha;
	@ManyToOne
	private Pessoa pessoa;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(CriarUsuarioEvent event, Pessoa pessoa) {
		requerIdNaoNulo(event.getId());
		requerEmailNaoNulo(event.getEmail());
		requerSenhaNaoNula(event.getSenha());
		requerPessoaNaoNula(pessoa);
		
		//this.id = event.getId();
		this.email = event.getEmail();
		this.senha = event.getSenha();
		this.pessoa = pessoa;
	}

	//public String getId() {
	//	return email;
	//}
	
	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	
	private void requerEmailNaoNulo(String email) {
		if (email == null)
		throw new UsuarioException("Usuário exige um Email!");
	}
	
	private void requerSenhaNaoNula(String senha) {
		if (senha == null)
			throw new UsuarioException("Usuário exige uma Senha!");
	}
	
	private void requerPessoaNaoNula(Pessoa pessoa) {
		if (pessoa == null)
			throw new UsuarioException("Usuário exige uma Pessoa!");
	}

	private void requerIdNaoNulo(String id) {
		if (id == null)
			throw new UsuarioException("Usuário não pode ter ID nulo!");
	}
}
