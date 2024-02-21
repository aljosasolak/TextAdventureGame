package at.swdev.wifi.scenarios;

import at.swdev.wifi.characters.Character;

public interface Scenario {
    String hint = "<for help press: h>";
    void execute (Character character);
}
