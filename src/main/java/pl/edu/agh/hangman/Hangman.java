package pl.edu.agh.hangman;

import java.util.Locale;
import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {

        String word = new RandomWord().randomWord();
        WordCharArray wcr = new WordCharArray();
        HangTree ht = new HangTree();
        Scanner sc = new Scanner(System.in);

        char[] wordToGuess = wcr.charsArray(word);
        char[] hiddenWord = wcr.hideCharsArray(wordToGuess);

        System.out.println(word);

        int counter = 0;
        while (true) {
            if (counter == 6) {
                ht.printHangmanStatus(counter);
                System.out.println("GAME OVER, you lose!");
                break;
            }
            if (wcr.checkWin(wordToGuess, hiddenWord)) {
                ht.printHangmanStatus(counter);
                wcr.printCharArray(hiddenWord);
                System.out.println("YOU WIN! YOU GUESTED THE WORD: " + word.toUpperCase(Locale.ROOT) + " CORRECTLY!");
                break;
            }
            ht.printHangmanStatus(counter);
            wcr.printCharArray(hiddenWord);
            System.out.print("Guess a letter: ");
            char c = sc.hasNext() ? sc.next().trim().charAt(0) : 404;
            if (c == 404) {
                continue;
            }

            if (!wcr.guestChar(c, wordToGuess)) {
                counter++;
                continue;
            }
            wcr.checkGuess(c, wordToGuess, hiddenWord);
        }
        sc.close();
    }
}
