package at.swdev.wifi;

import at.swdev.wifi.characters.Character;
import at.swdev.wifi.scenarios.Battle;
import at.swdev.wifi.scenarios.FinalTask;
import at.swdev.wifi.scenarios.Puzzle;

public class TEST {
    public static void main(String[] args) {

        Character player = new Character("Aljosa");
        System.out.println(player.getHealth());
        System.out.println(player.getStrength());
        FinalTask finalTask = new FinalTask();
        finalTask.execute(player);
    }

}
