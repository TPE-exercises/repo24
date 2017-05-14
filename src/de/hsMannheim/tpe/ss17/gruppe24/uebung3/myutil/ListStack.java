package de.hsMannheim.tpe.ss17.gruppe24.uebung3.myutil;

import java.util.LinkedList;

public class ListStack implements Stack {

	protected LinkedList<Object> list;
	protected int size;
	
	public ListStack(int size){
		this.list = new LinkedList<Object>();
		this.size = size;
	}
	
	public ListStack(){
		this(10);
	}
	
	@Override
	public void push(Object toInsert) throws Exception {
		if(list.size() >= size){
			throw new MyOverflowException("Stack is full. Overflow.");
		}
		else{
			list.add(toInsert);
		}
	}

	@Override
	public Object pop() throws Exception {
		if(isEmpty()){
			throw new MyUnderflowException("Stack is empty. Underflow.");
		}
		
		Object last = list.getLast();
		list.removeLast();
		
		return last;
	}

	@Override
	public Object top() throws Exception {
		if(isEmpty()){
			throw new MyUnderflowException("Stack is empty. Underflow.");
		}
		return list.getLast();
	}

	@Override
	public void empty() {
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
	
	@Override
	public int size(){
		return this.list.size();
	}

}
