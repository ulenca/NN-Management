package database;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import javax.persistence.criteria.CriteriaQuery;

import model.TeamMember;

@Stateless
public class TeamMemberService {
	
	@PersistenceContext(unitName="nnManagementPU")
	private EntityManager em;
	

	protected EntityManager getEntityManager() {
		return em;
	}
	
	
	public TeamMember read(Object id) {
		return getEntityManager().find(TeamMember.class, id);
	}
	
	
	public TeamMember save(TeamMember entity) {
		return getEntityManager().merge(entity);
	}
	
	public void delete(TeamMember entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}
	
	public List<TeamMember> findAll(){
		CriteriaQuery<TeamMember> cq = getEntityManager().getCriteriaBuilder().createQuery(TeamMember.class);
		cq.select(cq.from(TeamMember.class));
		Query query = getEntityManager().createQuery(cq);
		System.out.println("Network items size: " + query.getResultList().size());
		return getEntityManager().createQuery(cq).getResultList();
	}
}
