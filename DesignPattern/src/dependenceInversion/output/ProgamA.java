package dependenceInversion.output;

public class ProgamA {
	public static void main(String[] args) {
		/*
		 * Điều gì xảy ra nếu đoạn code này nằm ở những nhiều nơi Sẽ dẫn tới
		 * việc chỉnh sửa ở nhiều nơi
		 */
		IOutputGenerator generator = new CsvOutputGenerator();

		ClassA a = new ClassA(new CsvOutputGenerator());
		a.calculator();

	}
}
