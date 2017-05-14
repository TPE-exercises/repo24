package de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil;

import java.util.LinkedList;

public class ListQueue implements Queue {

	protected LinkedList<Object> list;
	protected int size;
	
	public ListQueue(int size){
		this.size = size;
		list = new LinkedList<Object>();
	}
	
	public ListQueue(){
		this(10);
	}
	
	@Override
	public void enter(Object toInsert) throws MyOverflowException {
		
		if(list.size() >= this.size){
			throw new MyOverflowException("Queue is full. Overflow");
		}
		
		list.addFirst(toInsert);

	}

	@Override
	public Object leave() throws MyUnderflowException {
		if(isEmpty()){
			throw new MyUnderflowException("Queue is empty. Underflow");
		}
		Object toLeave = list.getLast();
		list.removeLast();
		
		return toLeave;
	}

	@Override
	public Object front() throws MyUnderflowException {
		if(isEmpty()){
			throw new MyUnderflowException("Queue is empty. Underflow");
		}
		return list.getLast();
	}

	@Override
	public void empty(){
		list.clear();
	}
	
	@Override
	public boolean isEmpty() {

		return list.isEmpty();
	}
	
	@Override
	public String toString(){
		return this.list.toString();
	}

}
