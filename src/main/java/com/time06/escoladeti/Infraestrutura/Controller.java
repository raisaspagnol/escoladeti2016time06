package com.time06.escoladeti.Infraestrutura;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.time06.escoladeti.ModeloBase;

public interface Controller<T, Command>  {

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<String> create(@RequestBody Command command);
	
	@RequestMapping(method = RequestMethod.GET)
	 List<T> getAll();

}

