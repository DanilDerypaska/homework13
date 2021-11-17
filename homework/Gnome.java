package homework;

import static homework.HealthState.DEAD;

public class Gnome extends Warrior implements Attackable, Defenceable{

    private int livePoints;


    public Gnome(int livePoints) {
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

        if (livePoints < 0) {
            healthState = DEAD;
        }

        changeHealthState(livePoints);
    }

    @Override
    public String toString() {
        return "Gnome{" +
                "healthState=" + healthState +
                ", livePoints=" + livePoints +
                ", defenceLevel=" + defenceLevel +
                ", forceLevel=" + forceLevel +
                '}';
    }
}
