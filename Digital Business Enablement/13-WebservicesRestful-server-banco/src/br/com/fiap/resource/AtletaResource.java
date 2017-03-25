package br.com.fiap.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.AtletaBO;
import br.com.fiap.entity.Atleta;

@Path("/atleta")
public class AtletaResource {
	
	private AtletaBO bo;
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Atleta buscar(@PathParam("id") int codigo) {
		return bo.buscar(codigo);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(Atleta atleta, @Context UriInfo uriInfo) {
		bo.cadastrar(atleta);
		
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		
		builder.path(Integer.toString(atleta.getCodigo()));
		
		return Response.created(builder.build()).build();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(Atleta atleta, @PathParam("id") int codigo) {
		atleta.setCodigo(codigo);
		bo.atualizar(atleta);
		
		return Response.ok().build();
	}
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int codigo) {
		bo.remover(codigo);
	}
}
