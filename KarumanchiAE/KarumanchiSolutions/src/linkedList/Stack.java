/**
 * 
 */
package linkedList;

import linkedList.LinkedList.Node;

/**
 * @author emira
 *
 */
public class Stack {
	private int size;
	private LinkedList ll;
	private int currentSize;
	
	public Stack(int size){
		ll = new LinkedList();
		
	}
	public void push(int data){
	};
	public Node pop(){
		Node toReturn = null;
		if(!isEmpty()){
		toReturn = ll.deleteNodeAtHead();
		currentSize--;}
		else
		{
			System.out.println("It's empty, can't pop anything!");
		}
		return toReturn;
	};
	public int peak(){
		if(!isEmpty()){
		return ll.returnFirstNodeData();}
		return -1;
	};
	public boolean isEmpty(){
		
		if (currentSize<=0) return true;
		
		return false;
	};
	public boolean isFull(){
		if(currentSize>=size) return true;
		return false;
	};
	public void printStack(){
		ll.printLinkedList();
	}
}
