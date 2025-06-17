package designPatterns.strategy.adventureGame.character;

import designPatterns.strategy.adventureGame.weapon.*;

/**
 * Lab 1
 * @author scz
 */
public class Knight extends Character {
    
    public Knight() {
        System.out.println("[character.Knight]");
        this.setWeapon(new SwordBehavior());
    }
}
