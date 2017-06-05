package dependenceInversion.output.news;

import dependenceInversion.output.IOutputGenerator;

public class ProgramANew {
	private IOutputGenerator generator;

	public ProgramANew(IOutputGenerator generator) {
		this.generator = generator;
	}
	
	
}
