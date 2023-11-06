package Lab5;

import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Cat2 firstCat = new Cat2("Tom", "grey", 5);
        Cat2 secondCat = new Cat2("Garfield", "orange", 8);

        firstCat.play();
        firstCat.feed();
        firstCat.sleep();

        firstCat.miau();

    }
}