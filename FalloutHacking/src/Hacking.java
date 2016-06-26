/*
 * Author: Guilherme Dias
 * The actual hacking game is set up here
 */

import java.util.*;

public class Hacking {
	
	//Reads the file
	Reader reader = new Reader("enable1.txt");

	//Set that will contain the choices of words
	//
	//The Set collection is used so that there are no duplicates in the list
	public Set<String> words = new HashSet<String>();
	
	//String that will contain the correct word
	String correct = null;
	
	public Hacking(){
		
	}
	
	/**
	 * Accessor method for words list
	 */
	public void getWords(){
		System.out.println(words);
	}
	
	/**
	 * Accessor method for correct answer
	 */
	public String getCorrect(){
		return correct;
	}
	
	/**
	 * Prints all of the words in the words set
	 */
	public void printWords(){
		String[] temp = words.toArray(new String[words.size()]);
		
		System.out.println();
		
		for (String word : temp){
			System.out.println(word.toUpperCase());
		}
		
		System.out.println();
	}
	
	/**
	 * 
	 * @param difficulty - difficulty of game, determined by player
	 * 
	 * Gets a number of random words from the text file
	 * and puts them in the words list
	 * 
	 */
	public void createWordList(int difficulty){
		int wordSize = difficulty + 5;
		int numberOfWords = difficulty + 7;
		
		while (words.size() < numberOfWords){
			words.add(reader.getRandomWord(wordSize));
		}
		
	}
	
	/**
	 * 
	 * Chooses word that will be the correct answer from the words set
	 * 
	 */
	public String chooseAnswer(){
		Random rand = new Random();
		int index = rand.nextInt(words.size());
		
		String[] temp = words.toArray(new String[words.size()]);
		
		correct = temp[index];
		
		return temp[index];
	}
	
	/**
	 * @return - number of matching letter positions between correct
	 */
	public int matchingLetters(String userInput){
		int matching = 0;
		
		for (int i = 0; i < correct.length(); i++){
			if (userInput.toUpperCase().charAt(i) == correct.toUpperCase().charAt(i)){
				matching++;
			}
		}
		
		return matching;
	}
	
}
