package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt2;

public class CrypterCaesar implements Crypter {

	private int shift;
	private char[] alphabet;
	
	public CrypterCaesar(int shift){
		this.shift = shift;
		
		alphabet = new char[58];
		for(int i = 0; i < 26; i++){
			alphabet[i] = (char) ('a' + i); 
		}
		
		for(int i = 0; i < 26; i++){
			alphabet[i+26] = (char) ('A' + i); 
		}
		
		alphabet[52] = 'Ä';
		alphabet[53] = 'Ö';
		alphabet[54] = 'Ü';
		alphabet[55] = 'ä';
		alphabet[56] = 'ö';
		alphabet[57] = 'ü';
	}
	
	private int findChar(char charakter){
		
		for(int i = 0; i < alphabet.length; i++){
			if(alphabet[i] ==  charakter){
				return i;
			}
		}
		
		return -1;
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
	
	private String stringOperation(String message, int shift){
		
		//test stuff abcxyzABCXYZäöüÄÖÜ
		
		String output = new String();
		
		for(int i = 0; i != message.length(); i++){
			
			char character = message.charAt(i);
			
			int index = findChar(character);
			
			if(index == -1){
				output += character; 
			}
			else{
				int newindex = (index+shift) % alphabet.length;
				if(newindex < 0) newindex += alphabet.length;
				
				output += alphabet[newindex];
			}
			
		}

		return output;
	}
}