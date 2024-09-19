package scrabbleApp;

import java.util.List;
import java.util.ArrayList;

public class Letters {
	
	private String letters;
	
	
	//Constructs the Letters object
	public Letters(String s) {
		this.letters = s;
	}
	
	
	//boolean method to check if the given string of letters is less or equal to 7 characters
	public boolean checkLength() {
		if(letters.length() <= 7)
			return true;
		else
			return false;
	}
	
	
	//checks if the string of characters are only letters and returns either true or false
	public boolean hasLetters() {
		for(int i = 0; i < letters.length(); i++) {
			if(!(Character.isLetter(letters.charAt(i)))) {
				return false;
			}
		}
		return true;
	}
	
	
	/*This is the permutations method with a list for the different characters in the string and rearranges them
	 to get the different tile arrangements*/
	private void perm(String l, String r, List<String> list) {
		int count = r.length();
		if(count == 0) {
			if(!list.contains(l)) {
				list.add(l);
			}
		}
		else {
			for(int i = 0; i < count; i++) {
				perm(l + r.charAt(i), r.substring(0,i) + r.substring(i+1,count), list);
			}
		}
	}
	
	
	//creates a array list for the perm method 
	public List<String> createArray(){
		List<String> arr = new ArrayList<>();
		perm("",letters,arr);
		return arr;
	}
	
	

}
