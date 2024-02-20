package at.swdev.wifi.scenarios;

import at.swdev.wifi.characters.Character;


import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Puzzle implements Scenario {

    //Message at the gate
    private String taskMessage = """
            Welcome to the world of unseen,
            Where wonders and magic convene.
            Before my gates, you must be keen,
            Answer the question, from our Sphinx serene.\n""";


    //Riddles and answers
    private String riddle1 = """
            I speak without a mouth, and hear without ears,
            I have no body, but I come alive with your fears.
            What am I?""";
    private String answer1 = "Echo";

    private String riddle2 = """
            I’m not alive, but I grow;
            I don’t have lungs, but I need air;
            I don’t have a mouth, but water kills me.
            What am I?""";
    private String answer2 = "Fire";

    private String riddle3 = """
            The more you take, the more you leave behind.
            What am I?""";
    private String answer3 = "Footsteps";


    List<String> riddles = List.of(riddle1, riddle2, riddle3);
    List<String> answers = List.of(answer1, answer2, answer3);


    Scanner input = new Scanner(System.in);
    Random random = new Random();
    int index = random.nextInt(3);

    @Override
    public void execute(Character character) {
        System.out.println(taskMessage);
        System.out.println(riddles.get(index));
        System.out.println(hint);
        boolean isAnswered = false;

        while (!(isAnswered)) {
            String userAnswer = input.nextLine();
            if (userAnswer.equalsIgnoreCase(answers.get(index))) {
                System.out.printf("""
                        Congratulations, %s, I've seen,
                        You merit to enter the world of unseen!""", character.getName());
                input.close();
                isAnswered = true;
            } else if (userAnswer.equalsIgnoreCase("h")) {
                System.out.printf("""
                        In the riddle of the sphinx, you must not feign.
                        The answer is %s, type your answer again.\n""", answers.get(index));
                input.nextLine();
            } else if (!(userAnswer.equalsIgnoreCase(answers.get(index)))) {
                System.out.printf("""
                        In the sphinx's lair, where wisdom soars,
                        %s was the answer, alas, not yours,
                        Denied is entry through these ancient doors.
                        Type your answer again, with thought that explores.\n""", answers.get(index));
                input.nextLine();
            }
        }
    }


}
