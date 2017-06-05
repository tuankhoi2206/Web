package dao;

import java.util.List;

import dao.iml.IStudentDAO;
import entity.Student;

public class StudentDAO extends AbstractHibernateDaoSupport implements
		IStudentDAO {

	public void save(Student student) {
		getHibernateTemplate().save(student);
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudents() {
		return (List<Student>) getHibernateTemplate().find("from Student");
	}

}
