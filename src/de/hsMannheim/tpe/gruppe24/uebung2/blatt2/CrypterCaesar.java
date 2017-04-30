package de.hsMannheim.tpe.gruppe24.uebung2.blatt2;

public class CrypterCaesar implements Crypter {

	private int shift;
	
	public CrypterCaesar(int shift){
		this.shift = shift;
	}
	
	@Override
	public String encrypt(String message) {
		return stringOperation(message, shift);
	}

	@Override
	public String decrypt(String message) {
		//decrypting is simply shifting the chars back, so use the negative shift value
		return stringOperation(message, -shift); 
	}
	
	static private String stringOperation(String message, int shift){
		
		String output = new String();
		
		for(int i = 0; i != message.length(); i++){
			
			char character = message.charAt(i);
			
			if(character >= 'a' && character <= 'z'){
				// in case we want to support lowercase letters properly, do this:
				output += charOperation(character, shift, 'a', 'z');
				
				// in case we want to do it like the senseless example, do this:
				// character += 'A' - 'a';
			}
			
			if(character >= 'A' && character <= 'Z'){
				output += charOperation(character, shift, 'A', 'Z');
			}
		}

		return output;
	}
	
	static private char charOperation(char character, int shift, char alphabetStart, char alphabetEnd){
		
		int alphabetSize = 1 + alphabetEnd - alphabetStart;
		
		//get index of the character in the current alphabet
		int characterIndex = character - alphabetStart; 
		
		//shift index by the amount of shift
		characterIndex += shift; 
		
		//normalize out of bound index
		characterIndex %= alphabetSize;
		characterIndex = (characterIndex < 0) ? characterIndex + alphabetSize : characterIndex;
		
		//convert index back to actual char
		return (char)(alphabetStart + characterIndex);
	}
}