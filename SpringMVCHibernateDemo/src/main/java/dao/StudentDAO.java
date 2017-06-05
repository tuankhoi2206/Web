package dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import entities.Student;

public class StudentDAO extends HibernateDaoSupport {

	@SuppressWarnings("unchecked")
	public List<Student> getListStudents() {
		String query = "select b from Student b";
		return (List<Student>) getHibernateTemplate().find(query);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentsByBatchId(int batchId) {
		/*
		 * Thao tác trên thuộc tính của đối tượng
		 */
		String query = "select s from Student s where s.batch.batchId=?";
		return (List<Student>) getHibernateTemplate().find(query, batchId);
	}

	public void addStudent(Student student) {
		getHibernateTemplate().setCheckWriteOperations(false);
		getHibernateTemplate().save(student);
		System.out.println("Student");
	}
}
