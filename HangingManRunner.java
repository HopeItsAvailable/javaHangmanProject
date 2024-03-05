/* Authors: Helen Zhang, Rachel Holdren, Francisco Carranza, Saniya Bhatnagar, Kathryn Yokoyama
*  File Name: HangingManRunner.java
*  Specification: This file will play Hangman. Runner for the HangingMan methods. Contains the menu which starts the game and shows the user their
                    statistics, as well as options to quit the game, or view instructions.
*  For: CSE 110 9:05 AM- 9:55 AM Honors Project
*  Time Spent: 2 hours
*/

import java.util.Scanner;
import java.util.Random;

public class HangingManRunner extends HangingMan
{
    public static void main(String[] args)
    {
       //instance variables
       int losses; //counter for losses
       int wins; //counter for wins
       String option;
       char choice;
       String letter; //the letter that the user guesses
       char charLetter; 
       String word;
       
       Scanner scan = new Scanner(System.in);
       
       System.out.println("~~~~Welcome to the game of HANGING MAN!~~~~");
       
       printMenu();

       do
       {   
        	System.out.print("Please choose your option: ");
        	option = scan.next().toLowerCase();
            choice = option.charAt(0);
            
            switch(choice)
            {
                case 'i': //prints the instructions
                    System.out.println("How to play Hanging Man:\n"
                    		+ "In order to play Hanging Man, guess a word based on what letters\n"
                    		+ "it contains. Be warned: if you guess an incorrect letter, a part\n"
                    		+ "of a man will appear. The aim of the game is to guess the entirety of\n"
                    		+ "the word without causing the entirety of the man to appear.\n");
                    //System.out.print("?: Display Options Menu\n");
                    printMenu();
                    break;
                case 's': //starts a new game
                   //generates a new word
                    HangingMan man = new HangingMan();
                    do
                    {
                        //turn into a menu******
                        man.guessLetter();
                    }
                    while (!man.win() && !man.lose());
                     //statistics
                    if (HangingMan.wins != 1)
                    {
                        System.out.print("\n" + HangingMan.wins + " Wins & " );
                        if(HangingMan.losses != 1)
                        {
                            System.out.print(HangingMan.losses + " Losses");
                        }
                        else if (HangingMan.losses == 1)
                        {
                            System.out.print(HangingMan.losses +  " Loss");
                        }
                    }
                    if (HangingMan.wins == 1)
                    {
                        System.out.print("\n" + HangingMan.wins + " Win & " );
                        if(HangingMan.losses != 1)
                        {
                            System.out.print(HangingMan.losses + " Losses");
                        }
                        else if (HangingMan.losses == 1)
                        {
                            System.out.print(HangingMan.losses + " Loss");
                        }
                    }
                  
                   //repeat instructions
                    System.out.println("\nPress i for instructions, s to start again, and q to quit.");
                    break;
                case 'q': //quits the game
                    System.out.println("~~~ Thank you for playing Hanging Man ~~~");
                    break;
                default:
                    System.out.println("Invalid Input. Please pick an option.");
            }
        }
        while (choice != 'q');
    
    }

    public static void printMenu() //method to print menu
    {
        System.out.println("\nCommand Options\n"
                   + "-----------------------------------\n"
                   + "i: Instructions\n"
                   + "s: Start Game\n"
                   + "q: Quit Game\n");
    }
}

    