package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student", catalog = "springhibernatedemodb")
public class Student implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String studentId;
	private Batch batch;
	private String studentName;

	public Student() {
	}

	public Student(String studentId) {
		this.studentId = studentId;
	}

	public Student(String studentId, Batch batch, String studentName) {
		this.studentId = studentId;
		this.batch = batch;
		this.studentName = studentName;
	}

	@Id
	@Column(name = "STUDENT_ID", unique = true, nullable = false, length = 6)
	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BATCH_ID")
	public Batch getBatch() {
		return this.batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}

	@Column(name = "STUDENT_NAME", length = 20)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
