package designPatterns.strategy.adventureGame.character;

import designPatterns.strategy.adventureGame.weapon.*;

/**
 * Lab 1
 * @author scz
 */
public class Troll extends Character {
    
    public Troll() {
        System.out.println("[character.Troll]");
        this.setWeapon(new AxeBehavior());
    }
}
