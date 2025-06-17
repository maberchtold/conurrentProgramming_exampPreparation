package designPatterns.compound.valaisGame.Invoker;

import designPatterns.compound.valaisGame.Command.CmdEnd;
import designPatterns.compound.valaisGame.Command.CmdMove;
import designPatterns.compound.valaisGame.Command.CmdSetWinner;
import designPatterns.compound.valaisGame.Command.Command;
import designPatterns.compound.valaisGame.Context.ValaisGame;

import java.util.ArrayList;
import java.util.List;

public class MenuInvoker {
    public List<Command> commands = new ArrayList<Command>();

    public MenuInvoker(ValaisGame valaisGame) {
        commands.add(new CmdEnd(valaisGame));
        commands.add(new CmdSetWinner(valaisGame));
        commands.add(new CmdMove(valaisGame));
    }

    public void callItem(int index) {
        commands.get(index).execute();
    }
}

