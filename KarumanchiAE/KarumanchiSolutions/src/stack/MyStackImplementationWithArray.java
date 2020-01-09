package stack;
/**
 * Implementation of stack using dynamic array enlargement
 * @author emira
 *
 */
public class MyStackImplementationWithArray {
	
	public MyStackImplementationWithArray(int sizeOfArray) {
		this.sizeOfArray = sizeOfArray;
	}
	
	int sizeOfArray;
	int top = -1;
	int[] array = new int[sizeOfArray];
	// size of stack
	int size() {
		return top+1;
	}
	// push operation
	void push(int element) {
		if(size() == sizeOfArray) {
			this.sizeOfArray = 2*sizeOfArray;
		}
		array[++top] = element;
		
	}
	// pop operation
	void pop() {
		top--;
	}
	// top operation
	int top() {
		return top;
	}
	// isEmpty
	boolean isEmpty() {
		if(top == -1) {
			return true;
		}
		return false;
	}
}
