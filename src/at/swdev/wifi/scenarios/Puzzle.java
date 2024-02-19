package at.swdev.wifi.scenarios;

public class Puzzle implements Scenario{
    private String question;
    private String answer;

    public Puzzle (String question, String answer) {
        System.out.println("This comes from the puzzles");
    }

    @Override
    public void execute (Character character) {
        System.out.println("This comes from the Puzzle scenario");
    }


}
