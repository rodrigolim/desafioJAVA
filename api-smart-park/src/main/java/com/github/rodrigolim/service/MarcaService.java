package com.github.rodrigolim.service;

import java.util.List;
import java.util.Optional;

import com.github.rodrigolim.entity.Marca;
import com.github.rodrigolim.model.MarcaDTO;
import com.github.rodrigolim.repository.MarcaRepository;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@RequestScoped
@RequiredArgsConstructor
public class MarcaService {

	MarcaRepository repository;

    public MarcaService(MarcaRepository repository) {
        this.repository = repository;
    }

    public List<Marca> list(String nome){
		if (nome != null) {
            return repository.findByNome(nome);
        }
		return Marca.listAll();
	}


    @Transactional
    public Response create(MarcaDTO dto) {
         Marca obj = new Marca();		
		 obj.setNome(dto.getNome());	
		 obj.persist();
		 return Response.status(Status.CREATED).entity(obj).build();
    }

    @Transactional
    public Response update(Long _id, MarcaDTO dto) {
        Optional<Marca> objOp = Marca.findByIdOptional(_id);
	    
	    if (objOp.isPresent()) {
	    	Marca obj = objOp.get();
	    	obj.setNome(dto.getNome());	
			obj.persist();	
			return Response.status(Status.CREATED).entity(obj).build();
	    }
	    else {
	    	throw new NotFoundException();
	    } 
    }

    @Transactional
    public Response delete(Long _id) {
	    Optional<Marca> objOp = Marca.findByIdOptional(_id);

		if (objOp.isPresent()){
			Marca obj = objOp.get();
			obj.delete();
			return Response.status(Status.OK).entity(obj).build();
		}
	    else {
	    	throw new NotFoundException();
	    } 
	    
	    // mOp.ifPresentOrElse(Marca::delete, () -> {
	    // 				throw new NotFoundException();
	    // 		});
		
    }
}
