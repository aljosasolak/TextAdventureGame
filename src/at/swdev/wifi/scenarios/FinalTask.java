package at.swdev.wifi.scenarios;

import at.swdev.wifi.characters.Character;

import java.util.Scanner;

public class FinalTask implements Scenario {

    private String finalTaskMessage = """       
            In battles fierce, you conquered, set yourself free,
            Towards the source of magic, where wisdom be.
            To end the quest, your first answer must the last one be,
            Choose wisely, wrong answers, they weaken thee.
            <type your first answer>""";

    private String taskNotPassedMessage = """
            Your first answer was '%s', brave traveler.
            This time you didn't reach the source of magic and wisdom,
            but fear not and try again! 😊
            """;

    @Override
    public void execute(Character player) {

        System.out.println(finalTaskMessage);
        Scanner input = new Scanner(System.in);

        while (player.getHealth() > 0 && player.getStrength() > 0) {

            if (player.getName().equalsIgnoreCase(input.nextLine())) {
                System.out.println("That is correct!");
                System.out.println("You proved to be the true master of wisdom and magic!");
                break;
            } else {
                player.setStrength(player.getStrength() - 17);
                player.setHealth(player.getHealth() - 15);
                System.out.println("The wrong answer has weakened you!");
                System.out.printf("Your strength: %d\n", player.getStrength());
                System.out.printf("Your health: %d\n", player.getHealth());
                if (player.getStrength() > 17 && player.getHealth() > 15) {
                    System.out.println("Try your luck again: ");
                } else if (0 < player.getStrength() & player.getStrength() <= 17) {
                    System.out.println("Your name is your clue,\nfor it holds the key to the magic pure and true");
                    System.out.println("Try your luck one last time: ");
                } else if (0 < player.getHealth() & player.getHealth() <= 15) {
                    System.out.printf("Your health: %d\n", player.getHealth());
                    System.out.println("Your name is your clue,\nfor it holds the key to the magic pure and true");
                    System.out.println("Try your luck one last time: ");
                } else {
                    System.out.printf(taskNotPassedMessage, player.getName());
                }
            }
        }
    }
}
