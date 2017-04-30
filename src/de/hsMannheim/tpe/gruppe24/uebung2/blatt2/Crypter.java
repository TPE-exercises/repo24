package de.hsMannheim.tpe.gruppe24.uebung2.blatt2;

interface Crypter {
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
