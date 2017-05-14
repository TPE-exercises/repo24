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

		String decrypted = secure.decrypt(Character.toString((char)c));
		
		return decrypted.charAt(0);
	}
	
	public int read(char[] cbuf, int off, int len) throws IOException
	{
		int ret = super.read(cbuf, off, len);
		
		// decrypt string
		String decrypted = secure.decrypt(new String(cbuf, off, len));
		
		// copy decrypted chars to buffer
		decrypted.getChars(0, len, cbuf, off);
		
		return ret;
	}
	
	
}
