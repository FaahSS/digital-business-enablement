package br.com.fiap.resource;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Testes {
	public static void main(String[] args) {
		
	
	EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
	EntityManager em = fabrica.createEntityManager();
	
	AulaTO a = new AulaTO();
	a.setMateria("Arduino");
	a.setProfessor("Tiozinho");
	a.setSala(707);
	
	}
}
