package dependenceInversion.output.news;

import spring.SpringCore.impl.ICalculator;
import spring.SpringCore.impl.IOutputGenerator;

public class ProgramANew implements ICalculator {
	private IOutputGenerator generator;
	private String nameProgram;

	public String getNameProgram() {
		return nameProgram;
	}

	public void setNameProgram(String nameProgram) {
		this.nameProgram = nameProgram;
	}

	public IOutputGenerator getGenerator() {
		return generator;
	}

	public void setGenerator(IOutputGenerator generator) {
		this.generator = generator;
	}

	public ProgramANew(IOutputGenerator generator) {
		this.generator = generator;
	}

	public ProgramANew() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calculate() {
		/*
		 * tính toán .....
		 */
		generator.generateOutput();
	}

}
