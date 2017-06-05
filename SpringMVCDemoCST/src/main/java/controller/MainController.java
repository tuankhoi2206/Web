package controller;

import java.util.ArrayList;
import java.util.List;

import model.Student;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	/*
	 * 
	 */
	@RequestMapping(value = "/home")
	public ModelAndView showHome() {

		/*
		 * Gửi kèm model này đến DispatcherServlet để render trước khi trả về
		 * client
		 */
		Student student = new Student();
		student.setName("Khôi Vũ");

		List<String> books = new ArrayList<String>();
		books.add("Spring");
		books.add("Hibernate");
		books.add("JSTL");

		student.setBooks(books);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("student", student);

		return modelAndView;

	}

	/*
	 * Chỉ nhận những method post
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public ModelAndView showResult(ModelMap model,
			@ModelAttribute("student") Student student) {

		/*
		 * List<String> lstBook = student.getBooks(); for (String string :
		 * lstBook) { System.out.println(string); }
		 */

		return new ModelAndView("showResult", "students", student);
	}
}
