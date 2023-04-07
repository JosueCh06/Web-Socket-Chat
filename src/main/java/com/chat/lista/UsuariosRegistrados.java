package com.chat.lista;

import java.util.HashSet;
import java.util.Set;

public class UsuariosRegistrados {
	
	private Set<String> lista;
	
	public UsuariosRegistrados() {
		lista=new HashSet<>();
	}
	
	public int registrar(String user) {
		if(!lista.contains(user)) {
			lista.add(user);
			return 1;
		}
		else
			return -1;
	}

	public Set<String> getLista() {
		return lista;
	}

	public void setLista(Set<String> lista) {
		this.lista = lista;
	}
	
	
}
