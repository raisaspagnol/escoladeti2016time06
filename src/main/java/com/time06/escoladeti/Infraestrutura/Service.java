package com.time06.escoladeti.Infraestrutura;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.time06.escoladeti.ModeloBase;

@org.springframework.stereotype.Service
public abstract class Service<T extends ModeloBase> {

	@Autowired
	private RepositoryAbstract<T> repositoryT;
	
	public T findById(String id) {
		try {
			System.out.print("passou pelo service");
			return repositoryT.findById(id);
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
	public void create(T entity) {
		repositoryT.salvar(entity);
		
	}

	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String id) {
		repositoryT.delete(id);
		
	}

	public List<T> findAll() {
		try {
			List<T> entity = repositoryT.findAll();
			
			System.out.println("Testando a classe ");
			if (entity == null)
				return null;
			
			return entity;
				
		} catch (Exception e) {
			
		}
		return null;
	}
}
