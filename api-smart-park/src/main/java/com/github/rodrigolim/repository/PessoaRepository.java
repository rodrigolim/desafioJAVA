package com.github.rodrigolim.repository;

import java.util.List;
import com.github.rodrigolim.entity.Pessoa;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class PessoaRepository implements PanacheRepository<Pessoa>{
    
    public List<Pessoa> findByNome(String nome) {
        return find("nome", nome).list();
    }

}
