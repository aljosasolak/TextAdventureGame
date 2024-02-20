package at.swdev.wifi.scenarios;

import at.swdev.wifi.characters.Character;
import java.util.Scanner;

public class Battle implements Scenario {

    //Attribute
    private int enemyStrength;
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
    private void setEnemyStrength(int enemyStrength) {
        if (enemyStrength < 0) {
            this.enemyStrength = 0;
        } else {
            this.enemyStrength = enemyStrength;
        }
    }

    private int getEnemyStrength() {
        return enemyStrength;
    }

    //Der Benutzer entscheidet, ob er links oder rechts geht
    @Override
    public void execute(Character character) {
        System.out.println(instructionMessage);
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine().toLowerCase();


        if (choice.equals("l")) {
            setEnemyStrength(50);
            System.out.println(wentLeft);
        } else if (choice.equals("r")) {
            setEnemyStrength(80);
            System.out.println(wentRight);
        } else {
            setEnemyStrength(90);
            System.out.println(indeciseve);
        }


        String userAnswer;
        //Der Benutzer geht links
        while (enemyStrength > 0 && choice.equals("l")) {
            userAnswer = input.nextLine().toLowerCase();
            if (userAnswer.equals("w")) {
                setEnemyStrength(enemyStrength - 7);
                character.setStrength(character.getStrength() - 1);
                System.out.println(itWorksMessage);
                System.out.printf("Your strength: %d\n", character.getStrength());
                System.out.printf("Enemy's strength %d\n", getEnemyStrength());
            } else if (userAnswer.equals("t")) {
                setEnemyStrength(enemyStrength - 15);
                character.setStrength(character.getStrength() - 2);
                System.out.println(itWorksMessage);
                System.out.printf("Your strength: %d\n", character.getStrength());
                System.out.printf("Enemy's strength %d\n", getEnemyStrength());
            } else if (userAnswer.equals("d")) {
                setEnemyStrength(enemyStrength - 22);
                character.setStrength(character.getStrength() - 4);
                System.out.println(itWorksMessage);
                System.out.printf("Your strength: %d\n", character.getStrength());
                System.out.printf("Enemy's strength %d\n", getEnemyStrength());
            } else {
                System.out.println("<press w to wait, t to tell a tale or d to dance>");
            }
        }


        //Der Benutzer geht rechts
        while (enemyStrength > 0 && choice.equals("r")) {
            userAnswer = input.nextLine().toLowerCase();
            if (userAnswer.equals("h")) {
                setEnemyStrength(enemyStrength - 7);
                character.setStrength(character.getStrength() - 1);
                System.out.println(itWorksMessage);
                System.out.printf("Your strength: %d\n", character.getStrength());
                System.out.printf("Enemy's strength %d\n", getEnemyStrength());
            } else if (userAnswer.equals("e")) {
                setEnemyStrength(enemyStrength - 17);
                character.setStrength(character.getStrength() - 2);
                System.out.println(itWorksMessage);
                System.out.printf("Your strength: %d\n", character.getStrength());
                System.out.printf("Enemy's strength %d\n", getEnemyStrength());
            } else if (userAnswer.equals("f")) {
                setEnemyStrength(enemyStrength - 26);
                character.setStrength(character.getStrength() - 5);
                System.out.println(itWorksMessage);
                System.out.printf("Your strength: %d\n", character.getStrength());
                System.out.printf("Enemy's strength %d\n", getEnemyStrength());
            } else {
                System.out.println("<press h for hide, e for evade or f for fight>");
            }

        }

        //Der Benutzer ist unentschlossen und gab falsche Eingabe ein (ist die Bedingung richtig formuliert?)
        while (enemyStrength > 0) {
            userAnswer = input.nextLine().toLowerCase();
            if (userAnswer.equals("e")) {
                setEnemyStrength(enemyStrength - 17);
                character.setStrength(character.getStrength() - 3);
                System.out.println(itWorksMessage);
                System.out.printf("Your strength: %d\n", character.getStrength());
                System.out.printf("Enemy's strength %d\n", getEnemyStrength());
            } else if (userAnswer.equals("f")) {
                setEnemyStrength(enemyStrength - 25);
                character.setStrength(character.getStrength() - 6);
                System.out.println(itWorksMessage);
                System.out.printf("Your strength: %d\n", character.getStrength());
                System.out.printf("Enemy's strength %d\n", getEnemyStrength());
            } else {
                System.out.println("<press e for evade or f for fight>");
            }

        }

        input.close();
        System.out.printf("Congratulations, %s! \nYou have emerged triumphant in this challenge!", character.getName());
    }
}
