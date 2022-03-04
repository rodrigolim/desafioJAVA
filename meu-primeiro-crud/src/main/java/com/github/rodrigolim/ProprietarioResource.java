package com.github.rodrigolim;


import java.math.BigInteger;
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


@Path("proprietarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProprietarioResource {
		
	@GET
	public List<Proprietario> buscarTodosProprietarios(){
		return Proprietario.listAll();
	}
	
	
	@POST
    @Transactional
    public void buscarTodosProprietarios(CadastrarProprietarioDTO dto) {
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
    public void buscarTodosProprietarios(@PathParam("proprietario_id") BigInteger proprietario_id, CadastrarProprietarioDTO dto) {
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
    public void buscarTodosProprietarios(@PathParam("proprietario_id") BigInteger proprietario_id) {
	    Optional<Proprietario> mOp = Proprietario.findByIdOptional(proprietario_id);
	    
	    mOp.ifPresentOrElse(Proprietario::delete, () -> {
	    				throw new NotFoundException();
	    		});
		
    }


}