package at.swdev.wifi.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import at.swdev.wifi.characters.Character;
import at.swdev.wifi.scenarios.Scenario;


public class GameEngine {
    private Character player;
    private List<Scenario> scenarios = new ArrayList<>();
    private int currentScenarioIndex = 0;

    public GameEngine() {
        //Initialize the game
    }

    public void startGame() {

        // Game initialization and loop
        System.out.println("Welcome to the Adventure Game!");
        System.out.println("Your journey begins now.");

        boolean gameRunning = true;
        int currentScenarioIndex = 0;

        while (gameRunning && currentScenarioIndex < scenarios.size()) {
            Scenario currentScenario = scenarios.get(currentScenarioIndex);
            currentScenario.execute(player);

            // Check player status (health, win/lose conditions, etc.)
            if (player.getHealth() <= 0) {
                System.out.println("You lost the game");
                gameRunning = false;
            }

            // Allow the player to make choices that affect the game flow here
            System.out.println("Do you wish to continue? (yes/no)");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if ("no".equalsIgnoreCase(input)) {
                System.out.println("You quit the game");
                gameRunning = false;
            }
        }


        currentScenarioIndex++; // Move to the next scenario
        // Check for the end of the game
        if (currentScenarioIndex >= scenarios.size()) {
            System.out.println("Congratulations! You won the game!");
        }
    }

}
