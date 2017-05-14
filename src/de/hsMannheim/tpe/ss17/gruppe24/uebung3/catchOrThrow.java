package de.hsMannheim.tpe.ss17.gruppe24.uebung3;

import de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil.*;
import static gdi.MakeItSimple.*;

public class catchOrThrow {

	//add values of two positive int variables
	//throws exceptions in case of integer overflow or wrong parameter
	public static int add(int a, int b) throws MyOverflowException, WrongParameterException {

		if (a < 0 || b < 0) {
			throw new WrongParameterException("Values need to be positive.");
		}

		int result = a + b;

		if (result <= 0) {
			throw new MyOverflowException("Integer Overflow.");
		}

		return result;
	}

	//use the add method and catch the wrong parameter exception
	public static int calculate(int a, int b) throws MyOverflowException{
		int result = 0;
		
		try{
			result = add(a, b);
		}catch(WrongParameterException e){
			e.printStackTrace();
		}
		
		return result;
	}

//	MyOverflowException is not caught in the method calculate().
//	The catch block in calculate can only handle WrongParameterException,
//	therefore calculate() throws the overflow exception. 
//	It is later handled inside the main function. 
	
	public static void main(String[] argv) {
		
		try{
		println(calculate(2000000000, 2000000000));
		} catch(MyOverflowException e){
			e.printStackTrace();
		}
	}

}
