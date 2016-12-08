package com.tads.userControl.service;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;

import com.tads.userControl.model.Usuario;

@ApplicationPath("/resource")
@Path("/usuario")
public class UsuarioService extends Application{

	@Path("/entrar")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Usuario entrar(Usuario usuario){
		return new Usuario();
	}
}
