package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import entity.Accounts;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		return Accounts.class.equals(clazz);
	}

	public void validate(Object target, Errors errors) {

		Accounts accounts = (Accounts) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
				"NotEmpty.Account.userName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
				"NotEmpty.Account.password");

		if (accounts.getUserName().length() < 8)
			errors.rejectValue("userName", "Short.Account.userName");

		if (accounts.getPassword().length() < 8)
			errors.rejectValue("password", "Short.Account.password");

		if (accounts.getUserName().equals(accounts.getPassword())) {
			errors.rejectValue("password", "EqualsUserName.Account.password");
		}
	}

}
