package br.com.triadworks.bugtracker.controller;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.Constantes;
import br.com.triadworks.bugtracker.util.FacesUtils;
import br.com.triadworks.bugtraker.interceptor.Transacional;

@Named
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	@Inject
	private UsuarioDao dao;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Transacional
	public void salva() {
		if (this.usuario.getId() == null) {
			dao.adiciona(this.usuario);
<<<<<<< HEAD
			new FacesUtils()
					.adicionaMensagemDeSucesso(Constantes.MSG_ADICIONADO_SUCESSO);
		} else {
			dao.atualiza(usuario);
			new FacesUtils()
					.adicionaMensagemDeSucesso(Constantes.MSG_ATUALIZADO_SUCESSO);
=======
			new FacesUtils().adicionaMensagemDeSucesso(Constantes.MSG_ADICIONADO_SUCESSO);
		} else {
			dao.atualiza(usuario);

			new FacesUtils().adicionaMensagemDeSucesso(Constantes.MSG_ALTERADO_SUCESSO);
>>>>>>> 6835bf475ef6c25d778621181439a1a70b5686ef
		}

		this.usuario = new Usuario();

	}

	public List<Usuario> getUsuarios() {
		return dao.lista();
	}

	@Transacional
	public void remove(Usuario u) {
		dao.remove(u);
		new FacesUtils().adicionaMensagemDeErro(Constantes.MSG_REMOVIDO_SUCESSO);
	}

	public void cancela() {
		this.usuario = new Usuario();

	}

}
