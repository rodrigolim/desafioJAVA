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
import javax.ws.rs.core.MediaType;

import com.github.rodrigolim.entity.Marca;
import com.github.rodrigolim.model.MarcaDTO;
import com.github.rodrigolim.service.MarcaService;

import lombok.RequiredArgsConstructor;


@Path("/cadastro/marcas")
@RequiredArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MarcaController {
		
	private final MarcaService service;

	@GET
	public List<Marca> buscarTodos(){
		return service.getTodasMarcas();
	}
	
	@POST    
    public void inserir(MarcaDTO dto) {
		service.inserir(dto);
    }
	
	@PUT
	@Path("{marca_id}")
    public void alterar(@PathParam("marca_id") Long marca_id, MarcaDTO dto) {
		service.alterar(marca_id, dto);  	   
	}
	
	@DELETE
	@Path("{marca_id}")
    public void deletar(@PathParam("marca_id") Long marca_id) {
		service.deletar(marca_id);  	
    }

}
