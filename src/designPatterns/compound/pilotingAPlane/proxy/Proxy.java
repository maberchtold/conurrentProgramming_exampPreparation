package designPatterns.compound.pilotingAPlane.proxy;

import designPatterns.compound.pilotingAPlane.Pilot;
import designPatterns.compound.pilotingAPlane.Plane;
import designPatterns.compound.pilotingAPlane.realSubject.FullController;
import designPatterns.compound.pilotingAPlane.subject.Controller;


public class Proxy implements Controller {

	@Override
	public void takeOff(Pilot pilot) {
		if (!pilot.isCopilot()) {
			fullController.takeOff(pilot);
		}
	}

	@Override
	public void landing(Pilot pilot) {
		if (!pilot.isCopilot()) {
			fullController.landing(pilot);
		}
	}

	@Override
	public void startAutoPilot(Pilot pilot) {
		fullController.startAutoPilot(pilot);
	}

	private FullController fullController;
	
	public Proxy(Plane plane) {
		this.fullController = new FullController(plane);
	}

}
