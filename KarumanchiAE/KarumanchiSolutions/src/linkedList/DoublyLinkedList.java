package linkedList;

import linkedList.LinkedList.Node;

public class DoublyLinkedList extends LinkedList {

	public DoublyLinkedList() {
		// TODO Auto-generated constructor stub
	}

	public DoublyLinkedList(Node head) {
		super(head);
		// TODO Auto-generated constructor stub
	}
	
	@Override
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
			t.prev = temp;
			temp.next = t;
			temp = temp.next;
		}
	}
	@Override
	public void printLinkedList() {
		Node temp=head;
		while(temp!=null){
			if (temp.prev != null) {
				System.out.print(temp.data + "<-");
			}
			if (temp.next != null) {
				System.out.print(temp.data + "->");
			}
			temp=temp.next;
		}
		System.out.println();
		
	}

}
