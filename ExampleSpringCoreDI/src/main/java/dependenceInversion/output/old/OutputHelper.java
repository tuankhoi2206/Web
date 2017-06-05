package dependenceInversion.output.old;

import dependenceInversion.output.CsvOutputGenerator;
import spring.SpringCore.impl.IOutputGenerator;

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
