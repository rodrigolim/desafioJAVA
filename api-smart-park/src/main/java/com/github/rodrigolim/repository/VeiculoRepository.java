package com.github.rodrigolim.repository;

import java.util.List;
import com.github.rodrigolim.entity.Veiculo;

import javax.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class VeiculoRepository implements PanacheRepository<Veiculo>{
    
    public List<Veiculo> findByNome(String nome) {
        return find("nome", nome).list();
    }

}
