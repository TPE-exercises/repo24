package de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil;

public class ArrayQueue implements Queue {

	protected Object[] buffer;
	protected int begin;
	protected int count;
	protected boolean doubled;
	
	
	public ArrayQueue(int capacity){
		buffer = new Object[capacity];
		begin = 0;
		count = 0;
		
		doubled = false;
	}
	
	public ArrayQueue(){
		this(10);
	}
	
	@Override
	public void enter(Object toInsert) throws MyOverflowException {
		if(count >= buffer.length){
			
			if(!doubled){
				reserve(buffer.length * 2);
				doubled = true;
				throw new MyOverflowException("buffer doubled to length = " + buffer.length+ ". [" + toInsert + "] added successfully.");
			}
			else {
				throw new MyOverflowException("buffer has already been doubled. " + toInsert + " could not be added.");
			}
		}
	
		buffer[(begin + count) % buffer.length] = toInsert;
		
		count++;
	}

	public Object leave() throws MyUnderflowException {

		if (isEmpty()) {
			throw new MyUnderflowException("Queue is empty. Underflow exception.");
		}

		Object element = buffer[begin];
		
		count--;
		begin = (begin + 1) % buffer.length;
		
		return element;
	}
	
	public void reserve(int newCapacity){
		Object[] newBuffer = new Object[newCapacity];
		
		int newCount = 0;
		
		while (newCount < newCapacity){
			
			if(newCount >= count){
				break;
			}
			
			newBuffer[newCount] = buffer[begin + newCount];
			newCount++;
		}
		
		buffer = newBuffer;
		begin = 0;
		count = newCount;
	}


	@Override
	public Object front() throws MyUnderflowException {

		if (isEmpty()) {
			throw new MyUnderflowException("Queue is empty. Underflow exception.");
		}

		return buffer[begin];
	}

	@Override
	public void empty(){
		// set all elements to zero, we don't want to reference objects unnecessarily
		for(int i = 0; i < buffer.length; i++){
			buffer[i] = null;
		}
		
		begin = 0; 
		count = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return count == 0;
	}
	
	@Override
	public int size(){
		return count;
	}
	
	public String toString() {
		String string = new String();
		
		for (int i = 0; i < this.count; i++) {
			string += "[" + this.buffer[(begin + i) % buffer.length] + "] ";
		}
		
		return string;
	}
}
