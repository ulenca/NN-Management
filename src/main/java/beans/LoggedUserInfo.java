package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.ExternalContext;
import javax.inject.Inject;

import database.TeamMemberService;
import model.Role;

public class LoggedUserInfo implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject TeamMemberService teamMemberService;
	
	public boolean isLoggedUserInOneOfRoles(List<Role> roles, ExternalContext ec) {	
		Role userRole = teamMemberService.findByLogin(ec.getRemoteUser()).getRole();		
		System.out.println("Logged in user: " + ec.getRemoteUser() + " role " + userRole);
		for(Role e:roles) {
			if(e.equals(userRole)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isLoggedUserInRoles(Role role, ExternalContext ec) {	
		Role userRole = teamMemberService.findByLogin(ec.getRemoteUser()).getRole();		
		System.out.println("Logged in user: " + ec.getRemoteUser() + " role " + userRole);
		return userRole.equals(role);
	}
	
	
}
