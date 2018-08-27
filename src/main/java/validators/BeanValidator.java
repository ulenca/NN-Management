package validators;

import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import model.TeamMember;

public class BeanValidator {
	
	public static boolean isValueDuplicated(FacesContext fc, String componentVal, ArrayList<TeamMember> list){
		
		  	System.out.println("chceckForDuplicates method invoked");
			System.out.println("value passed " + componentVal);
			
			Boolean isDuplicate = false;
			for (TeamMember e: list) {
				if(e.getLogin().equals(componentVal)) {
					isDuplicate = true;
					break;
				}
			}
			
			if (isDuplicate == true) {
				FacesMessage msg = new FacesMessage("Login value is duplicate!");
				msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		        fc.validationFailed();
		        fc.addMessage(null, msg);
			}
			
		    System.out.println("Validation failed flag is set to " + fc.isValidationFailed() + ". Found duplicates: " + isDuplicate);	

		    return isDuplicate;

		}
	
	

}
