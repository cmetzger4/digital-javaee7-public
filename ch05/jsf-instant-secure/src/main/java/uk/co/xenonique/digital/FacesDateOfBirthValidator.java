package uk.co.xenonique.digital;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The type FacesDateOfBirthValidator
 *
 * @author Peter Pilgrim
 */
@FacesValidator("dateOfBirthValidator")
public class FacesDateOfBirthValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value)
    throws ValidatorException {
        UIInput dayComp   = (UIInput)component.getAttributes().get("dob_dotm");
        UIInput monthComp = (UIInput)component.getAttributes().get("dob_moty");
        UIInput yearComp  = (UIInput)component.getAttributes().get("dob_year");

        List<FacesMessage> errors = new ArrayList<>();
        int day = parsePositiveInteger(dayComp.getSubmittedValue());
        if ( day < 1 || day > 31 ) {
            errors.add(new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "DOB day must be in the range of 1 to 31 ", null ));
        }
        int month = parsePositiveInteger(monthComp.getSubmittedValue());
        if ( month < 1 || month > 12 ) {
            errors.add(new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "DOB month must be in the range of 1 to 12 ", null));
        }

        Calendar cal = Calendar.getInstance();

        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -18);
        Date eighteenBirthday = cal.getTime();

        cal.setTime(new Date());
        cal.add(Calendar.YEAR, -100);
        Date hundredthBirthday = cal.getTime();

        int year = parsePositiveInteger(yearComp.getSubmittedValue());
        cal.set(year,month,day);
        Date targetDate = cal.getTime();
        if (targetDate.after(eighteenBirthday) ) {
            errors.add(new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "DOB year: you must be 18 years old.", null));
        }
        if ( targetDate.before(hundredthBirthday)) {
            errors.add(new FacesMessage(
                FacesMessage.SEVERITY_ERROR,
                "DOB year: you must be younger than 100 years old.", null ));
        }
        if ( !errors.isEmpty()) {
            throw new ValidatorException(errors);
        }
    }

    public int parsePositiveInteger( Object value ) {
        if ( value == null ) return -1;
        try {
            return Integer.parseInt( value.toString().trim());
        }
        catch (NumberFormatException nfe) {
            return -1;
        }
    }
}
