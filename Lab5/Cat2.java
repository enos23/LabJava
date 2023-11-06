package Lab5;

public class Cat2 {
    private String name;
    private String color;
    private Integer age;
    private Integer energyLevel;
    private Integer hungerLevel;
    private Integer moodLevel;

    public Cat2() {

    }

    public Cat2(String name, String color, Integer age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.energyLevel = 3;
        this.hungerLevel = 3;
        this.moodLevel = 3;
    }

    public void play() {
        this.moodLevel++;
        this.energyLevel--;
        this.miau();
    }

    public void feed() {
        this.moodLevel++;
        this.hungerLevel--;
        this.miau();
    }

    public void sleep() {
        this.energyLevel++;
        this.hungerLevel++;
    }

    public void miau() {
        System.out.println("Meau");
    }

}
