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
}
