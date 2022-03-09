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

import com.github.rodrigolim.entity.Proprietario;
import com.github.rodrigolim.model.ProprietarioDTO;


@Path("proprietarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProprietarioController {
		
	@GET
	public List<Proprietario> buscarTodos(){
		return Proprietario.listAll();
	}
	
	
	@POST
    @Transactional
    public void inserir(ProprietarioDTO dto) {
		Proprietario p = new Proprietario();
		p.setNome(dto.getNome());	
		p.setTipo(dto.getTipo());
		p.setCnpj(dto.getCnpj());
		p.setCpf(dto.getCpf());
		p.setEndereco(dto.getEndereco());
		p.setUf(dto.getUf());
		p.setCidade(dto.getCidade());
		p.setPais(dto.getPais());
		p.setTelefone(dto.getTelefone());
		p.setEmail(dto.getEmail());
		p.persist();
    }
	
	@PUT
	@Path("{proprietario_id}")
    @Transactional
    public void alterar(@PathParam("proprietario_id") Long proprietario_id, ProprietarioDTO dto) {
	    Optional<Proprietario> pOp = Proprietario.findByIdOptional(proprietario_id);
	    
	    if (pOp.isPresent()) {
	    	Proprietario p = pOp.get();
	    	p.setNome(dto.getNome());	
			p.setTipo(dto.getTipo());
			p.setCnpj(dto.getCnpj());
			p.setCpf(dto.getCpf());
			p.setEndereco(dto.getEndereco());
			p.setUf(dto.getUf());
			p.setCidade(dto.getCidade());
			p.setPais(dto.getPais());
			p.setTelefone(dto.getTelefone());
			p.setEmail(dto.getEmail());				
			p.persist();	
	    }
	    else {
	    	throw new NotFoundException();
	    }    	   
	}
	
	@DELETE
	@Path("{proprietario_id}")
    @Transactional
    public void deletar(@PathParam("proprietario_id") Long proprietario_id) {
	    Optional<Proprietario> mOp = Proprietario.findByIdOptional(proprietario_id);
	    
	    mOp.ifPresentOrElse(Proprietario::delete, () -> {
	    				throw new NotFoundException();
	    		});
		
    }


}
