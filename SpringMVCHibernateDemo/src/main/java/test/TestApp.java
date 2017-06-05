package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utils.HibernateUtils;
//import utils.HibernateUtils;
import entities.Student;

public class TestApp {
	public static void main(String[] args) {
		SessionFactory factory = HibernateUtils.getSessionFactory();

		Session session = factory.getCurrentSession();
		session.getTransaction().begin();

		try {

			// Student student = new Student("S005", new Batch(2, "Batch 3"),
			// "K Test");
			// Student student = (Student) session.get(Student.class, "S001");
			// student.setStudentName("Khoi Vu");
			// session.save(new Batch(3, "Batch 3"));

			for (int i = 0; i < 100000; i++) {
				Student student = new Student("S11" + i);
				session.save(student);

			}

			session.getTransaction().commit();

		} catch (Exception e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		/*
		 * Tạo transaction
		 */
		// Transaction tx = null;
		// try {
		// tx = HibernateUtils.getSession().beginTransaction();
		//
		// Student student = new Student("S005", new Batch(2, "Batch 3"),
		// "K Test");
		// HibernateUtils.getSession().save(student);
		// HibernateUtils.getSession().save(new Batch(2, "Ktest"));
		//
		// tx.commit();
		// } catch (HibernateException e) {
		// e.printStackTrace();
		// tx.rollback();
		// }

	}
}
