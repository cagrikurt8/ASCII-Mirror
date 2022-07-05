package asciimirror;

import java.util.Scanner;

public class Main {
    private final AnimalStorage animals;

    public Main() {
        animals = new AnimalStorage();
    }

    void printAnimal() {
        System.out.println(animals.getAnimal());
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printAnimal();
    }
}