package br.com.triadworks.bugtracker.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.triadworks.bugtracker.dao.UsuarioDao;
import br.com.triadworks.bugtracker.modelo.Usuario;
import br.com.triadworks.bugtracker.util.Constantes;
import br.com.triadworks.bugtracker.util.FacesUtils;

@ManagedBean
public class UsuarioBean {
	private Usuario usuario = new Usuario();

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void salva() {
		UsuarioDao dao = new UsuarioDao();
		if (this.usuario.getId() == null) {
			dao.adiciona(this.usuario);
		} else {
			dao.atualiza(usuario);
		}
		new FacesUtils()
				.adicionaMensagemDeErro(Constantes.MSG_ADICIONADO_SUCESSO);
		this.usuario = new Usuario();

	}

	public List<Usuario> getUsuarios() {
		UsuarioDao dao = new UsuarioDao();
		return dao.lista();
	}

	public void remove(Usuario u) {
		UsuarioDao dao = new UsuarioDao();
		dao.remove(u);
		new FacesUtils()
				.adicionaMensagemDeErro(Constantes.MSG_REMOVIDO_SUCESSO);
	}

	public void cancela() {
		this.usuario = new Usuario();

	}

}
