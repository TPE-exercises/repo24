package de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil;

public class ArrayQueue implements Queue {

	protected Object[] array;
	protected boolean doubled;
	protected int counter; // count objects in array

	public ArrayQueue(int size){
		this.array = new Object[size];
		this.doubled = false;
		this.counter = 0;
	}
	
	public ArrayQueue(){
		this(10);
	}
	
	@Override
	public void enter(Object toInsert) throws Exception {

		if (this.counter < this.array.length) {
			for (int i = counter; i > 0; i--) {
				this.array[i] = this.array[i - 1];
			}
			array[0] = toInsert;
			counter++;
		} else if (this.doubled == false) {
			Object[] newArray = new Object[this.array.length * 2];

			for (int i = 0; i < this.array.length; i++) {
				newArray[i + 1] = this.array[i];
			}

			newArray[0] = toInsert;
			this.counter++;
			this.doubled = true;
			this.array = newArray;

			throw new MyOverflowException("array needed to be doubled to length = " + this.array.length+ ". [" + toInsert + "] added successfully.");
		} else

		{
			throw new MyOverflowException(
					"array is full and has already been doubled. " + toInsert + " could not be added.");
		}

	}

	@Override
	public Object leave() throws MyUnderflowException {

		if (isEmpty()) {
			throw new MyUnderflowException("Queue is empty. Underflow exception.");
		}

		// Set counter to the index of object to remove
		counter--;
		return this.array[counter];
	}

	@Override
	public Object front() throws MyUnderflowException {

		if (isEmpty()) {
			throw new MyUnderflowException("Queue is empty. Underflow exception.");
		}

		return this.array[this.counter - 1];
	}

	@Override
	public void empty(){
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
