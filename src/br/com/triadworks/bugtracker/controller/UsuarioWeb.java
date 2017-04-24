package br.com.triadworks.bugtracker.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.triadworks.bugtracker.modelo.Usuario;

@Named
@SessionScoped
public class UsuarioWeb implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Usuario usuario;

	public void loga(Usuario usuario) {
		this.usuario = usuario;

	}

	public void desloga() {
		this.usuario = null;

	}

	public Boolean isLogado() {
		return this.usuario != null;

	}

	public Usuario getUsuario() {
		return usuario;
	}

}
