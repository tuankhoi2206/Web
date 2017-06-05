package khoivu.spring;

import khoivu.spring.model.Person;
import khoivu.spring.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonController {

	@Autowired(required = true)
	@Qualifier(value = "personService")
	private PersonService personService;

	@RequestMapping(value = { "/", "person" })
	public String personView(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("lstPersons", personService.listPersons());
		return "person";
	}

	@RequestMapping(value = { "person/add" })
	public String personAdd(@ModelAttribute("person") Person person) {
		System.out.println("hfidhfkda fjhd");
		personService.addPerson(person);
		return "redirect:/person";
	}

	/*
	 * Redirect là chuyển hướng còn khi mình trả tai sao không thay đổi url
	 * Forward (chuyển tiếp) bẻ hướng đi, yêu cầu trang sang một trang khác.
	 */
	/*
	 * Node: view ở đây là đối tượng dc render nội dung sau đó chuyển nội dung
	 * về cho client
	 */
	@RequestMapping(value = { "person/edit/{id}" })
	public ModelAndView personEdit(@PathVariable("id") Integer id) {
		Person person = null;

		person = personService.findById(id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("person");
		mv.addObject("person", person);
		mv.addObject("lstPersons", personService.listPersons());
		return mv;
	}

	@RequestMapping(value = { "person/delete/{id}" })
	public String personDelete(@PathVariable("id") Integer id) {
		System.out.println("delete " + id);
		personService.removePerson(id);
		return "redirect:/person";
	}

	@RequestMapping(value = { "admin/controllpane" })
	public String controllPanePage() {
		return "controllpane";
	}

}
