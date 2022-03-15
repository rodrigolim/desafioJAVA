package com.github.rodrigolim.service;

import java.util.List;
import java.util.Optional;

import com.github.rodrigolim.entity.Pessoa;
import com.github.rodrigolim.model.PessoaDTO;
import com.github.rodrigolim.repository.PessoaRepository;

import lombok.*;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@RequestScoped
@RequiredArgsConstructor
public class PessoaService {
  
	private final  PessoaRepository repository;

    public List<Pessoa> list(String nome){
		if (nome != null) {
            return repository.findByNome(nome);
        }
		return Pessoa.listAll();
	}


    @Transactional
    public Response create(PessoaDTO dto) {
        Pessoa obj = new Pessoa();		
         obj.setNome(dto.getNome());	
         obj.setSobreNome(dto.getSobreNome());
         obj.setRg(dto.getRg());		
         obj.setCpf(dto.getCpf());
         obj.setSexo(dto.getSexo());
         obj.setDataNascimento(dto.getData_nascimento());
         obj.setEndereco(dto.getEndereco());
         obj.setUf(dto.getUf());
         obj.setCidade(dto.getCidade());
         obj.setPais(dto.getPais());
         obj.setCelular(dto.getCelular());
         obj.setEmail(dto.getEmail());	
		 obj.persist();
		 return Response.status(Status.CREATED).entity(obj).build();
    }

    @Transactional
    public Response update(Long _id, PessoaDTO dto) {
        Optional<Pessoa> objOp = Pessoa.findByIdOptional(_id);
	    
	    if (objOp.isPresent()) {
	    	Pessoa obj = objOp.get();
	    	obj.setNome(dto.getNome());	
            obj.setSobreNome(dto.getSobreNome());
            obj.setRg(dto.getRg());		
            obj.setCpf(dto.getCpf());
            obj.setSexo(dto.getSexo());
            obj.setDataNascimento(dto.getData_nascimento());
            obj.setEndereco(dto.getEndereco());
            obj.setUf(dto.getUf());
            obj.setCidade(dto.getCidade());
            obj.setPais(dto.getPais());
            obj.setCelular(dto.getCelular());
            obj.setEmail(dto.getEmail());	
			obj.persist();	
			return Response.status(Status.CREATED).entity(obj).build();
	    }
	    else {
	    	throw new NotFoundException();
	    } 
    }

    @Transactional
    public Response delete(Long _id) {
	    Optional<Pessoa> objOp = Pessoa.findByIdOptional(_id);

		if (objOp.isPresent()){
			Pessoa obj = objOp.get();
			obj.delete();
			return Response.status(Status.OK).entity(obj).build();
		}
	    else {
	    	throw new NotFoundException();
	    } 
		
    }  
}
