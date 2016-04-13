package com.home.javaimplementation.stack;

public class ThreeStacksUsingOneArray {
	
	int stackSize = 100;
	int[] buffer = new int[stackSize * 3];
	int[] stackPointer = {-1,-1,-1}; // top element
	
	
	void push(int stackNumber, int value) throws Exception{
		/* Check if we have space */
		if(stackPointer[stackNumber]+1 >= stackSize){
			throw new Exception("Out of space");
		}
		/* Increment stack pointer and then update top value */
		stackPointer[stackNumber]++ ;
		buffer[abs(stackNumber)] = value;
	}
	
	
	int pop(int stackNum) throws Exception {
		if(stackPointer[stackNum] == -1){
			throw new Exception("Trying to pop an empty stack.");
		}
		int returnValue = buffer[abs(stackNum)];
		buffer[abs(stackNum)] = 0;
		stackPointer[stackNum]--;
		return returnValue;
	}


	private int abs(int stackNumber) {
		// TODO Auto-generated method stub
		return stackNumber*stackSize + stackPointer[stackNumber];
	}
	

}
