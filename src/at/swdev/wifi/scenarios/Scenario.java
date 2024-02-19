package at.swdev.wifi.scenarios;

import at.swdev.wifi.characters.Character;

public interface Scenario {

    void execute (Character character);

    void hint();
}
