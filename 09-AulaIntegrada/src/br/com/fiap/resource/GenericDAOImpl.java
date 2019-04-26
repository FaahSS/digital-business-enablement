package br.com.fiap.resource;


import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;



public abstract class GenericDAOImpl <T, K> implements GenericDAO<T, K>{
	private EntityManager em;
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em) {
		super();
		this.em = em;
		this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(T entidade) {
		em.persist(entidade);
	}
	
	@Override
	public void atualizar(T entidade) {
		em.merge(entidade);
	}
	
	@Override
	public void remover(K id) throws Exception{
		T entidade = buscar(id);
		if(entidade==null) {
			throw new Exception("Registro não encontrado");
		}
		em.remove(entidade);
	}
	
	@Override
	public T buscar(K id) throws Exception{
		T entidade = em.find(clazz, id);
		if(entidade == null) {
			throw new Exception();
		}
		return entidade;
	}
	
	public void commit() throws Exception{
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
			throw new Exception();
		}
	}
}
