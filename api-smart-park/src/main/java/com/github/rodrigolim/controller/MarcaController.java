package com.github.rodrigolim.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.rodrigolim.entity.Marca;
import com.github.rodrigolim.model.MarcaDTO;
import com.github.rodrigolim.service.MarcaService;

import lombok.RequiredArgsConstructor;


@Path("/cadastro/marcas")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarcaController {
		
	//private final MarcaService service;

	@GET
	public List<Marca> buscarTodos(){
		return (List<Marca>) Marca.findAll();
	}
	
	@POST
    @Transactional
    public void inserir(MarcaDTO dto) {
		Marca m = new Marca();		
		m.setNome(dto.getNome());	
		m.persist();
    }
	
	@PUT
	@Path("{marca_id}")
    @Transactional
    public void alterar(@PathParam("marca_id") Long marca_id, MarcaDTO dto) {
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
	
	@DELETE
	@Path("{marca_id}")
    @Transactional
    public void deletar(@PathParam("marca_id") Long marca_id) {
	    Optional<Marca> mOp = Marca.findByIdOptional(marca_id);
	    
	    mOp.ifPresentOrElse(Marca::delete, () -> {
	    				throw new NotFoundException();
	    		});
		
    }

}
