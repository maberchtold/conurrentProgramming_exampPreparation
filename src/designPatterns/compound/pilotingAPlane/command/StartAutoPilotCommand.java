package designPatterns.compound.pilotingAPlane.command;


import designPatterns.compound.pilotingAPlane.Plane;

public class StartAutoPilotCommand implements Command {
	private Plane plane;

	public StartAutoPilotCommand(Plane plane) {
		super();
		this.plane = plane;
	}

	@Override
	public void execute() {
		plane.startautopilot();
	}
}
