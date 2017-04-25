package br.com.triadworks.bugtracker.controller;

import java.util.Arrays;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.triadworks.bugtracker.dao.BugDao;
import br.com.triadworks.bugtracker.modelo.Bug;
import br.com.triadworks.bugtracker.modelo.Status;
import br.com.triadworks.bugtracker.util.Constantes;
import br.com.triadworks.bugtracker.util.FacesUtils;
import br.com.triadworks.bugtraker.interceptor.Transacional;

@Named
@RequestScoped
public class BugBean {
	private Bug bug = new Bug();

	@Inject
	private BugDao bugDao;

	@Transacional
	public void salva() {
		this.bugDao.adiciona(bug);
		this.bug = new Bug();
		new FacesUtils()
				.adicionaMensagemDeSucesso(Constantes.MSG_BUG_ADCIONADO_SUCESSO);

	}

	public List<Status> getTodosOsStatus() {
		return Arrays.asList(Status.values());
	}

	public Bug getBug() {
		return bug;
	}

	public void setBug(Bug bug) {
		this.bug = bug;
	}

	public BugDao getBugDao() {
		return bugDao;
	}

	public void setBugDao(BugDao bugDao) {
		this.bugDao = bugDao;
	}

}
