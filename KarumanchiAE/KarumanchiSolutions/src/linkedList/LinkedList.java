package linkedList;

import linkedList.LinkedList.Node;

public class LinkedList {

    class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data=data;
			this.next=null;
		}
	}
	
	Node head;

	public LinkedList(){
		
	}
	
	public LinkedList(Node head){
		this.head = head;
	}
	
	public void insertNodeAtHead(int data){
		Node n=new Node(data);
		n.next = head;
		head=n;
	}
	public Node deleteNodeAtHead(){
		Node tempDelete=head;
		head=tempDelete.next;
		tempDelete.next=null;
		return tempDelete;
	}
	public int returnFirstNodeData(){
		return head.data;
	}
	
	public void printLinkedList() {
		Node temp=head;
		while(temp!=null){
			System.out.print(temp.data + "->");
			temp=temp.next;
		}
		System.out.println();
		
	}
	public int lengthOfLinkedList(){
		Node temp=head;
		int count=0;
		while(temp!=null){
			count++;
			temp=temp.next;
		}
		return count;
	}
	public void printLinkedListReverse(Node t){
		if(t==null)
			return;
		printLinkedListReverse(t.next);
		System.out.print(t.data + "->");
	}

	public void printCircularLinkedList() {
		// TODO Auto-generated method stub
		Node temp=head;
		do{
			System.out.print(temp.data + "->");
			temp=temp.next;
		}while(temp!=head);
		System.out.println();
	}
	
	public Node reverseLinkedList(){
		
		if(head==null || head.next==null){
			return head;
		}
		Node prev=null;
		Node temp=head;
		Node current=head.next;
		
		while(current!=null){
			temp.next=prev;
			prev=temp;
			temp=current;
			current=current.next;
		}
		temp.next=prev;
		head=temp;
		return head;
	}

	/**
	 * Creates LinkedList from the given array.
	 * @param arr Array having the elements data.
	 */
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

	/**
	 * Reverses a linked list from the provided start position to the end position (excluding)
	 * @param start Start position of the linked list
	 * @param end End position of the linked list
	 * @return the beginning of the reversed linked list
	 */
	public Node reverseKElemenetsLinkedList(Node start, Node end){
		if(start == null || start.next == null){
			return start;
		}
		Node prev = null;
		Node current = start;
		Node next = current.next;
		while(current!=end)
		{
			current.next = prev;
			prev = current;
			current = next;
			if(next != null)
				next = next.next;
		}
		start.next = end;
		return prev;
	}

	/**
	 * Given a start node and a value k, it finds the end after iterating k elements
	 * @param start Starting node
	 * @param k The integer k
	 * @return the node after k elements
	 */
	public Node findEnd(Node start, int k) {
		// TODO Auto-generated method stub
		Node temp = start;
		while(temp.next!=null && k>0){
			temp = temp.next;
			k--;
		}
		return k > 0 ? null : temp;
	}
}
