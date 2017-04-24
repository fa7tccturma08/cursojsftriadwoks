package br.com.triadworks.bugtracker.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.triadworks.bugtracker.modelo.Usuario;

public class UsuarioDao {

	@Inject
	private EntityManager manager;

	public void adiciona(Usuario usuario) {

		manager.persist(usuario);
	}

	public void atualiza(Usuario usuario) {

		// conexao
		manager.merge(usuario);
	}

	public void remove(Usuario usuario) {
		manager.remove(manager.merge(usuario));
	}

	public Usuario busca(Integer id) {
		// conexao
		return manager.find(Usuario.class, id);
	}

	public List<Usuario> lista() {

		return manager.createQuery("select u from Usuario u", Usuario.class)
				.getResultList();
	}

	public Usuario buscaPor(String login, String senha) {

		// conexao

		try {
			return manager
					.createQuery(
							"select u from Usuario u "
									+ "where u.login = :login "
									+ "  and u.senha = :senha", Usuario.class)
					.setParameter("login", login).setParameter("senha", senha)
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
