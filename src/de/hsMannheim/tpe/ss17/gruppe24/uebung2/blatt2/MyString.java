package de.hsMannheim.tpe.ss17.gruppe24.uebung2.blatt2;

public class MyString implements Comparable<MyString> {

	String value;
	
	MyString(String value){
		this.value = value;
	}
	
	String getValue(){
		return this.value;
	}
	
	public String toString(){
		return value;
	}
	
	@Override
	public int compareTo(MyString other) {
		return value.compareToIgnoreCase(other.value);
	}

}
