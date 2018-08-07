package validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("notEmptyValidator")
public class BeanValidator implements Validator<Object> {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

		System.out.println("Validation method invoked for value " + value.toString() +" for component " + component.getId());
	    if (value.toString().isEmpty()){
	    	System.out.println("value is empty");
	        FacesMessage msg =
	                new FacesMessage("Pole " + component.getId() + " jest obowi¹zkowe! ");
	        msg.setSeverity(FacesMessage.SEVERITY_ERROR);
	        context.validationFailed();
	        System.out.println("Validation failed flag is set to " + context.isValidationFailed());	     
	        throw new ValidatorException(msg);

	    }
		
	}

}
