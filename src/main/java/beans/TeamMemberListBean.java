package beans;

import javax.inject.Inject;
import javax.inject.Named;

import database.NetworkItemService;
import database.TeamMemberService;

import java.io.Serializable;

import java.util.List;

import model.NetworkItem;
import model.TeamMember;
import validators.BeanValidator;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;


@Named
@SessionScoped
public class TeamMemberListBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Inject TeamMemberService teamMemberService;
	@Inject NetworkItemService networkItemService;
	
	private List<TeamMember> teamMemberList;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private int id;
	private TeamMember selectedTeamMember;
	
	
		@PostConstruct
		public void init() {

			teamMemberList = teamMemberService.findAll();
		}
		
		public void addTeamMember() {
			System.out.println("Adding team member...");
			FacesContext fc = FacesContext.getCurrentInstance();
			
			if(!BeanValidator.isValueDuplicated(fc, login, teamMemberList)) {
				TeamMember newTM = new TeamMember(firstName, lastName, login, password);
				teamMemberService.save(newTM);
				addNetworkItems(newTM.getLogin());
				clearTeamMember();
				init();
			} 
			
		}
		
		//adds rows to the network table to connect new teammember with others
		public void addNetworkItems(String login) {
			TeamMember newTM = teamMemberService.findByLogin(login);
			for(TeamMember e: teamMemberList) {
				if (!e.getLogin().equals(login)) {
					networkItemService.save(new NetworkItem(newTM, e, 0));
				}
			}
		}
		
		public void deleteTeamMember(TeamMember teamMember) {
			
			System.out.println("Trying to remove record.." + teamMember.getFirstName());
			teamMemberService.delete(teamMember);
			System.out.println("Record removed");
			init();

		}
			
		public void updateTeamMember() {
			
			System.out.println("Trying to update record.." + selectedTeamMember.getFirstName());
			teamMemberService.save(selectedTeamMember);
			System.out.println("Record updated");
			init();

		}
		
		public void setSelectedTeamMember(TeamMember selectedTeamMember) {
			this.selectedTeamMember = selectedTeamMember;
			System.out.println("team member object " + selectedTeamMember.getFirstName() + " passed");
		}

		public void clearTeamMember() {
			firstName = lastName = login = password = null;  //if not cleared, data would appear every next time when the new user window is open, but there should be better way to do that
			System.out.println("Team member cleared");
		}
		
		
		public void setId(int id) {		
			this.id = id;
			System.out.println("selected team member id is set to " + id + " with name " + firstName);	
		}
		
		public int getId() {
			return id;
		}
		
		public void setTeamMemberList(List<TeamMember> teamMemberList) {
			this.teamMemberList = teamMemberList;
		}
		
		public List<TeamMember> getTeamMemberList(){
			return teamMemberList;
		}
		

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getLogin() {
			return login;
		}

		public void setLogin(String login) {
			this.login = login;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public TeamMember getSelectedTeamMember() {
			return selectedTeamMember;
		}



}
