package br.com.triadworks.bugtracker.controller;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import br.com.triadworks.bugtracker.util.Constantes;

@FacesValidator("senhaForte")
public class SenhaForteValidator implements Validator {

	@Override
	public void validate(FacesContext ctx, UIComponent component, Object value)
			throws ValidatorException {
		String valor = value.toString();
		if (!valor.contains("@")) {
			FacesMessage msg = new FacesMessage();
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			msg.setSummary(Constantes.MSG_VALIDACAO_SENHA);
			msg.setDetail(Constantes.MSG_VALIDACAO_SENHA_CARACTERE);
			throw new ValidatorException(msg);
		}

	}

}
