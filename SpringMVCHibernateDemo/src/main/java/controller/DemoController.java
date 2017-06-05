package controller;

import model.AddBatchModel;
import model.SchoolModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entities.Batch;
import entities.Student;
import business.SchoolManager;


public class DemoController {
	@Autowired
	private SchoolManager schoolManager;

	@RequestMapping(value = "/viewBatch")
	public ModelAndView viewBatch(SchoolModel schoolModel) {
		ModelAndView mav = new ModelAndView("viewBatch", "model", schoolModel);
		schoolManager.getBatchInfo(schoolModel);
		return mav;
	}

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

	public SchoolManager getSchoolManager() {
		return schoolManager;
	}

	public void setSchoolManager(SchoolManager schoolManager) {
		this.schoolManager = schoolManager;
	}
}