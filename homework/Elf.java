package homework;

import static homework.HealthState.*;

public class Elf extends Warrior implements Attackable, Defenceable {

    private int livePoints;

    public Elf(int livePoints) {
        this.livePoints = livePoints;
    }

    @Override
    public int attack() {
        return forceLevel;
    }

    @Override
    public void defence(int attackPoints) {

        if(defenceLevel <= 0) {
            livePoints = livePoints - attackPoints;
        } else {
            defenceLevel = defenceLevel - attackPoints;
            if (defenceLevel < 0) {
                livePoints = livePoints + defenceLevel;
            }
        }

        changeHealthState(livePoints);
    }

    @Override
    public String toString() {
        return "Elf{" +
                "healthState=" + healthState +
                ", livePoints=" + livePoints +
                ", defenceLevel=" + defenceLevel +
                ", forceLevel=" + forceLevel +
                '}';
    }
}
