package unq.tpi.persistencia.performance.dao;

import org.hibernate.Session;
import unq.tpi.persistencia.performance.service.runner.Runner;

import java.io.Serializable;
import java.util.List;

public class BaseDAO<T> {
	
	private final Class<T> persistedEntity;
	private final String persistendEntityName;
	
	public BaseDAO(Class<T> persistedEntity, String persistendEntityName) {
		this.persistedEntity = persistedEntity;
		this.persistendEntityName = persistendEntityName;
	}

	/**
	 * @return the whole list of entities
	 */
	public List<T> getAll() {
		Session session = Runner.getCurrentSession();
		
		String hql = "from " + this.persistendEntityName;
		return session.createQuery(hql, this.persistedEntity).getResultList();
	}

	/**
	 * Gets an entity by its code (pk)
	 * @return the entity found
	 */
	public T getByCode(Serializable id) {
		Session session = Runner.getCurrentSession();
		return session.get(this.persistedEntity, id);
	}

	
	
}
