package com.time06.escoladeti.Usuario;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public String criar(@RequestBody CriarUsuarioCommand command) {
		service.criar(command);
		return command.getId();

		}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> getAll() {
		
		return service.getAll();
		}
}

