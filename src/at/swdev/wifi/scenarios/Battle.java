package at.swdev.wifi.scenarios;

import at.swdev.wifi.characters.Character;

public class Battle implements Scenario {

    //Attribute
    private int enemyStrength;

    //Konstruktor
    public Battle(int enemyStrength) {
        this.enemyStrength = enemyStrength;
    }

    //Methode
    @Override
    public void execute(Character character) {

    }

    public void hint() {

    };
}
