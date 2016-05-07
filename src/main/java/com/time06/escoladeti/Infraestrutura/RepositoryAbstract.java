package com.time06.escoladeti.Infraestrutura;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.time06.escoladeti.ModeloBase;


@Repository
public abstract class RepositoryAbstract<T extends ModeloBase> {

	@Autowired
	private  IRepository<T> repositoryT;
	@Autowired
	private  EntityManager em;
	
	public T findById(String id) {
		try {
			System.out.print("passou pelo repository");
			String sql = sqlLoadById();
			Query query = em.createNativeQuery(sql).setParameter("id", id);
			return (T)query.getSingleResult();
			
		} catch (Exception e) {
			
		}
		return null;
	}

	public T salvar(T entity) {
		try {
			System.out.print("Salvando " + entity.getClass());
			System.out.print(entity.getId());
			repositoryT.save(entity);
			
		} catch (Exception e) {
			
		}
		return null;
	}
	
	protected abstract String sqlLoadById();
	
	protected abstract String sqlGetAll();
	
	//public void create(T entity) {
	//	//repositoryT.save(saveObj);
	//	
	//}

	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String id) {
		repositoryT.delete(id);
		
	}

	public List<T> findAll() {
		try {
			String sql = sqlGetAll();
			System.out.println(sql);
			Query query = em.createNativeQuery(sql);
			return (List<T>)query.getResultList();
			
		} catch (Exception e) {
			throw new PessoaException("Método de buscar o select não está implementado!");
		}
	}
}
