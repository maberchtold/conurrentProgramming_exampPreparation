package designPatterns.compound.valaisGame;

import designPatterns.compound.valaisGame.Context.ValaisGame;
import designPatterns.compound.valaisGame.Invoker.MenuInvoker;
import designPatterns.compound.valaisGame.Strategy.StrategyNax;
import designPatterns.compound.valaisGame.Strategy.StrategyNendaz;
import designPatterns.compound.valaisGame.Strategy.StrategyZermatt;

public class Main {
    public static void main(String[] args) {
        ValaisGame myGame = new ValaisGame();
        myGame.setGameStragegy(new StrategyNax());

        MenuInvoker menuInvoker = new MenuInvoker(myGame);
        menuInvoker.callItem(2);
        menuInvoker.callItem(1);
        menuInvoker.callItem(0);

        myGame.setGameStragegy(new StrategyNendaz());
        menuInvoker.callItem(2);
        menuInvoker.callItem(1);
        menuInvoker.callItem(0);

        myGame.setGameStragegy(new StrategyZermatt());
        menuInvoker.callItem(2);
        menuInvoker.callItem(1);
        menuInvoker.callItem(0);
    }
}