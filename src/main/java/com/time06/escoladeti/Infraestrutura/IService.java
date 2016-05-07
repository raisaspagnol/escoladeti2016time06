package com.time06.escoladeti.Infraestrutura;

import java.util.Date;
import java.util.List;
import java.util.Map;

public abstract interface IService<T extends Command> {
	
	String create(T saveObj);
    void update(T updateObj);
    void delete(T delObj);
    List<T> getAll();
    List<T> getAllByPeriodo(Date start, Date end, Map<String, Object> parametros);
}
