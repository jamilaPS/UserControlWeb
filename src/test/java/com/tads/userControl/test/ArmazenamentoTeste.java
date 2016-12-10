package com.tads.userControl.test;

import java.time.LocalDate;
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
	public void logar(){
		Usuario u1 = new Usuario();
		u1.setEmail("joao@mail.com");
		u1.setSenha("123");
		armazenamento.adicionarUsuario(u1);
		
		Usuario u2 = new Usuario();
		u2.setEmail("maria@mail.com");
		u2.setSenha("123");
		armazenamento.adicionarUsuario(u2);
		
		Assert.assertEquals("Não trouxe o usuário correto", u2.getEmail(), armazenamento.logar(u2).getEmail());
		
		Usuario u3 = new Usuario();
		u3.setEmail("teste@mail.com");
		u3.setSenha("123");
		
		Assert.assertEquals(null, armazenamento.logar(u3));
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
		usuario.setDataNascimento(LocalDate.now());
		armazenamento.adicionarUsuario(usuario);
		Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(armazenamento.encontrarUsuariosPorData(usuario.getDataNascimento()).size()));
	}
}
