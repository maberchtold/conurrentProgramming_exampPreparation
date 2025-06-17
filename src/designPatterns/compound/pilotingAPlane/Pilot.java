package designPatterns.compound.pilotingAPlane;

public class Pilot {
	private boolean isCopilot;
	
	public Pilot(boolean isCopilot)
	{
		this.isCopilot = isCopilot;
	}

	public boolean isCopilot() {
		return isCopilot;
	}
}
