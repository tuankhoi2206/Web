package controller;

import java.util.List;

import model.AddBatchModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import business.SchoolManager;
import dao.BatchDAO;
import dao.StudentDAO;
import entities.Batch;
import entities.Student;

@Controller
public class MainController {

	@RequestMapping("/")
	public String showDefaultPage() {
		return "redirect:viewBatch";
	}

	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	private BatchDAO batchDAO;

	/*
	 * Phải set model
	 */
	@RequestMapping(value = "/viewBatch")
	public ModelAndView showViewBatch(@ModelAttribute("batch") Batch batch) {
		/*
		 * Nếu batch bị xóa hoặc đây chỉ là get
		 */
		List<Batch> batchs = batchDAO.getAllBatch();
		List<Student> students;
		if (batch.getBatchId() == null) {
			students = studentDAO.getStudentsByBatchId(batchs.get(0)
					.getBatchId());
		} else {
			students = studentDAO.getStudentsByBatchId(batch.getBatchId());
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("viewBatch");
		mv.addObject("batchs", batchs);
		mv.addObject("students", students);

		return mv;
	}

	@Autowired
	private SchoolManager schoolManager;

	@RequestMapping(value = "/addBatch")
	public ModelAndView addBatch(AddBatchModel addBatchModel) {
		ModelAndView mav = new ModelAndView("addBatch", "model", addBatchModel);
		Batch batch = addBatchModel.getBatch();
		if (batch == null) {
			addBatchModel.setBatch(new Batch());
			addBatchModel.setStudent(new Student());
		} else {
			Student student = addBatchModel.getStudent();
			schoolManager.addBatch(batch, student);
		}
		return mav;
	}

}
