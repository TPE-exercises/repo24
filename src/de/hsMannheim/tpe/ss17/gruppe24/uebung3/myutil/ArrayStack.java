package de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil;

public class ArrayStack implements Stack {

	protected Object[] array;
	protected boolean doubled;
	protected int counter; //index of position to insert in array
	
	public ArrayStack(int arrayLength){
		this.array = new Object[arrayLength];
		this.doubled = false;
		this.counter = 0;
	}
	
	public ArrayStack(){
		this(10);
	}
	
	@Override
	public void push(Object toInsert) throws Exception {
		if(this.counter < this.array.length){
			array[counter++] = toInsert;
		}
		else if(!this.doubled){
			Object[] newArray = new Object[this.array.length * 2];
			
			for(int i = 0; i < this.array.length; i++){
				newArray[i] = this.array[i];
			}
			
			newArray[this.array.length] = toInsert;
			this.counter++;
			this.doubled = true;
			this.array = newArray;
			
			throw new MyOverflowException("array needed to be doubled to " + this.array.length + ". [" + toInsert + "] added successfully.");
		}
		else{
			throw new MyOverflowException("array is full and has already been doubled. [" + toInsert + "] could not be added.");
		}
	}

	@Override
	public Object pop() throws Exception {
		if(isEmpty()){
			throw new MyUnderflowException("Array is empty. Underflow.");
		}
		this.counter--;
		return this.array[counter];
	}

	@Override
	public Object top() throws MyUnderflowException {
		if(isEmpty()){
			throw new MyUnderflowException("Array is empty. Underflow.");
		}
		return this.array[counter - 1];
	}

	@Override
	public void empty() {
		this.counter = 0;
		if(this.doubled = true){
			Object[] newArray = new Object[this.array.length / 2];
			this.doubled = false;
			this.array = newArray;
		}
	}

	@Override
	public boolean isEmpty() {
		return counter == 0;
		
	}
	
	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < this.counter; i++) {
			string += "[" + this.array[i] + "] ";
		}
		return string;
	}
	
	@Override
	public int size(){
		return this.counter;
	}

}
