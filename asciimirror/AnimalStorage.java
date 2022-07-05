package asciimirror;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

class AnimalStorage {
    private Scanner scanner;

    public String getAnimal() {
        scanner = new Scanner(System.in);
        System.out.println("Input the file path:");
        File file = new File(scanner.nextLine());
        return getString(file);
    }

    private String getString(File fileName) {
        ArrayList<String> animalLines = new ArrayList<>();

        try {
            scanner = new Scanner(new FileReader(fileName));

            while(scanner.hasNext()) {
                StringBuilder animal = new StringBuilder();
                String line = scanner.nextLine();
                animal.append(line);
                animalLines.add(animal.toString());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }

        addWhiteSpaces(animalLines);
        reverseLines(animalLines);

        StringBuilder output = new StringBuilder();

        for(String s: animalLines) {
            output.append(s);
        }
        return output.toString();
    }

    private void addWhiteSpaces(ArrayList<String> animalLines) {
        int longest = 0;
        String space = " ";

        for(String s: animalLines) {
            if (s.length() > longest) {
                longest = s.length();
            }
        }

        for(int i = 0; i < animalLines.size(); i++) {
            String s = animalLines.get(i);

            if (s.length() < longest) {
                StringBuilder sb = new StringBuilder();
                int diff = longest - s.length();
                sb.append(s).append(space.repeat(diff)).append("\n");
                animalLines.set(i, sb.toString());
            } else {
                animalLines.set(i, animalLines.get(i) + "\n");
            }
        }
    }

    private void reverseLines(ArrayList<String> animalLines) {
        for(int i = 0; i < animalLines.size(); i++) {
            StringBuilder sb = new StringBuilder();
            String s = animalLines.get(i).replace("\n", "");

            for(int j = s.length() - 1; j >= 0; j--) {
                char ch = reverseChar(s.charAt(j));
                sb.append(ch);
            }

            String newLine = s + " | " + sb.toString() + "\n";
            animalLines.set(i, newLine);
        }
    }

    private char reverseChar(char ch) {
        switch (ch) {
            case '<':
                ch = '>';
                break;
            case '>':
                ch = '<';
                break;
            case '[':
                ch = ']';
                break;
            case ']':
                ch = '[';
                break;
            case '{':
                ch = '}';
                break;
            case '}':
                ch = '{';
                break;
            case '(':
                ch = ')';
                break;
            case ')':
                ch = '(';
                break;
            case '/':
                ch = '\\';
                break;
            case '\\':
                ch = '/';
                break;
            default:
                break;
        }
        return ch;
    }
}
