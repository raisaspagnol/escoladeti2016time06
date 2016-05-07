package com.time06.escoladeti.Pessoa;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService extends com.time06.escoladeti.Infraestrutura.Service<Pessoa> {

	@Autowired
	private PessoaRepository repository;
	
	public void create(CriarPessoaCommand command) {
		Pessoa pessoa = new Pessoa(new CriarPessoaEvent(
				command.getNomeRazaoSocial()));
		
		System.out.println(pessoa.getId());
		System.out.println(pessoa.getNomeRazaoSocial());
		System.out.println("PessoaService");
		repository.salvar(pessoa);
	}
}