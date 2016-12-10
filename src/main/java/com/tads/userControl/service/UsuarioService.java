package com.tads.userControl.service;

import java.time.LocalDate;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import com.tads.userControl.model.Usuario;
import com.tads.userControl.util.Armazenamento;

@ApplicationPath("/resource")
@Path("/usuario")
public class UsuarioService extends Application{
	
	@Path("/entrar")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response entrar(Usuario usuario){
		Armazenamento armazenamento = new Armazenamento();
		Usuario usuarioLogado = armazenamento.logar(usuario);
		if(usuarioLogado != null){
			usuarioLogado.setSenha(null);
			return Response.status(200).entity(usuarioLogado).build();
		}
		else{
			return Response.status(200).entity("{\"mensagem\" : \"Email ou senha incorretos!\"}").build();
		}
	}
	
	@Path("/cadastrar")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response cadastrar(Usuario usuario){
		Armazenamento armazenamento = new Armazenamento();
		boolean retorno = armazenamento.adicionarUsuario(usuario);
		if(retorno)
			return Response.status(200).entity("{\"mensagem\" : \"Usuário cadastrado com sucesso!\"}").build();
		else
			return Response.status(200).entity("{\"mensagem\" : \"Já existe um usuário com este email, tente entrar ou use outro email.\"}").build();
	}
	
	@Path("/buscarTodos")
	@GET
	@Produces("application/json")
	public List<Usuario> buscarTodos(){
		Armazenamento armazenamento = new Armazenamento();
		return armazenamento.getUsuarios();
	}
	
	@Path("/buscarNome/{nome}")
	@GET
	@Produces("application/json")
	public List<Usuario> buscarPorNome(@PathParam("nome") String nome){
		Armazenamento armazenamento = new Armazenamento();
		return armazenamento.encontrarUsuariosPorNome(nome);
	}
	
	@Path("/buscarCpf/{cpf}")
	@GET
	@Produces("application/json")
	public List<Usuario> buscarPorCpf(@PathParam("cpf") String cpf){
		Armazenamento armazenamento = new Armazenamento();
		return armazenamento.encontrarUsuariosPorCpf(cpf);
	}
	
	@Path("/buscarEmail/{email}")
	@GET
	@Produces("application/json")
	public List<Usuario> buscarPorEmail(@PathParam("email") String email){
		Armazenamento armazenamento = new Armazenamento();
		return armazenamento.encontrarUsuariosPorEmail(email);
	}
	
	@Path("/buscarData")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public List<Usuario> buscarPorData(LocalDate data){
		Armazenamento armazenamento = new Armazenamento();
		return armazenamento.encontrarUsuariosPorData(data);
	}
}
