package com.time06.escoladeti.Usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.time06.escoladeti.Pessoa.Pessoa;
import com.time06.escoladeti.Pessoa.PessoaService;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private PessoaService pessoaService;
	
	public String criar(CriarUsuarioCommand command) {
		Pessoa pessoa = pessoaService.findById(command.getIdPessoa());
		
		Usuario usuario = new Usuario(new CriarUsuarioEvent(
				command.getId(), 
				command.getEmail(),
				command.getSenha()),
				pessoa);
		
		return repository.save(usuario).getId();
	}

	public List<Usuario> getAll() {
		return repository.findAll();
	}
}