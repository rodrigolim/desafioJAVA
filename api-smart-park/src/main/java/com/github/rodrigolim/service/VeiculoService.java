package com.github.rodrigolim.service;

import java.util.List;
import java.util.Optional;

import com.github.rodrigolim.entity.Veiculo;
import com.github.rodrigolim.model.VeiculoDTO;
import com.github.rodrigolim.repository.VeiculoRepository;

import lombok.*;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@RequestScoped
@RequiredArgsConstructor
public class VeiculoService {
  
	private final  VeiculoRepository repository;

    public List<Veiculo> list(String nome){
		if (nome != null) {
            return repository.findByNome(nome);
        }
		return Veiculo.listAll();
	}


    @Transactional
    public Response create(VeiculoDTO dto) {
        Veiculo obj = new Veiculo();		
        obj.setAtivo(dto.isAtivo());	
        obj.setCategoria(dto.getCategoria());
        obj.setChassi(dto.getChassi());
        obj.setPlaca(dto.getPlaca());
        obj.setModelo(dto.getModelo());
        obj.setCor(dto.getCor());
        obj.setAnoFabricacao(dto.getAno_fabricacao());
        obj.setAnoFabricacao(dto.getAno_modelo());
        obj.setMarca(dto.getMarca());
        obj.setProprietario(dto.getProprietario());
        obj.setPessoa(dto.getPessoa());
        obj.persist();
		 return Response.status(Status.CREATED).entity(obj).build();
    }

    @Transactional
    public Response update(Long _id, VeiculoDTO dto) {
        Optional<Veiculo> objOp = Veiculo.findByIdOptional(_id);
	    
	    if (objOp.isPresent()) {
	    	Veiculo obj = objOp.get();
            obj.setAtivo(dto.isAtivo());	
            obj.setCategoria(dto.getCategoria());
            obj.setChassi(dto.getChassi());
            obj.setPlaca(dto.getPlaca());
            obj.setModelo(dto.getModelo());
            obj.setCor(dto.getCor());
            obj.setAnoFabricacao(dto.getAno_fabricacao());
            obj.setAnoFabricacao(dto.getAno_modelo());
            obj.setMarca(dto.getMarca());
            obj.setProprietario(dto.getProprietario());
            obj.setPessoa(dto.getPessoa());
            obj.persist();	
			return Response.status(Status.CREATED).entity(obj).build();
	    }
	    else {
	    	throw new NotFoundException();
	    } 
    }

    @Transactional
    public Response delete(Long _id) {
	    Optional<Veiculo> objOp = Veiculo.findByIdOptional(_id);

		if (objOp.isPresent()){
			Veiculo obj = objOp.get();
			obj.delete();
			return Response.status(Status.OK).entity(obj).build();
		}
	    else {
	    	throw new NotFoundException();
	    } 
		
    }  
}
