package model;

import entities.Batch;
import entities.Student;

public class AddBatchModel {
	private Batch batch;
	private Student student;

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}