package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/aula")
public class AulaResource {
	private EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
		public AulaTO buscar(@PathParam("id") int codigo) throws Exception { 
		EntityManager em = fabrica.createEntityManager();
		AulaDAOImpl dao = new AulaDAOImpl(em);
		return dao.buscar(codigo);
	}

}
