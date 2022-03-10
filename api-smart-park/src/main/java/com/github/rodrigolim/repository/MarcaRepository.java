package com.github.rodrigolim.repository;

import com.github.rodrigolim.entity.Marca;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.Dependent;

@Dependent
public class MarcaRepository implements PanacheRepository<Marca> {

}
