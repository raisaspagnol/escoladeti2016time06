package com.time06.escoladeti.Pessoa;

import java.math.BigInteger;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private PessoaService service;
	
	@Autowired
	private EntityManager em;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public void create(@RequestBody CriarPessoaCommand command) {
		service.create(command);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Pessoa> findAll() {
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.PUT)
	@ResponseBody
	public void atualizar(Pessoa pessoa) {
		//pessoaService.save(pessoa);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/{id}")
	@ResponseBody
	public void delete(@PathVariable String id) {		
		service.delete(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}")
	@ResponseBody
	public Pessoa findById(@PathVariable String id) {	
		System.out.print("passou pelo controller");
		return service.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/contar")
	public Long contarAutores() {
		BigInteger quantidade = null;
		
		Query q = em.createNativeQuery("select count(id) as quantidade from pessoa");
		quantidade = (BigInteger) q.getSingleResult();
		return quantidade.longValue();
	}
}

