package geeks4geeks;

import linkedList.LinkedList.Node;

public class LinkedList {
	Node head;
	class Node {
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
			
		}

		public Node() {
			// TODO Auto-generated constructor stub
		}
		
	}
	
	public LinkedList() {
		
	}
	
	public LinkedList(Node head) {
		this.head = head;
	}
	
	public void insertNodeAtHead(int data) {
		Node n = new Node(data);
		head = n;	
	}
	
	public void createLinkeListsFromArray(int[] arr){
		if (arr == null || arr.length == 0){
			return;
		}
		head = new Node(arr[0]);
		Node temp = head;
		for(int i = 1;i<arr.length;++i){
			Node t = new Node(arr[i]);
			temp.next = t;
			temp = temp.next;
		}
	}
	
	public void addElementFromTail(int data) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		Node temp = head;
		
		while(temp.next!=null) {
			temp = temp.next;
		}
		
		temp.next = newNode;
		
	}
	
	public void printLinkedList() {
		Node temp = head;
		
		System.out.println();	
		
		while(temp != null) {
			System.out.print(temp.data + "->");
			temp = temp.next;
		}
	}
}
