package at.swdev.wifi.scenarios;

import at.swdev.wifi.characters.Character;
import java.util.Scanner;

public class Battle implements Scenario {

    //Attribute
    private int enemyHealth;
    private String instructionMessage = """
            In the midst of an enchanted forest, you find yourself standing at a crossroad,
            where the air is thick with magic and the whispers of ancient spirits.
            Two paths diverge before you:
            to the left, a winding trail disappears into the depths of an enchanted grove.
            To the right, a path leads toward the towering spires of a forgotten citadel.
            With a heart filled with wonder and fear, you must choose your path.
            <type l for left or r for right>""";

    private String wentLeft = """
            You bravely ventured left, entering the enchanted grove where mystical tree spirits dwell.
            To appease them, you must either hide and wait for their slumber,
            spin them a whimsical tale, or dance in harmony to forge a magical bond.
            <press w to wait, t to tell a tale or d to dance>""";

    private String wentRight = """
            You opt for the route to the ancient citadel,
            where an undead soldier threatens your safety.
            You can hide, evade, or fight back.
            Your decision will determine your fate.
            <press h for hide, e for evade or f for fight>""";

    private String indeciseve = """
            It seems you pressed neither l nor r.
            While being indecisive,
            the earth trembled and the demon of the enchanted land appeared before you.
            You can evade or fight back.
            Your decision will determine your fate.
            <press e for evade or f for fight>""";

    private String itWorksMessage = "Your strategy works, but with a price!";


    //Methoden
    private void setEnemyHealth(int enemyHealth) {
        if (enemyHealth < 0) {
            this.enemyHealth = 0;
        } else {
            this.enemyHealth = enemyHealth;
        }
    }

    private int getEnemyHealth() {
        return enemyHealth;
    }

    //Der Benutzer entscheidet, ob er links oder rechts geht
    @Override
    public void execute(Character character) {
        System.out.println(instructionMessage);
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine().toLowerCase();

        if (choice.equals("l")) {
            setEnemyHealth(50);
            System.out.println(wentLeft);
        } else if (choice.equals("r")) {
            setEnemyHealth(80);
            System.out.println(wentRight);
        } else {
            setEnemyHealth(90);
            System.out.println(indeciseve);
        }


        String userAnswer;
        //Der Benutzer geht links
        while (enemyHealth > 0 && choice.equals("l")) {
            userAnswer = input.nextLine().toLowerCase();
            if (userAnswer.equals("w")) {
                setEnemyHealth(enemyHealth - 7);
                character.setHealth(character.getHealth() - 1);
                System.out.println(itWorksMessage);
                System.out.printf("Your health: %d\n", character.getHealth());
                System.out.printf("Enemy's health %d\n", getEnemyHealth());
            } else if (userAnswer.equals("t")) {
                setEnemyHealth(enemyHealth - 15);
                character.setHealth(character.getHealth() - 2);
                System.out.println(itWorksMessage);
                System.out.printf("Your health: %d\n", character.getHealth());
                System.out.printf("Enemy's health %d\n", getEnemyHealth());
            } else if (userAnswer.equals("d")) {
                setEnemyHealth(enemyHealth - 22);
                character.setHealth(character.getHealth() - 4);
                System.out.println(itWorksMessage);
                System.out.printf("Your health: %d\n", character.getHealth());
                System.out.printf("Enemy's health %d\n", getEnemyHealth());
            } else {
                System.out.println("<press w to wait, t to tell a tale or d to dance>");
            }
        }


        //Der Benutzer geht rechts
        while (enemyHealth > 0 && choice.equals("r")) {
            userAnswer = input.nextLine().toLowerCase();
            if (userAnswer.equals("h")) {
                setEnemyHealth(enemyHealth - 7);
                character.setHealth(character.getHealth() - 1);
                System.out.println(itWorksMessage);
                System.out.printf("Your health: %d\n", character.getHealth());
                System.out.printf("Enemy's health %d\n", getEnemyHealth());
            } else if (userAnswer.equals("e")) {
                setEnemyHealth(enemyHealth - 17);
                character.setHealth(character.getHealth() - 2);
                System.out.println(itWorksMessage);
                System.out.printf("Your health: %d\n", character.getHealth());
                System.out.printf("Enemy's health %d\n", getEnemyHealth());
            } else if (userAnswer.equals("f")) {
                setEnemyHealth(enemyHealth - 26);
                character.setHealth(character.getHealth() - 5);
                System.out.println(itWorksMessage);
                System.out.printf("Your health: %d\n", character.getHealth());
                System.out.printf("Enemy's health %d\n", getEnemyHealth());
            } else {
                System.out.println("<press h for hide, e for evade or f for fight>");
            }

        }

        //Der Benutzer ist unentschlossen und gab falsche Eingabe ein (ist die Bedingung richtig formuliert?)
        while (enemyHealth > 0) {
            userAnswer = input.nextLine().toLowerCase();
            if (userAnswer.equals("e")) {
                setEnemyHealth(enemyHealth - 17);
                character.setHealth(character.getHealth() - 3);
                System.out.println(itWorksMessage);
                System.out.printf("Your health: %d\n", character.getHealth());
                System.out.printf("Enemy's health %d\n", getEnemyHealth());
            } else if (userAnswer.equals("f")) {
                setEnemyHealth(enemyHealth - 25);
                character.setHealth(character.getHealth() - 6);
                System.out.println(itWorksMessage);
                System.out.printf("Your health: %d\n", character.getHealth());
                System.out.printf("Enemy's health %d\n", getEnemyHealth());
            } else {
                System.out.println("<press e for evade or f for fight>");
            }

        }
        //input.close(); this should probably be deleted if the third scenario comes
        System.out.printf("Congratulations, %s! \nYou have emerged triumphant in this challenge!\n", character.getName());
    }
}
