package dependenceInversion.output;

public class ClassA {

	/*
	 * IOutputGenerator nếu đặt phương thức này bên trong khi cần thay đổi cách
	 * thức xử lý ta phải sửa đổi đoạn code cần thay thế
	 */
	private IOutputGenerator generator;

	public ClassA(IOutputGenerator generator) {
		super();
		this.generator = generator;
	}

	public void calculator() {
		/*
		 * tính toán .......
		 */
		generator.generateOutput();
	}
}
