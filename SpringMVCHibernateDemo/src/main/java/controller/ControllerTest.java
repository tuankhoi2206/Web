package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.BatchDAO;
import dao.StudentDAO;

public class ControllerTest {

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private BatchDAO batchDAO;

	@RequestMapping(value = "showStudent")
	public ModelAndView showStudent(Model model) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("showStudent");

		modelAndView.addObject("lstBatch", batchDAO.getAllBatch());

		return modelAndView;
	}

	public BatchDAO getBatchDAO() {
		return batchDAO;
	}

	public void setBatchDAO(BatchDAO batchDAO) {
		this.batchDAO = batchDAO;
	}

	/*
	 * bị sai chỗ này chưa setter để inject
	 */
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
}
