package com.github.rodrigolim.repository;

import java.util.List;
import com.github.rodrigolim.entity.Marca;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class MarcaRepository implements PanacheRepository<Marca> {

    public List<Marca> findByNome(String nome) {
        return find("nome", nome).list();
    }

}
