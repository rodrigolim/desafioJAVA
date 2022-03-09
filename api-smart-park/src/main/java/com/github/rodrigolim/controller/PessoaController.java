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

import com.github.rodrigolim.entity.Pessoa;
import com.github.rodrigolim.model.PessoaDTO;


@Path("/cadastro/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaController {
		
	@GET
	public List<Pessoa> buscarTodos(){
		return Pessoa.listAll();
	}
	
	
	@POST
    @Transactional
    public void inserir(PessoaDTO dto) {
		Pessoa p = new Pessoa();
		p.setNome(dto.getNome());	
		p.setSobreNome(dto.getSobreNome());
		p.setRg(dto.getRg());		
		p.setCpf(dto.getCpf());
		p.setSexo(dto.getSexo());
		p.setDataNascimento(dto.getData_nascimento());
		p.setEndereco(dto.getEndereco());
		p.setUf(dto.getUf());
		p.setCidade(dto.getCidade());
		p.setPais(dto.getPais());
		p.setCelular(dto.getCelular());
		p.setEmail(dto.getEmail());
		p.persist();
    }
	
	@PUT
	@Path("{pessoa_id}")
    @Transactional
    public void alterar(@PathParam("pessoa_id") Long pessoa_id, PessoaDTO dto) {
	    Optional<Pessoa> pOp = Pessoa.findByIdOptional(pessoa_id);
	    
	    if (pOp.isPresent()) {
	    	Pessoa p = new Pessoa();
			p.setNome(dto.getNome());	
			p.setSobreNome(dto.getSobreNome());
			p.setRg(dto.getRg());		
			p.setCpf(dto.getCpf());
			p.setSexo(dto.getSexo());
			p.setDataNascimento(dto.getData_nascimento());
			p.setEndereco(dto.getEndereco());
			p.setUf(dto.getUf());
			p.setCidade(dto.getCidade());
			p.setPais(dto.getPais());
			p.setCelular(dto.getCelular());
			p.setEmail(dto.getEmail());
			p.persist();	
	    }
	    else {
	    	throw new NotFoundException();
	    }    	   
	}
	
	@DELETE
	@Path("{pessoa_id}")
    @Transactional
    public void deletar(@PathParam("pessoa_id") Long pessoa_id) {
	    Optional<Pessoa> mOp = Pessoa.findByIdOptional(pessoa_id);
	    
	    mOp.ifPresentOrElse(Pessoa::delete, () -> {
	    				throw new NotFoundException();
	    		});
		
    }


}
