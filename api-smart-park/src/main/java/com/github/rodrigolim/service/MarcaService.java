package com.github.rodrigolim.service;

import java.util.List;

import com.github.rodrigolim.entity.Marca;
import com.github.rodrigolim.model.MarcaDTO;
import com.github.rodrigolim.repository.MarcaRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.RequestScoped;

@RequestScoped
@RequiredArgsConstructor
public class MarcaService {

    public List<Marca> getTodasMarcas(){
		return Marca.listAll();
	}


    public void inserir(MarcaDTO dto) {
        Marca.persist(dto);
    }
}
