package com.tads.userControl.test;

import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.tads.userControl.model.Usuario;
import com.tads.userControl.util.Armazenamento;

public class ArmazenamentoTeste {
	Armazenamento armazenamento;

	@Before
	public void iniciarArmazenamento(){
		armazenamento = new Armazenamento();
	}
	
	@After
	public void limparArmazenamento(){
		armazenamento.limpar();
	}
	
	@Test
	public void adicionarUsuario(){
		Integer esperado = armazenamento.numeroDeUsuarios() + 1;
		armazenamento.adicionarUsuario(new Usuario());
		Assert.assertEquals(esperado, armazenamento.numeroDeUsuarios());
	}
	
	@Test
	public void limpar(){
		Integer esperado = 0;
		Assert.assertEquals(esperado, armazenamento.numeroDeUsuarios());
	}

	@Test
	public void encontrarUsuariosPorNome(){
		Usuario usuario = new Usuario();
		usuario.setNome("Teste");
		armazenamento.adicionarUsuario(usuario);
		Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(armazenamento.encontrarUsuariosPorNome(usuario.getNome()).size()));
	}
	
	@Test
	public void encontrarUsuariosPorCpf(){
		Usuario usuario = new Usuario();
		usuario.setCpf("123");
		armazenamento.adicionarUsuario(usuario);
		Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(armazenamento.encontrarUsuariosPorCpf(usuario.getCpf()).size()));
	}
	
	@Test
	public void encontrarUsuariosPorEmail(){
		Usuario usuario = new Usuario();
		usuario.setEmail("teste@mail.com");
		armazenamento.adicionarUsuario(usuario);
		Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(armazenamento.encontrarUsuariosPorEmail(usuario.getEmail()).size()));
	}
	
	@Test
	public void encontrarUsuariosPorData(){
		Usuario usuario = new Usuario();
		usuario.setDataNascimento(new Date());
		armazenamento.adicionarUsuario(usuario);
		Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(armazenamento.encontrarUsuariosPorData(usuario.getDataNascimento()).size()));
	}
}
