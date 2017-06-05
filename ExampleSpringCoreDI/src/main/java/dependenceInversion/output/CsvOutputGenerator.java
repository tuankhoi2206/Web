package dependenceInversion.output;

import spring.SpringCore.impl.IOutputGenerator;

public class CsvOutputGenerator implements IOutputGenerator {

	@Override
	public void generateOutput() {
		System.out.println("Cvs output");
	}

}
