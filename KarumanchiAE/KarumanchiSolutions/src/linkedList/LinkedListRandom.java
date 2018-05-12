package linkedList;

public class LinkedListRandom extends LinkedList {
	class LinkedListRandomNode{
		int data;
		LinkedListRandomNode next;
		LinkedListRandomNode random;
		public LinkedListRandomNode(int d){
			data=d;
			next=null;
			random=null;
		}
	}
	
	LinkedListRandomNode head;
}
