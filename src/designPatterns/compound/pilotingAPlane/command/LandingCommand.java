package designPatterns.compound.pilotingAPlane.command;
import designPatterns.compound.pilotingAPlane.Plane;

public class LandingCommand implements Command {
	private Plane plane;

	public LandingCommand(Plane plane) {
		super();
		this.plane = plane;
	}

	@Override
	public void execute() {
		plane.landing();
	}

}
