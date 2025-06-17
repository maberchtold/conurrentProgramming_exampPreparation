package designPatterns.compound.pilotingAPlane.subject;

import designPatterns.compound.pilotingAPlane.Pilot;

public interface Controller {
	void takeOff(Pilot pilot);
	void landing(Pilot pilot);
	void startAutoPilot(Pilot pilot);
}
