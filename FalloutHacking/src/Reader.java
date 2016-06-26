/*
 * 
 * Author: Guilherme Dias
 * Reads text file containing all of the words
 */

import java.io.*;
import java.util.*;

public class Reader {
	
	//List of words in the file
	List<String> words = new ArrayList<String>();
	
	//BufferedReader that will contain the text file
	FileReader fileReader;
	BufferedReader bufferedReader;
	
	//References one line at a time
	String line = null;
	
	public Reader(String fileName){
		try{
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);
		}catch(FileNotFoundException e){
			System.out.println("Unable to open file " + fileName);
		}catch(IOException e){
			System.out.println("Unable to read file " + fileName);
		}
		
		//Fill word list
		for (Scanner sc = new Scanner(bufferedReader); sc.hasNext(); ){
			words.add(sc.next());
		}
		
		
	}
	
	/**
	 * @param size: desired size of the word
	 * @return Random word from the text file
	 * 
	 * Uses resevoir sampling algorithm to choose a random word
	 * from the text file
	 */
	public String getRandomWord(int size){
		String result = "test";
		Random rand = new Random();
		
		//****FIRST ATTEMPT AT GETTING A RANDOM WORD FROM THE FILE****
		//****Works, but not with word size restrictions**************
		
		/*int n = 0;
		for(Scanner sc = new Scanner(bufferedReader); sc.hasNext(); ){
			++n;
			if(rand.nextInt(n) == 0){ // && line.length() == size){
				String line = sc.nextLine();
				if (line.length() != size){
					n = 0;
					sc.close();
					sc = new Scanner(bufferedReader);
				}else{
					result = line;
				}
			}
		}*/
		
		//****SECOND ATTEMPT AT GETTING RANDOM WORD FROM FILE****
		//****I couldn't get the Scanner to go back to the beginning of the file, so this does not work once the sum of the random lineNumbers exceeds the number of lines in the file
		
		/*boolean foundWord = false;
		while (foundWord == false){
			int lineNumber = rand.nextInt(172820) + 1; //172820 is the number of lines in the text file being used
			System.out.println(lineNumber);
			Scanner sc = new Scanner(bufferedReader);
			for (int i = 1; i < lineNumber; i++){
				//System.out.println(sc.hasNext());
				sc.nextLine();
			}
			String line = sc.nextLine(); //line at random line number
			if (line.length() == size){
				result = line;
				foundWord = true;
			}else{
				sc.close();
			}
		}*/
		
		boolean foundWord = false;
		while (foundWord == false){
			int randomWord = rand.nextInt(172820); //172820 is the number of lines in the file
			String word = words.get(randomWord);
			if (word.length() == size){
				result = word;
				foundWord = true;
			}
		}
		return result;
	}
	
	
	
	
}
