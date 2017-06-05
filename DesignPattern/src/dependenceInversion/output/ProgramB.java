package dependenceInversion.output;

public class ProgramB {
	public static void main(String[] args) {
		/*
		 * Điều gì xảy ra nếu đoạn code này nằm ở nhiều nơi Sẽ dẫn tới
		 * việc chỉnh sửa ở nhiều nơi
		 */
		IOutputGenerator generator = new CsvOutputGenerator();

		ClassB b = new ClassB(new JsonOutputGenerator());
		b.calculator();

	}
}
