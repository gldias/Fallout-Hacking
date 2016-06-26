/*
 * Author: Guilherme Dias
 * Objective: Recreate a hacking game from the well known Fallout game series
 */

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//********FLOW OF THE GAME***********
		
		Hacking game = new Hacking();
		
		//Get user input to determine difficulty of game
		int difficulty = 0;
		
		//Scanner object that will be used to get all of the user input throughout the game
		Scanner sc = new Scanner(System.in);
		
		while (difficulty < 1 || difficulty > 5){ //player needs to enter a valid difficulty
			try{
				System.out.print("Difficulty (1-5): ");
				String input = sc.next();
				difficulty = Integer.parseInt(input);
			}catch (Exception e){
				difficulty = 0;
				System.out.println("Invalid difficulty input");
			}
		}
		
		//Once we have the difficulty, create the word list, choose the answer, and print the words
		game.createWordList(difficulty);
		game.chooseAnswer();
		game.printWords();
		
		//Now that the game is set up, the user can start making guesses
		int guesses = 4;
		int wordSize = difficulty + 5;
		while (guesses > 0){
			try{
				System.out.print("Guess (" + guesses + " left)? ");
				String guess = sc.next();
				if (game.words.contains(guess.toLowerCase())){
					System.out.println(game.matchingLetters(guess) + "/" + wordSize + " correct");
					
					if (game.matchingLetters(guess) == wordSize){
						System.out.println("You win!");
						break;
					}else{
						guesses -= 1;
					}
				}else{
					System.out.println("Not a valid word option");
					guesses -= 1;
				}
			}catch(Exception e){
				System.out.println("Invalid guess");
				guesses -= 1;
			}
			
		}
		
		sc.close(); //close the Scanner being used for the game
		
		//If the player couldn't get the right word, print this message
		if (guesses == 0){
			System.out.println("Better luck next time!");
		}

	}

}
