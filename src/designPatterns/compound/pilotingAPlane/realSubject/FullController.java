package designPatterns.compound.pilotingAPlane.realSubject;

import designPatterns.compound.pilotingAPlane.Pilot;
import designPatterns.compound.pilotingAPlane.Plane;
import designPatterns.compound.pilotingAPlane.command.LandingCommand;
import designPatterns.compound.pilotingAPlane.command.StartAutoPilotCommand;
import designPatterns.compound.pilotingAPlane.command.TakeoffCommand;
import designPatterns.compound.pilotingAPlane.invoker.Cabin;
import designPatterns.compound.pilotingAPlane.subject.Controller;


public class FullController implements Controller {

	public FullController(Plane plane) {
		this.cabin = new Cabin();
		cabin.setCommand(0, new TakeoffCommand(plane));
		cabin.setCommand(1, new LandingCommand(plane));
		cabin.setCommand(2, new StartAutoPilotCommand(plane));
	}

	@Override
	public void takeOff(Pilot pilot) {
		cabin.pushKey(0);
	}

	@Override
	public void landing(Pilot pilot) {
		cabin.pushKey(1);
	}

	@Override
	public void startAutoPilot(Pilot pilot) {
		cabin.pushKey(2);
	}

	private Cabin cabin;

}
