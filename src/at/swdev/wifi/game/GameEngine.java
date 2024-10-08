package at.swdev.wifi.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import at.swdev.wifi.characters.Character;
import at.swdev.wifi.scenarios.Battle;
import at.swdev.wifi.scenarios.FinalTask;
import at.swdev.wifi.scenarios.Puzzle;
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
        System.out.println("What is your name, brave traveler? Let it be known throughout our realm: ");
        Scanner input = new Scanner(System.in);

        Character player = new Character(input.nextLine());
        Puzzle puzzle = new Puzzle();
        Battle battle = new Battle();
        FinalTask finalTask = new FinalTask();

        scenarios.add(puzzle);
        scenarios.add(battle);
        scenarios.add(finalTask);

        boolean gameRunning = true;
        int currentScenarioIndex = 0;

        while (gameRunning && currentScenarioIndex < scenarios.size()) {
            Scenario currentScenario = scenarios.get(currentScenarioIndex);
            currentScenario.execute(player);


            // Check player status (health, win/lose conditions, etc.)
            if (player.getHealth() <= 0 || player.getStrength() <= 0) {
                System.out.println("Game over");
                //this did not work gameRunning = false; why?
                break;
            }

            currentScenarioIndex++;
            if (currentScenarioIndex >= scenarios.size()) {
                // Check for the end of the game
                System.out.println("Congratulations! You won the game!");
                break;
            }

            // Allow the player to make choices that affect the game flow here
            System.out.println("Do you wish to continue? (yes/no)");
            if ("no".equalsIgnoreCase(input.nextLine())) {
                System.out.println("You quit the game.");
                gameRunning = false;
            }

        }
        input.close();
    }
}