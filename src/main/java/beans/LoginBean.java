package beans;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import database.TeamMemberService;
import model.Role;

@Named
@RequestScoped
public class LoginBean{
	

	private String userName;
	private String password;
	
	public String login() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
		try {
			request.login(getUserName(), getPassword());
			System.out.println("Trying to login "+ getUserName() + " " + getPassword());
		}catch(ServletException e){
			System.out.println(e);
			context.addMessage(null, new FacesMessage("Login failed " + e));
			return "Login.xhtml";
		}
		
		return "resources/views/Tasks.xhtml?faces-redirect=true";
	}
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
		
		try{
			request.logout();
			System.out.println("Successful logout");
		}catch(ServletException e){
			context.addMessage(null, new FacesMessage("Logout failed"));
		}
		
		return "/Login.xhtml?faces-redirect=true";
		
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
