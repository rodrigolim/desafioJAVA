package com.github.rodrigolim.repository;

import java.util.List;
import com.github.rodrigolim.entity.Proprietario;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProprietarioRepository implements PanacheRepository<Proprietario>{
    
    public List<Proprietario> findByNome(String nome) {
        return find("nome", nome).list();
    }

}
