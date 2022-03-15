package com.github.rodrigolim.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.rodrigolim.entity.Veiculo;
import com.github.rodrigolim.model.VeiculoDTO;
import com.github.rodrigolim.service.VeiculoService;


@Path("/cadastro/veiculos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VeiculoController {

	VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

	@GET
	public List<Veiculo> list(@QueryParam("nome") String nome) {
        return service.list(nome);
    }
	
	@POST    
    public Response create(VeiculoDTO dto) {
		return service.create(dto);		
    }
	
	@PUT
	@Path("{veiculo_id}")
    public Response update(@PathParam("veiculo_id") Long veiculo_id, VeiculoDTO dto) {
		return service.update(veiculo_id, dto);  	   
	}
	
	@DELETE
	@Path("{veiculo_id}")
    public Response delete(@PathParam("veiculo_id") Long veiculo_id) {
		return service.delete(veiculo_id);  	
    }

}
