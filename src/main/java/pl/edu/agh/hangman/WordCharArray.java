package pl.edu.agh.hangman;

public class WordCharArray {

    public void printCharArray(char[] arr) {
        for (char c : arr) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    public char[] charsArray(String word) {
        return word.toCharArray();
    }

    public char[] hideCharsArray(char[] arr) {
        char[] hiddenArr = new char[arr.length];
        for (int i=0; i < arr.length; i++) {
            hiddenArr[i] = '_';
        }
        return hiddenArr;
    }

    public void checkGuess(char c, char[] arr, char[] hid) {
        for (int i = 0; i < arr.length ; i++) {
            if (c == arr[i]) {
                hid[i] = arr[i];
            }
        }
    }

    public boolean guestChar(char c, char[] arr) {
        for (int i = 0; i < arr.length; i++) {
             if (c == arr[i]) {
                 return true;
             }
        }
        return false;
    }

    public boolean checkWin(char[] wordToGuess, char[] hiddenWord) {
        int counter = 0;
        for (int i = 0; i < wordToGuess.length; i++) {
            if (wordToGuess[i] == hiddenWord[i]) {
                counter++;
            }
        }
        if (counter == wordToGuess.length)
            return true;
        else
            return false;
    }
}
