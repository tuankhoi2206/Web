package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.model.Form;

@Controller
public class FormController {

	// @Autowired
	// @Qualifier("validatorForm")
	// private Validator validatorForm;
	//
	// @InitBinder
	// private void initBinder(WebDataBinder binder) {
	// binder.setValidator(validatorForm);
	// }

	@RequestMapping(value = "/")
	public String defaultView(Model model) {
		model.addAttribute("form", new Form());
		return "formPage";
	}

	@RequestMapping(value = "formPage", method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("form") @Validated Form form,
			Model model, BindingResult result) {
		model.addAttribute("form", form);
		return result.hasErrors() ? "formPage" : "login";
	}
}
