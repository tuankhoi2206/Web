package dependenceInversion.output;

public class OutputHelper {
	private static IOutputGenerator outputGenerator;

	public OutputHelper() {
	}

	public static void generateOutput() {
		if (outputGenerator == null) {
			outputGenerator = new CsvOutputGenerator();
		}
		outputGenerator.generateOutput();
	}

}
