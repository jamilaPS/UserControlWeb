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

	public void adicionarUsuario(Usuario usuario){
		Armazenamento.usuarios.add(usuario);
	}
	
	public List<Usuario> encontrarUsuariosPorNome(String nomeFiltro){
		return Armazenamento.usuarios.stream().filter(u -> u.getNome().contains(nomeFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> encontrarUsuariosPorCpf(String cpfFiltro){
		return Armazenamento.usuarios.stream().filter(u -> u.getNome().equals(cpfFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> encontrarUsuariosPorEmail(String emailFiltro){
		return Armazenamento.usuarios.stream().filter(u -> u.getNome().equals(emailFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> encontrarUsuariosPorData(Date data){
		LocalDate dataFiltro = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return Armazenamento.usuarios.stream().filter(u -> u.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(dataFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> encontrarUsuariosMaioresDeIdade(Date data){
		LocalDate dataFiltro = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate hoje = LocalDate.now();
		return Armazenamento.usuarios.stream().filter(u -> u.getDataNascimento().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().isEqual(dataFiltro)).collect(Collectors.toList());
	}
	
	public List<Usuario> encontrarUsuariosMenoresDeIdade(Date data){
		return null;
	}
	
	public List<Usuario> getUsuarios() {
		return Armazenamento.usuarios;
	}
	
}
