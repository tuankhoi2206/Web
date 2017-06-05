package dependenceInversion.output;

import spring.SpringCore.impl.IOutputGenerator;

public class JsonOutputGenerator implements IOutputGenerator {

	@Override
	public void generateOutput() {
		System.out.println("Json out put");
	}

}
