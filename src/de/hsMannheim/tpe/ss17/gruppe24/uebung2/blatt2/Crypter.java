package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt2;

public interface Crypter {
	/***
	 * Enrypts a Message
	 * @param message - The message to encrypt
	 * @return The encrypted message
	 */
	public String encrypt(String message);

	/***
	 * Decrypts a Message
	 * @param message - The message to decrypt
	 * @return The decrypted message
	 */
	public String decrypt(String message);
}
