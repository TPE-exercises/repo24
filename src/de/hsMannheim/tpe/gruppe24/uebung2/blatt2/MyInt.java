package de.hsMannheim.tpe.gruppe24.uebung2.blatt2;

// can somebody tell me the sense of this? Integer implements already Comparable
public class MyInt implements Comparable<MyInt> {

	int value;
	
	MyInt(int value){
		this.value = value;
	}
	
	int getValue(){
		return this.value;
	}
	
	public String toString(){
		return Integer.toString(value);
	}
	
	@Override
	public int compareTo(MyInt other) {
		return this.value - other.value;
	}
}
