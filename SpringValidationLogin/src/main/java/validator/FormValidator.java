package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import spring.model.Form;

public class FormValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Form.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {
		Form form = (Form) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
				"Please type your name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail",
				"Mail type invalid");
	}

}
