package dependenceInversion.output;

public class ClassB {
	
	private IOutputGenerator outputGenerator;

	public ClassB(IOutputGenerator outputGenerator) {
		super();
		this.outputGenerator = outputGenerator;
	}
	
	public void calculator()
	{
		/*
		 * tính toán....
		 */
		outputGenerator.generateOutput();
	}
	
}
