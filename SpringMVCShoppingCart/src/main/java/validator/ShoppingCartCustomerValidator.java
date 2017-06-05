package validator;

import model.Customer;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ShoppingCartCustomerValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return Customer.class.equals(arg0);
	}

	@Autowired
	@Qualifier("emailValidator")
	private EmailValidator emailValidator;

	public void validate(Object target, Errors errors) {
		Customer orders = (Customer) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerName",
				"NotEmpty.ordersForm.name");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerEmail",
				"NotEmpty.ordersForm.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerPhone",
				"NotEmpty.ordersForm.phone");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "customerAddress",
				"NotEmpty.ordersForm.address");

		if (!StringUtils.isNumeric(orders.getCustomerPhone())) {
			errors.reject("customerPhone", "MustPhoneNumber.ordersForm.phone");
		}

		if (!emailValidator.isValidate(orders.getCustomerEmail())) {
			errors.rejectValue("customerEmail", "Invalid.ordersForm.email");
		}
	}
}
