package at.swdev.wifi.scenarios;

public class Battle implements Scenario {
    private int enemyStrength;

    public Battle(int enemyStrength) {
        //Implementation of battle logic
    }

    @Override
    public void execute(Character character) {
        System.out.println("This is from Battle scenario");
    }
}
