package de.hsMannheim.tpe.gruppe24.uebung2.blatt2;

public class CrypterReverse implements Crypter {

	@Override
	public String encrypt(String message) {
		return reverseString(message);
	}

	@Override
	public String decrypt(String message) {
		return reverseString(message);
	}
	
	static private String reverseString(String string){
		String reverse = new String();

		for(int i = string.length() - 1; i > 0; i--){ //iterate backwards through the string
			reverse += string.charAt(i); // append char to the end of the string
		}

		return reverse;
	}
}
