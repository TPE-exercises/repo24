package de.hsMannheim.tpe.ss17.gruppe24.uebung3;

public class WrongParameterException extends Exception {

	public WrongParameterException() {
		super();
	}
	
	public WrongParameterException(String message){
		super(message);
	}
}
