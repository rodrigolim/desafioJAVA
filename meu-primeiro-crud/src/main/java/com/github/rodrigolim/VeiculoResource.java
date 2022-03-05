package com.github.rodrigolim;

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


@Path("veiculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VeiculoResource {
		
	@GET
	public List<Veiculo> buscarTodos(){
		return Veiculo.listAll();
	}
	
	
	@POST
    @Transactional
    public void inserir(CadastrarVeiculoDTO dto) {
		Veiculo v = new Veiculo();
		v.setAtivo(dto.getAtivo());	
		v.setCategoria(dto.getCategoria());
		v.setChassi(dto.getChassi());
		v.setPlaca(dto.getPlaca());
		v.setModelo(dto.getModelo());
		v.setCor(dto.getCor());
		v.setAno_fabricacao(dto.getAno_fabricacao());
		v.setAno_modelo(dto.getAno_modelo());
		v.setMarca(dto.getMarca());
		v.setProprietario(dto.getProprietario());
		v.setPessoa(dto.getPessoa());
		v.persist();
    }
	
	@PUT
	@Path("{veiculo_id}")
    @Transactional
    public void alterar(@PathParam("veiculo_id") Long veiculo_id, CadastrarVeiculoDTO dto) {
	    Optional<Veiculo> pOp = Veiculo.findByIdOptional(veiculo_id);
	    
	    if (pOp.isPresent()) {
	    	Veiculo v = pOp.get();
			v.setAtivo(dto.getAtivo());	
			v.setCategoria(dto.getCategoria());
			v.setChassi(dto.getChassi());
			v.setPlaca(dto.getPlaca());
			v.setModelo(dto.getModelo());
			v.setCor(dto.getCor());
			v.setAno_fabricacao(dto.getAno_fabricacao());
			v.setAno_modelo(dto.getAno_modelo());
			v.setMarca(dto.getMarca());
			v.setProprietario(dto.getProprietario());
			v.setPessoa(dto.getPessoa());
			v.persist();	
	    }
	    else {
	    	throw new NotFoundException();
	    }    	   
	}
	
	@DELETE
	@Path("{veiculo_id}")
    @Transactional
    public void deletar(@PathParam("veiculo_id") Long veiculo_id) {
	    Optional<Veiculo> mOp = Veiculo.findByIdOptional(veiculo_id);
	    
	    mOp.ifPresentOrElse(Veiculo::delete, () -> {
	    				throw new NotFoundException();
	    		});
		
    }


}
