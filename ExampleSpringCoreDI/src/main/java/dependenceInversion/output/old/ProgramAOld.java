package dependenceInversion.output.old;

import spring.SpringCore.impl.ICalculator;
import spring.SpringCore.impl.IOutputGenerator;
import dependenceInversion.output.JsonOutputGenerator;

public class ProgramAOld implements ICalculator {

	/*
	 * IOutputGenerator nếu đặt phương thức này bên trong khi cần thay đổi cách
	 * thức xử lý ta phải sửa đổi đoạn code cần thay thế
	 */
	private IOutputGenerator generator;

	public ProgramAOld() {
		/*
		 * hard code
		 */
		generator = new JsonOutputGenerator();
	}

	@Override
	public void calculate() {
		/*
		 * tính toán .......
		 */
		generator.generateOutput();
	}
}
