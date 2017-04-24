package br.com.triadworks.bugtraker.interceptor;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.persistence.EntityManager;

@Interceptor
@Transacional
public class TransacionalInterceptor {

	@Inject
	private EntityManager manager;

	@AroundInvoke
	public Object intercepta(InvocationContext ctx) throws Exception {
		System.out.println("Abrindo a transação");
		manager.getTransaction().begin();

		Object resultado = ctx.proceed();

		manager.getTransaction().commit();
		System.out.println("Fechando a transação");

		return resultado;
	}
}
