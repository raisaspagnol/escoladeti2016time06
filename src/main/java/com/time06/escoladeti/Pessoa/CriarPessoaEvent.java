package com.time06.escoladeti.Pessoa;

public class CriarPessoaEvent {

	//private String id;
	private String nomeRazaoSocial;

	public CriarPessoaEvent(String nomeRazaoSocial) {
		this.nomeRazaoSocial = nomeRazaoSocial;
	}

	//public String getId() {
	//	return id;
	//}

	public String getNomeRazaoSocial() {
		return nomeRazaoSocial;
	}
}

