package pl.edu.agh.hangman;

import java.util.ArrayList;

public class RandomWord {

    private ArrayList<String> lista = new Words().readFile();

    public String randomWord() {
        int size = lista.size();
        int randomInt = (int)(Math.random() * size);
        return lista.get(randomInt);
    }
}
