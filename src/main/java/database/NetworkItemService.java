package database;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.persistence.criteria.CriteriaQuery;




import model.NetworkItem;

@Stateless
public class NetworkItemService {
	
	@PersistenceContext(unitName="nnManagementPU")
	private EntityManager em;
	
	private static final Logger logger = Logger.getLogger("NetworkItemService");

	protected EntityManager getEntityManager() {
		return em;
	}
	
	
	public NetworkItem read(Object id) {
		return getEntityManager().find(NetworkItem.class, id);
	}
	
	
	public NetworkItem save(NetworkItem entity) {
		return getEntityManager().merge(entity);
	}
	
	public List<NetworkItem> findAll(){
		CriteriaQuery<NetworkItem> cq = getEntityManager().getCriteriaBuilder().createQuery(NetworkItem.class);
		cq.select(cq.from(NetworkItem.class));
		Query query = getEntityManager().createQuery(cq);
		System.out.println("Network items size: " + query.getResultList().size());
		return getEntityManager().createQuery(cq).getResultList();
	}
}
