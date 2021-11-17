package homework;

import static homework.HealthState.*;

public class Solution {

    public static void main(String[] args) {

        Gnome gnomeOne = new Gnome(500);
        Gnome gnomeTwo = new Gnome(500);

        ElfArcher elfArcherOne = new ElfArcher(500);
        ElfArcher elfArcherTwo = new ElfArcher(500);

        Solution solution = new Solution();
        solution.initArmy(gnomeOne,gnomeTwo,elfArcherOne,elfArcherTwo);
        solution.print(gnomeOne, gnomeTwo, elfArcherOne, elfArcherTwo);

        Warrior[] armyGnome = {gnomeOne,gnomeTwo};
        Warrior[] armyElf = {elfArcherOne,elfArcherTwo};

        solution.battle(armyGnome,armyElf);

        solution.print(gnomeOne, gnomeTwo, elfArcherOne, elfArcherTwo);

    }

    private void print(Gnome gnomeOne, Gnome gnomeTwo, ElfArcher elfArcherOne, ElfArcher elfArcherTwo) {
        System.out.println(gnomeOne +"\n" + gnomeTwo);
        System.out.println(elfArcherOne +"\n" + elfArcherTwo);
    }

    private void battle(Warrior[] gnomes, Warrior[] elves) {
        for (int j = 0; j < 100; j++) {
            for (int i = 0; i < gnomes.length; i++) {
                Warrior warriorOne = gnomes[i];
                Warrior warriorTwo = elves[i];
                fight(warriorOne, warriorTwo);
                fight(warriorTwo, warriorOne);
            }
        }
    }

    private void fight(Warrior warriorOne, Warrior warriorTwo) {
        int attackLevel = 0;

        if(warriorOne.getHealthState() != DEAD && warriorOne instanceof Attackable) {
            Attackable one = (Attackable) warriorOne;
            attackLevel = one.attack();
        }
        if (warriorTwo.getHealthState() != DEAD && warriorTwo instanceof Defenceable) {
            Defenceable two = (Defenceable) warriorTwo;
            two.defence(attackLevel);
        }

    }

    private void initArmy(Warrior...warriors) {
        for (Warrior warrior: warriors           ) {
            warrior.intDefenceLevel();
            warrior.initForceLevel();
        }
    }
}
