package designPatterns.strategy.adventureGame.character;
import designPatterns.strategy.adventureGame.weapon.*;

/**
 * Lab 1
 *
 * @author scz
 */
public abstract class Character {

    private WeaponBehavior weapon = null;

    public void fight() {
        if (this.weapon == null) {
            System.out.println("no weapon for this caracter");
        } else {
            this.weapon.useWeapon();
        }
    }

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }
}
