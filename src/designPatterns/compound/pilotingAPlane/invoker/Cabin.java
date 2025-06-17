package designPatterns.compound.pilotingAPlane.invoker;


import designPatterns.compound.pilotingAPlane.command.Command;

public class Cabin {
	private Command[] commands = new Command[3];

	public void pushKey(int key) {
		commands[key].execute();
	}

	public void setCommand(int key, Command command){
		commands[key] = command;
	}
}
