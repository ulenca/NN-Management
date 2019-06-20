package database;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.TeamMember;

@Stateless
public class TeamMemberService extends CrudAbstractService<TeamMember> {

    public TeamMemberService() {
        super(TeamMember.class);
    }

    
	public TeamMember findByLogin(String login){
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<TeamMember> criteriaQuery = criteriaBuilder.createQuery(TeamMember.class);
		Root<TeamMember> root = criteriaQuery.from(TeamMember.class);
		criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("login"), login));
		getEntityManager().createQuery(criteriaQuery);
		return getEntityManager().createQuery(criteriaQuery).getSingleResult();
	}
}
