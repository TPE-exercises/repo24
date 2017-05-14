package de.hsMannheim.tpe.ss17.gruppe24.uebung3;

import de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt2.*;
import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CeasarReader extends FilterReader {
	private Crypter secure;
	
	public CeasarReader(Reader in, int shift){
		super(in);
		secure = new CrypterCaesar(shift);
	}
	
	@Override
	public int read() throws IOException {
		int c = super.read();
		String string = "" + (char) c;
		String decrypted = secure.decrypt(string);
		
		return decrypted.charAt(0);
	}
}
