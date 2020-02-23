//Name: Reid Moirn
//Class:	CS145
//Assignment: Lab 3 
//Purpose: Creates a word search with a users inputs as search words

public class LetterInventory{
   private int size;
	private int[] data;
	private String original;
	
	public static final int maxNum = 26;
	
   //Constructs the iventory, along with adding the counter for the letters
	public LetterInventory(String info){
		data = new int[maxNum];
		info = info.toLowerCase();
		original = info;
		for (int i = 0; i < info.length(); i++){ //for loop which is used for counting the number of individual letters
			if (Character.isLetter(info.charAt(i))){
				data[info.charAt(i) - 'a']++;
				if(info.charAt(i) == 'q'){
					data['u' - 'a']++;
				}
				size++;
			}
		}
	}
	
	//Returns the sum count of the letters
	public int size(){
		return size;
	}
	
   //calls the original form of the string
	public String getOriginal(){
		return original;
	}
	
	//method for if the inventory is void of data 
	public boolean isEmpty(){
		return size == 0;
	}
	
	//returns the count of how many letters are stored in the inventory, throws an exception for non-english charechters
	public int get(char letter){
		if (!Character.isLetter(letter))
			throw new IllegalArgumentException("letter: " + letter);
		return data[Character.toLowerCase(letter) - 'a'];
	}
	
	//converts data stored in the inventory too a string and readible format
	public String toString(){
		String result = "["; //always begins and ends the string with brackets
		for (int i = 0; i < maxNum; i++){
			for (int j = 0; j < data[i]; j++)
				result += (char)('a' + i);
		}
		return result + "]"; //end results
	}
	
	//set the count of each individual letter in the inventory, throws an exception for negative and non-valid char's
	public void set(char letter, int value){
		if (!Character.isLetter(letter) || value < 0) 
			throw new IllegalArgumentException("letter: " + letter + ", value: " + value);
		size += value - data[Character.toLowerCase(letter) - 'a']; 
		data[Character.toLowerCase(letter) - 'a'] = value;
	}
	
	//creates a new inventory, then adds the inventory of both into one larger inventory
	public LetterInventory add(LetterInventory other){
		LetterInventory sum = new LetterInventory("");
		for (int i = 0; i < maxNum; i++)
			sum.data[i] = this.data[i] + other.data[i]; //add both inventories together and return them as one
		sum.size = this.size + other.size;
		return sum;
	}
	//similar to the previous method, but rather subtracts both inventories
	public LetterInventory subtract(LetterInventory other){
		LetterInventory result = new LetterInventory("");
		for (int i = 0; i < maxNum; i++){
			result.data[i] = this.data[i] - other.data[i];
			if (result.data[i] < 0)
				return null; //makes sure that if the data returned is negative, it will be returned as 0
			result.size += result.data[i];
		}
		return result;
	}
}