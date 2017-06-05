package dependenceInversion.output;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependenceInversion.output.news.ProgramANew;
import dependenceInversion.output.old.OutputHelper;
import dependenceInversion.output.old.ProgramAOld;
import spring.SpringCore.impl.IOutputGenerator;

public class TestMain {
	public static void main(String[] args) {

		/*
		 * Điều gì xảy ra nếu đoạn code này nằm ở những nhiều nơi Sẽ dẫn tới
		 * việc chỉnh sửa ở nhiều nơi
		 */
		// IOutputGenerator generator = new CsvOutputGenerator();
		//
		// OutputHelper.generateOutput();
		/*
		 * old
		 */
		// ProgramAOld programAOld = new ProgramAOld();
		// programAOld.calculate();

		/*
		 * Được dùng để load các thông tin từ file cấu hình nằm trong thư mục
		 * classpath thư mục src
		 */
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"bundle-context.xml");

		ProgramANew programANew = (ProgramANew) context.getBean("proANew");
		programANew.calculate();

		programANew.setNameProgram("KTest");
		System.out.println(programANew.getNameProgram());

		ProgramANew pB = (ProgramANew) context.getBean("proANew");
		System.out.println(pB.getNameProgram());
	}
}
