package database;
import javax.ejb.Stateless;

import model.TeamMember;

@Stateless
public class TeamMemberService extends CrudAbstractService<TeamMember> {

    public TeamMemberService() {
        super(TeamMember.class);
    }

}
