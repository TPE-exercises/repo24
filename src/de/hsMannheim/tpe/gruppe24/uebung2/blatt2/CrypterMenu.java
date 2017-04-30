package de.hsMannheim.tpe.gruppe24.uebung2.blatt2;

import static gdi.MakeItSimple.*;

public class CrypterMenu {

	public static void main(String[] args) {
		
		println("Select action:");
		println(" 0) Encrypt");
		println(" 1) Decrypt");
		println(" 2) Exit");
		int selection = readInt();
		
		boolean encrypt = selection == 0;
		boolean decrypt = selection == 1;
		
		if(selection < 0 || selection > 1){
			println("Exitting!");
			return;
		}
		readLine();
		
		println("Enter message:");
		String message = readLine();

		println("Select Crypter:");
		println(" 0) CrypterReverse");
		println(" 1) CrypterCaesar");
		
		selection = readInt();

		Crypter crypter;
		
		switch(selection)
		{
		case 0:
		{
			crypter = new CrypterReverse();	
			break;
		}
		
		case 1:
		{
			println("Enter shift value for CrypterCaesar:");
			int shift = readInt();
			crypter = new CrypterCaesar(shift);	
			break;
		}
		
		default:
			return;
		
		}
		
		if(encrypt)
		{
			println(crypter.encrypt(message));
		}
		
		if(decrypt)
		{
			println(crypter.decrypt(message));
		}
	
		return;
	}
}
