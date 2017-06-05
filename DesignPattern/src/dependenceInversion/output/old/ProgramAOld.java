package dependenceInversion.output.old;

import dependenceInversion.output.IOutputGenerator;
import dependenceInversion.output.JsonOutputGenerator;

public class ProgramAOld {

	/*
	 * IOutputGenerator nếu đặt phương thức này bên trong khi cần thay đổi cách
	 * thức xử lý ta phải sửa đổi đoạn code cần thay thế
	 */
	private IOutputGenerator generator;

	public ProgramAOld() {
		generator = new JsonOutputGenerator();
	}

	public void calculator() {
		/*
		 * tính toán .......
		 */
		generator.generateOutput();
	}
}
