/*{
Programers: T Jake Holmes, David Rukashaza-Hancock, Ben Diskin, Jaspreet Khatkar
CS 145
1/9/2023
Assignment: Guessing game
Reference: 141 Guessing game
Purpose: To guess a number
Extra Credit: Try Catch 89-99

*/




import java.util.Scanner; // program imports scanner library
import java.util.*; // imports util. library for random number generator
import java.util.InputMismatchException; //

public class THDRBDJKGuessingGame {

   public static void main(String[] args ) {
   
      Scanner input = new Scanner(System.in); // creates scanner method
   
   // starting variables
      int totalGuessCount = 0; // amount of total guesses
      int guessCount = 0; // amount of guesses per round
      int gameCount = 0; // amount of total games
      int bestGuess = 101; // this is higher than any reasonable best Guess could be
   
      System.out.println("Do You Want To Play A Guessing Game, Yes or No?");
      String play = input.next();
      play = play.toLowerCase();
   
      while(!play.equals("no") && !play.equals("yes")) { // eror handling 
         System.out.println("Please answer yes or no");
         play = input.next();
      }
   
      if(play.equals("yes")) { // if they want to play do this
         while(play.equals("yes")) {
            instructions();
            guessCount = playGame(gameCount);
            totalGuessCount += guessCount;
            if(guessCount < bestGuess) { bestGuess = guessCount; }
            System.out.println("Would you like to play again?");
            play = input.next();
            while(!play.equals("no") && !play.equals("yes")) {
               System.out.println("Please answer yes or no");
               play = input.next();
            }
         
            gameCount++;
         }
         results(gameCount, totalGuessCount, bestGuess);
      
      } else { System.out.println("OK. You may run the program anytime if you change your mind."); } // if no
   
   } // end of main

   // instructions for the game. content changes depending on if this is the first round played
   public static void instructions() {
      System.out.println("The rules of the game are simple. I will think of a number, and then give you a chance to guess the number.");
      System.out.println("Once you've provided a guess, I will let you know if your guess is lower or higher than the number until you guess correctly.");
      System.out.println("Lets Begin:");
      return;
   }
   // final results determined by playGame
   public static void results(int gameCount, double totalGuessCount, int bestGuess) {
      System.out.println("FINAL GAME RESULTS:");
      System.out.println("Number of Games Played: " + gameCount);
      System.out.println("Average Number of Guesses: " + (totalGuessCount / gameCount)); // converts average to double
      System.out.println("Best Guess: " + bestGuess);
      if(bestGuess < 5){
         System.out.println("Your best guess is less than 5. You are a pro!!");// Secret note for true gamers 
      }   
      return;
   }
   // method to run the guessing game
   public static int playGame(int gameCount) {
   
      Scanner input = new Scanner(System.in); // creates scanner method
      Random rand = new Random();
     // int number = rand.nextInt(100) + 1; // created random # to guess
      int number = 10;
      int guessCount = 0; // total guesses for each individual game
      int guess = 0;
     
      if(gameCount == 0) { System.out.println("I'm thinking of a number between 1 and 100."); }
      else { System.out.println("I'm thinking of a new number between 1 and 100."); }
      while(guess != number){
         try {
            guess = input.nextInt();
            if(guess > number) { System.out.println("Your guess was too high. Please guess again:"); }
            else if(guess < number) { System.out.println("Your guess was too low. Please guess again:"); }
            guessCount++;
         }
         catch(InputMismatchException e) {
            String issue = input.nextLine(); 
            System.out.println(issue + " is not a valid number. Please choose a whole number between 1 and 100.");
            guessCount++;
         }
      } // end of while
            
      System.out.println("The number was " + number + ".  You guessed it!");
      
      return guessCount;
   } 
} // end of class