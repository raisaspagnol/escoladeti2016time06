package com.time06.escoladeti.Pessoa;

import org.springframework.stereotype.Repository;
import com.time06.escoladeti.Infraestrutura.RepositoryAbstract;

@Repository
public class PessoaRepository extends RepositoryAbstract<Pessoa>{

	@Override
	protected String sqlLoadById() {
		return " select * from pessoa " + 
			   " where Pessoa = :id ";
	}

	@Override
	protected String sqlGetAll() {
		return " select * from Pessoa";
	}

}
