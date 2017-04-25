package br.com.triadworks.bugtracker.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.service.Autenticador;
import br.com.triadworks.bugtracker.util.Constantes;
import br.com.triadworks.bugtracker.util.FacesUtils;

@Named
@RequestScoped
public class LoginBean {
	private String login;
	private String senha;

	@Inject
	private UsuarioWeb usuarioWeb;
	@Inject
	private Autenticador autenticador;

	public String logar() {

		Usuario usuario = autenticador.autentica(login, senha);
		if (usuario != null) {
			usuarioWeb.loga(usuario);
			return "/pages/usuarios?faces-redirect=true";
		}
		new FacesUtils().adicionaMensagemDeErro(Constantes.MSG_LOGIN_INVALIDO);
		return null;
	}

	public String sair() {
		usuarioWeb.desloga();
		return "/pages/login?faces-redirect=true";

	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	public UsuarioWeb getUsuarioWeb() {
		return usuarioWeb;
	}

}
