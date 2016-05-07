package com.time06.escoladeti.Infraestrutura;

import org.springframework.data.jpa.repository.JpaRepository;

import com.time06.escoladeti.ModeloBase;

public interface IRepository<T extends ModeloBase> extends JpaRepository<T, String> {

}
