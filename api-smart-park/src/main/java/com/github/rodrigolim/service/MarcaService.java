package com.github.rodrigolim.service;

import java.util.List;
import java.util.Optional;

import com.github.rodrigolim.entity.Marca;
import com.github.rodrigolim.model.MarcaDTO;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;

@RequestScoped
@RequiredArgsConstructor
public class MarcaService {

    public List<Marca> getTodasMarcas(){
		return Marca.listAll();
	}


    @Transactional
    public void inserir(MarcaDTO dto) {
         Marca m = new Marca();		
		 m.setNome(dto.getNome());	
		 m.persist();
    }

    @Transactional
    public void alterar(Long marca_id, MarcaDTO dto) {
        Optional<Marca> mOp = Marca.findByIdOptional(marca_id);
	    
	    if (mOp.isPresent()) {
	    	Marca m = mOp.get();
	    	m.setNome(dto.getNome());	
			m.persist();	
	    }
	    else {
	    	throw new NotFoundException();
	    } 
    }

    @Transactional
    public void deletar(Long marca_id) {
	    Optional<Marca> mOp = Marca.findByIdOptional(marca_id);
	    
	    mOp.ifPresentOrElse(Marca::delete, () -> {
	    				throw new NotFoundException();
	    		});
		
    }
}
