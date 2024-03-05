/* Authors: Helen Zhang, Rachel Holdren, Francisco Carranza, Saniya Bhatnagar, Kathryn Yokoyama
*  File Name: HangingMan.java
*  Specification: This file will play Hangman. Contains the methods for the runner file (guessLetter, HangingMan constructor, and other helper methods
                    like addLimb, win, or lose)
*  For: CSE 110 9:05 AM - 9:55 AM Honors Project
*  Time Spent: 15 hours
*/

import java.lang.Math;
import java.io.*;
import java.util.*;

public class HangingMan extends RandomWord
{
    //instance variables
    private String word; //random word from wordBank
    private String wordGuess; //user input of word guess
    private int numWrongLetters; // number of wrong guesses
    private char[] guessedLetters; //letters guessed by the user
    private char[] wordArray; //array of characters of the random word
    private char[] blankWord; //array w underscores
    public static int losses;
    public static int wins;
    Random rand = new Random();
    //scanner
    Scanner scan = new Scanner(System.in);

    //constructor
    public HangingMan()
    {
        //generates a random word from saved word bank
        word = RandomWord.genWord();
        word = word.toLowerCase();
    
        //construct char array for guessed letters by the user (length of # of hangman limbs)
        guessedLetters = new char[8];

        //process word into the word array
        wordArray = RandomWord.getWordArray();

        //keep track of wrong letters guessed to find when user uses up 8 lives
        numWrongLetters = 0;

        //creates char array to for user to see length of word/progress of game
        blankWord = new char[word.length()];
        for (int j = 0; j < blankWord.length; j++)
        {
            blankWord[j] = '_';
        }
    }

//return word method for testing purposes
    public void returnWord()
    {
        System.out.println(word);
    }

//guess a letter method
    public void guessLetter()
    {
        boolean found = false; 
        boolean alreadyGuessed = false;
        //2 flag variables for determining if letter is already guessed or not
        char letter;

        do
        {
            //Print the blankWord array with the user's guessed letters //*******
        for (int j = 0; j < blankWord.length; j++)
        {
            System.out.print(blankWord[j] + " ");
        }
        
        	System.out.println("\n\nGuess Letter: ");
            //scans the user input of the letter, disregarding case, and converts to a char value+++
        	letter = scan.next().toLowerCase().charAt(0);
            
        	alreadyGuessed = false;
    	   
        	for(int i=0; i<guessedLetters.length; i++)
        	{	if (guessedLetters[i] == letter)
        		{
        			System.out.println("You've already guessed this letter");
        			alreadyGuessed = true;
        		}
        	}
        }
    	while (alreadyGuessed == true);  //if letter is already guessed, repeatedly print to user


        //if letter guessed is in the word, add to array
        for (int i=0; i < word.length(); i++) 
        {
            if (word.charAt(i) == letter)
            {
                addLetter(letter, i);
                found = true;
            }
        }
        
        //if letter guessed is not in the word, add limb
        if (found == false) 
        {
            guessedLetters[numWrongLetters] = letter;
            numWrongLetters++;
            addLimb();
        }
    }
    
    //helper method if the user wins the game
    public boolean win()
    {
        for (int i = 0; i < word.length(); i++) {
            if (blankWord[i] != word.charAt(i)) {
                return false;
            }
        }
        wins++;
    	    System.out.println("\nWin! \n" 
            + "The word was: " + word + "\n");
        return true;
        
    }

    //helper method if the user loses the game
    public boolean lose()
    {
        if (numWrongLetters == 8) {
            losses++;
    	    System.out.println("\nLose.\n"
            + "The word was: " + word + "\n");
            return true;
        }
        return false;
    }
  
    private void addLetter(char letter, int index)
    {
        //add the letter to the blankWord array
        blankWord[index] = letter;
    }
    
