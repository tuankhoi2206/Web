package khoivu.spring;

import khoivu.spring.model.Person;
import khoivu.spring.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonsController {

	@Autowired(required = true)
	@Qualifier(value = "personService")
	private PersonService personService;

	@RequestMapping("persons")
	public String personsView(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", personService.listPersons());
		return "persons";
	}

}
