package com.tads.userControl.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.tads.userControl.model.Usuario;

public class Armazenamento {
	private static List<Usuario> usuarios = new ArrayList<Usuario>();

	public boolean adicionarUsuario(Usuario usuario){
		if(!(encontrarUsuariosPorEmail(usuario.getEmail()).size() > 0)){
			Armazenamento.usuarios.add(usuario);
			return true;
		}
		else
			return false;
	}
	
	public void limpar(){
		Armazenamento.usuarios = new ArrayList<Usuario>();
	}
	
	public Integer numeroDeUsuarios(){
		return usuarios.size();
	}
	
	public Usuario logar(Usuario usuario){
		List<Usuario> usuariosFiltrados = Armazenamento.usuarios.stream().filter(u -> u.getEmail().equals(usuario.getEmail()))
				.filter(u -> u.getSenha().equals(usuario.getSenha())).collect(Collectors.toList());
		if(usuariosFiltrados.size() > 0)
			return usuariosFiltrados.get(0);
		else
			return null; 
	}
	
	public List<Usuario> encontrarUsuariosPorNome(String nomeFiltro){
		return Armazenamento.usuarios.stream().filter(u -> u.getNome().contains(nomeFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> encontrarUsuariosPorCpf(String cpfFiltro){
		return Armazenamento.usuarios.stream().filter(u -> u.getCpf().equals(cpfFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> encontrarUsuariosPorEmail(String emailFiltro){
		return Armazenamento.usuarios.stream().filter(u -> u.getEmail().equals(emailFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> encontrarUsuariosPorData(LocalDate dataFiltro){
		return Armazenamento.usuarios.stream().filter(u -> u.getDataNascimento().isEqual(dataFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> getUsuarios() {
		return Armazenamento.usuarios;
	}
	
}
