package by.borovik.cofeeapp.validator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.component.UIComponent;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import javax.faces.validator.Validator;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

@FacesValidator("timeValidator")
public class TimeValidator implements Validator{

    private static final String TIME_PATTERN = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]$";
    private Pattern pattern;
    public TimeValidator() {  pattern = Pattern.compile(TIME_PATTERN); }
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Matcher matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = new FacesMessage("Time validation failed.Invalid Time format.");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }
}