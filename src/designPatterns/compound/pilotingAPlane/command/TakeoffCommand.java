package designPatterns.compound.pilotingAPlane.command;


import designPatterns.compound.pilotingAPlane.Plane;

public class TakeoffCommand implements Command {
	private Plane plane;

	public TakeoffCommand(Plane plane) {
		super();
		this.plane = plane;
	}

	@Override
	public void execute() {
		plane.takeoff();
	}

}
