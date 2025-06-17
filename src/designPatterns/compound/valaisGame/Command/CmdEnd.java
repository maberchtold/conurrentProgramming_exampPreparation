package designPatterns.compound.valaisGame.Command;

import designPatterns.compound.valaisGame.Context.ValaisGame;

public class CmdEnd implements Command {
    private ValaisGame valaisGame;
    
    public CmdEnd(ValaisGame valaisGame) {
        this.valaisGame = valaisGame;
    }

    @Override
    public void execute() {
        valaisGame.end();
    }
}
