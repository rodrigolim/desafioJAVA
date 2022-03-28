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

import com.github.rodrigolim.entity.Marca;
import com.github.rodrigolim.model.MarcaDTO;
import com.github.rodrigolim.service.MarcaService;

@Path("/cadastro/marcas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarcaController {
		
	MarcaService service;

    public MarcaController(MarcaService service) {
        this.service = service;
    }

	@GET
	public List<Marca> list(@QueryParam("nome") String nome) {
        return service.list(nome);
    }
	
	@POST    
    public Response create(MarcaDTO dto) {
		return service.create(dto);		
    }
	
	@PUT
	@Path("{marca_id}")
    public Response update(@PathParam("marca_id") Long marca_id, MarcaDTO dto) {
		return service.update(marca_id, dto);  	   
	}
	
	@DELETE
	@Path("{marca_id}")
    public Response delete(@PathParam("marca_id") Long marca_id) {
		return service.delete(marca_id);  	
    }

}
