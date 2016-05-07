package com.time06.escoladeti.Pessoa;

import javax.persistence.Entity;
import com.time06.escoladeti.ModeloBase;
import com.time06.escoladeti.Usuario.UsuarioException;

@Entity
public class Pessoa extends ModeloBase {
	
	//@Id
	//private String id;
	private String nomeRazaoSocial;
	
	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa(CriarPessoaEvent event) {
		super();
		System.out.println(id);
		requerIdNaoNulo(id);
		requerNomeRazaoSocialNaoNulo(event.getNomeRazaoSocial());
		
		this.nomeRazaoSocial = event.getNomeRazaoSocial();
	}

	//public String getId() {
	//	return id;
	//}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}
	
	private void requerIdNaoNulo(String id) {
		if (id == null)
			throw new UsuarioException("Pessoa não pode ter ID nulo!");
	}
	
	private void requerNomeRazaoSocialNaoNulo(String nomeRazaoSocial) {
		if (nomeRazaoSocial == null)
		throw new UsuarioException("Pessoa exige um Email!");
	}
}
