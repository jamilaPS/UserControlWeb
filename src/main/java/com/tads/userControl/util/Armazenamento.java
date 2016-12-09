package com.tads.userControl.util;

import java.util.ArrayList;
import java.util.List;

import com.tads.userControl.model.Usuario;

public class Armazenamento {
	private List<Usuario> usuarios;

	public Armazenamento(){
		usuarios = new ArrayList<>();
	}
	
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
