package br.com.fiap.resource;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@ManagedBean
public class ClienteBean {
	
	private String nomeBusca;
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public List<String> completaNomeCliente(String nome){
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em = fabrica.createEntityManager();
		ClienteDAOImpl dao = new ClienteDAOImpl(em);
		return dao.buscarPorNomeCliente(nome);
	}

}
