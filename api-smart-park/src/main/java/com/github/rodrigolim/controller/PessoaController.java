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

import com.github.rodrigolim.entity.Pessoa;
import com.github.rodrigolim.model.PessoaDTO;
import com.github.rodrigolim.service.PessoaService;

@Path("/cadastro/pessoa")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PessoaController {

	PessoaService service;

    public PessoaController(PessoaService service) {
        this.service = service;
    }

	@GET
	public List<Pessoa> list(@QueryParam("nome") String nome) {
        return service.list(nome);
    }
	
	@POST    
    public Response create(PessoaDTO dto) {
		return service.create(dto);		
    }
	
	@PUT
	@Path("{pessoa_id}")
    public Response update(@PathParam("pessoa_id") Long pessoa_id, PessoaDTO dto) {
		return service.update(pessoa_id, dto);  	   
	}
	
	@DELETE
	@Path("{pessoa_id}")
    public Response delete(@PathParam("pessoa_id") Long pessoa_id) {
		return service.delete(pessoa_id);  	
    }	
	

}
