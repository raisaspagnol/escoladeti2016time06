package com.time06.escoladeti;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class ModeloBase {
	
	@Id
	protected String id;
	protected int codigo;
	protected String incUsuario;
	protected Date incData;
	protected String altUsuario;
	protected Date altData;
	
	public ModeloBase()
	{
		this.id = UUID.randomUUID().toString();
	}

	public String getId() {
		return id;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public String getIncUsuario() {
		return incUsuario;
	}
	
	public Date getIncData() {
		return incData;
	}
	
	public String getAltUsuario() {
		return altUsuario;
	}
	
	public Date getAltData() {
		return altData;
	}
}