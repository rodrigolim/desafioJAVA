package com.github.rodrigolim.service;

import java.util.List;
import java.util.Optional;

import com.github.rodrigolim.entity.Proprietario;
import com.github.rodrigolim.model.ProprietarioDTO;
import com.github.rodrigolim.repository.ProprietarioRepository;

import lombok.*;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@RequestScoped
@RequiredArgsConstructor
public class ProprietarioService {
  
	private final  ProprietarioRepository repository;

    public List<Proprietario> list(String nome){
		if (nome != null) {
            return repository.findByNome(nome);
        }
		return Proprietario.listAll();
	}


    @Transactional
    public Response create(ProprietarioDTO dto) {
        Proprietario obj = new Proprietario();		
        obj.setNome(dto.getNome());	
        obj.setTipo(dto.getTipo());
        obj.setCnpj(dto.getCnpj());
        obj.setCpf(dto.getCpf());
        obj.setEndereco(dto.getEndereco());
        obj.setUf(dto.getUf());
        obj.setCidade(dto.getCidade());
        obj.setPais(dto.getPais());
        obj.setTelefone(dto.getTelefone());
        obj.setEmail(dto.getEmail());				
        obj.persist();
		 return Response.status(Status.CREATED).entity(obj).build();
    }

    @Transactional
    public Response update(Long _id, ProprietarioDTO dto) {
        Optional<Proprietario> objOp = Proprietario.findByIdOptional(_id);
	    
	    if (objOp.isPresent()) {
	    	Proprietario obj = objOp.get();
            obj.setNome(dto.getNome());	
            obj.setTipo(dto.getTipo());
            obj.setCnpj(dto.getCnpj());
            obj.setCpf(dto.getCpf());
            obj.setEndereco(dto.getEndereco());
            obj.setUf(dto.getUf());
            obj.setCidade(dto.getCidade());
            obj.setPais(dto.getPais());
            obj.setTelefone(dto.getTelefone());
            obj.setEmail(dto.getEmail());		
			return Response.status(Status.CREATED).entity(obj).build();
	    }
	    else {
	    	throw new NotFoundException();
	    } 
    }

    @Transactional
    public Response delete(Long _id) {
	    Optional<Proprietario> objOp = Proprietario.findByIdOptional(_id);

		if (objOp.isPresent()){
			Proprietario obj = objOp.get();
			obj.delete();
			return Response.status(Status.OK).entity(obj).build();
		}
	    else {
	    	throw new NotFoundException();
	    } 
		
    }  
}