    //add limb helper method
    private void addLimb()
    {
        switch(numWrongLetters)
        {
            case 1: //blank game
                System.out.println();
                System.out.println("     ___________");
            	System.out.println("     |         |");
            	System.out.println("     |         |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("_____|_____");
                break;
            case 2: //top hat
            {
                System.out.println();
            	System.out.println("     ___________");
            	System.out.println("     |         | ");
            	System.out.println("     |      ___|___");
                System.out.println("     |      |     |");
                System.out.println("     |    __|_____|__");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("_____|_____");
                break;
            }
            case 3: //head
                System.out.println();
            	System.out.println("     ___________");
            	System.out.println("     |         | ");
            	System.out.println("     |      ___|___");
                System.out.println("     |      |     |");
                System.out.println("     |    __|_____|__");
                System.out.println("     |     / o   o \\");
                System.out.println("     |    |    U    |");
                System.out.println("     |     \\_______/");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("     |");
                System.out.println("_____|_____");
                break;
            case 4: //body
                System.out.println();
            	System.out.println("     ___________");
            	System.out.println("     |         | ");
            	System.out.println("     |      ___|___");
                System.out.println("     |      |     |");
                System.out.println("     |    __|_____|__");
                System.out.println("     |     / o   o \\");
                System.out.println("     |    |    U    |");
                System.out.println("     |     \\_______/");
                System.out.println("     |         |");
                System.out.println("     |         |");
                System.out.println("     |         |");
                System.out.println("     |         |");
                System.out.println("     |");
                System.out.println("_____|_____");
                break;
            case 5: //left arm
                System.out.println();
            	System.out.println("     ___________");
            	System.out.println("     |         | ");
            	System.out.println("     |      ___|___");
                System.out.println("     |      |     |");
                System.out.println("     |    __|_____|__");
                System.out.println("     |     / o   o \\");
                System.out.println("     |    |    U    |");
                System.out.println("     |     \\_______/");
                System.out.println("     |         |");
                System.out.println("     |        \\|");
                System.out.println("     |         |");
                System.out.println("     |         |");
                System.out.println("     |");
                System.out.println("_____|_____");
                break;
            case 6: //right arm
                System.out.println();
            	System.out.println("     ___________");
            	System.out.println("     |         | ");
            	System.out.println("     |      ___|___");
                System.out.println("     |      |     |");
                System.out.println("     |    __|_____|__");
                System.out.println("     |     / o   o \\");
                System.out.println("     |    |    U    |");
                System.out.println("     |     \\_______/");
                System.out.println("     |         |");
                System.out.println("     |        \\|/");
                System.out.println("     |         |");
                System.out.println("     |         |");
                System.out.println("     |");
                System.out.println("_____|_____");
                break;
            case 7: //left leg 
                System.out.println();          
                System.out.println("     ___________");
            	System.out.println("     |         | ");
            	System.out.println("     |      ___|___");
                System.out.println("     |      |     |");
                System.out.println("     |    __|_____|__");
                System.out.println("     |     / o   o \\");
                System.out.println("     |    |    U    |");
                System.out.println("     |     \\_______/");
                System.out.println("     |         |");
                System.out.println("     |        \\|/");
                System.out.println("     |         |");
                System.out.println("     |         |");
                System.out.println("     |        / ");
                System.out.println("_____|_____");
                break;

            case 8: //right leg
                System.out.println();
            	System.out.println("     ___________");
            	System.out.println("     |         | ");
            	System.out.println("     |      ___|___");
                System.out.println("     |      |     |");
                System.out.println("     |    __|_____|__");
                System.out.println("     |      _______  ");
                System.out.println("     |     / o   o,\\");
                System.out.println("     |    |    ^    |     (Oh no! My hat!)");
                System.out.println("     |     \\_______/");
                System.out.println("     |         |");
                System.out.println("     |        \\|/");
                System.out.println("     |         |");
                System.out.println("     |         |");
                System.out.println("_____|_____   / \\");
                break;
        }
    }    
}