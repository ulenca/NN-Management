package database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

//trying to create a generic service for all types
public class DBservice<T> {
	/*

	@PersistenceContext(unitName="nnManagementPU")
	private EntityManager em;
	
	private transient final Class<T> entityClass;

	public DBservice() {
		entityClass = (Class) ((java.lang.reflect.ParameterizedType) this
				.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	

	 private final Class<T> entityClass;

	    public static <U> DBservice<U> createMyGeneric(Class<U> entityClass) {
	        return new DBservice<U>(entityClass);
	    }

	    protected DBservice(Class<T> entityClass) {
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
	
		*/
}
