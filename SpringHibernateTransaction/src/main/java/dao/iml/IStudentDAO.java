package dao.iml;

import java.util.List;

import entity.Student;

public interface IStudentDAO {
	void save(Student student);

	List<Student> getStudents();
}
