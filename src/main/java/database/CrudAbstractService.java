package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

public class CrudAbstractService<T> {
	

	@PersistenceContext(unitName="nnManagementPU")
	private EntityManager em;
	
	private final Class<T> entityClass;
	
	public CrudAbstractService(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<T> findAll(){
		CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(entityClass);
		cq.select(cq.from(entityClass));
		Query query = getEntityManager().createQuery(cq);
		System.out.println("Network items size: " + query.getResultList().size());
		return getEntityManager().createQuery(cq).getResultList();
	}
	
	public T read(Object id) {
		return getEntityManager().find(entityClass, id);
	}
	
	
	public T save(T entity) {
		return getEntityManager().merge(entity);
	}
	
	public void delete(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
}
