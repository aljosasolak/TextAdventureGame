package at.swdev.wifi.characters;


public class Character {

    //Attribute des Spielers
    private String name;
    private int health;
    private int strength;

    //Konstruktor
    public Character(String name) {
        this.name = name;
        setHealth(75);
        setStrength(50);
    }


    //Getters und Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        if (strength < 0) {
            this.strength = 0;
        } else {
            this.strength = strength;
        }
    }
}
