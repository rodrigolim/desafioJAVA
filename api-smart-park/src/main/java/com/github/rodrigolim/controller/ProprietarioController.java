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

import com.github.rodrigolim.entity.Proprietario;
import com.github.rodrigolim.model.ProprietarioDTO;
import com.github.rodrigolim.service.ProprietarioService;


@Path("/cadastro/proprietarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProprietarioController {
		
	ProprietarioService service;

    public ProprietarioController(ProprietarioService service) {
        this.service = service;
    }

	@GET
	public List<Proprietario> list(@QueryParam("nome") String nome) {
        return service.list(nome);
    }
	
	@POST    
    public Response create(ProprietarioDTO dto) {
		return service.create(dto);		
    }
	
	@PUT
	@Path("{proprietario_id}")
    public Response update(@PathParam("proprietario_id") Long proprietario_id, ProprietarioDTO dto) {
		return service.update(proprietario_id, dto);  	   
	}
	
	@DELETE
	@Path("{proprietario_id}")
    public Response delete(@PathParam("proprietario_id") Long proprietario_id) {
		return service.delete(proprietario_id);  	
    }	


}
