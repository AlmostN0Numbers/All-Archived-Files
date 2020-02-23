//Name: Reid Moirn
//Class:	CS145
//Assignment: Lab 4
//Purpose: Hangman manager that allows hangmanMain to run in full

import java.util.*;
public class HangmanManager {
   //declerations of all nessicary variables
	private String currentPattern;
	private int guessN;
	private int wordX;
	private Set<String> currentWords;
	private SortedSet<Character> guessedLetters;
   //contructs and passes dictionary, and number of incorrect guesses possible
	public HangmanManager(List<String> dictionary, int length, int max){
		if(length < 1 || max < 0) {
			throw new IllegalArgumentException("");
         }
		currentPattern = "-";
		wordX = length;
		guessN = max;
		currentWords = new TreeSet<String>();
		guessedLetters = new TreeSet<Character>();
		for(String word : dictionary){
			if(word.length() == wordX){
				currentWords.add(word);
			}
		}
		for(int ii = 1; ii < length; ii++){
			currentPattern += " -";
		}
	}
   //user will acess this and recieve current words to be displayed for guessing
 	public Set<String> words(){ 
		return currentWords;
 	}
   //displays and returns how many guesses remain for the user
 	public int guessesLeft(){ 
		return guessN;
	}
   //sorts and returns what letters have been correctly guessed by the user
 	public SortedSet<Character> guesses(){
		return guessedLetters;
	}
   //returns the current patern and unguessed letters to the current game
 	public String pattern(){
		if(currentWords.isEmpty()){
			throw new IllegalStateException("No words possible.");
		}
		return currentPattern;
	}
   //records the guesses made by the user
 	public int record(char guess){
		SortedMap<String, Integer> patternOccurences = new TreeMap<String, Integer>();
		SortedMap<String, SortedSet<String>> patternWords = new TreeMap<String, SortedSet<String>>();
		int occurences = 0;
		if(guessN < 1 || currentWords.isEmpty()){
			throw new IllegalStateException("");
		}
		guessedLetters.add(guess);
		//decides what words to use after a guess going foward
		SortedSet<String> words = new TreeSet<String>();
		String newPattern = "";
		for(String word : currentWords){
			newPattern = currentPattern;
			occurences = 0;
			for(int jj = 0; jj < wordX; jj++){
				char[] charWord = word.toCharArray();
				if(charWord[jj] == guess){
					occurences++;
					char[] charPattern = newPattern.toCharArray();
					charPattern[jj*2] = guess;
					newPattern = "";
					for(int kk = 0; kk < charPattern.length; kk++){
						newPattern += charPattern[kk];
					}
				}
			}
			 if(patternWords.containsKey(newPattern)){
 				words = patternWords.get(newPattern);
 				words.add(word);
 			}
 			else {
 				SortedSet<String> tWords = new TreeSet<String>();
 				tWords.add(word);
 				words = tWords;
 				patternWords.put(newPattern, words);
 				patternOccurences.put(newPattern, occurences);
 			}
		}
      //returns words that arwe still valid
		SortedSet<String> largestWords = new TreeSet<String>();
		String largestPattern = "";
		int largest = 0;
		occurences = 0;
		for(String pattern : patternWords.keySet()){
			words = patternWords.get(pattern);
			if(words.size() > largest) {
				largest = words.size();
				largestPattern = pattern;
				largestWords = words;
				occurences = patternOccurences.get(pattern);
			}
			else if(words.size() == largest) {
				if(patternOccurences.get(pattern) < occurences) {
					largestWords = words;
					largestPattern = pattern;
					occurences = patternOccurences.get(pattern);
				}
			}
		}
		if(occurences == 0) {
			guessN--;
		}
		currentWords = largestWords;
		currentPattern = largestPattern;
		return occurences;
	}
}