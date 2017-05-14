package de.hsMannheim.tpe.ss17.gruppe24.uebung3;

import de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt2.*;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CeasarWriter extends FilterWriter {

	private Crypter secure;
	
	public CeasarWriter(Writer out, int shift) {
		super(out);
		this.secure = new CrypterCaesar(shift);

	}

	@Override
	public void write(int c) throws IOException{
		String stringC = "" + (char) c;
		String encrypted = secure.encrypt(stringC);
		super.write(encrypted.charAt(0));
	}
	
	@Override
	public void write(char[] cbuf, int off, int len) throws IOException {
		String string = secure.encrypt(String.valueOf(cbuf));
		super.write(string.toCharArray(), off, len);
	}
	
	@Override
	public void write(String str, int off, int len) throws IOException {
		super.write(secure.encrypt(str), off, len);
	}
}
