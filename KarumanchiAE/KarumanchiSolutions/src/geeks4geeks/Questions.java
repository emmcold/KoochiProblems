package geeks4geeks;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import geeks4geeks.LinkedList.Node;

public class Questions {
	/**
	 * Count nodes of a linked list.
	 */
	public int p_1(Node n) {
		Node temp = n;
		int numberOfNodes = 0;
		
		while(temp != null) {
			numberOfNodes ++;
			temp = temp.next;
		}
		
		return numberOfNodes;
		
	}
	
	/**
	 * Given two linked list of size N1 and N2 respectively of 
	 * distinct elements, your task is to complete the function countPairs(),
	 *  which returns the count of all 
	 * pairs from both lists whose sum is equal to the given value X. 
	 */
	
	// This is O(n^2) solution
	
	public int p_2(Node head1, Node head2, int x) {
		Node temp1 = head1;
		Node temp2 = head2;
		int sum = 0;
		
		while(temp1 != null) {
			while(temp2 != null) {
				
				if((temp1.data + temp2.data) == x) {
					sum++;
				}
				temp2 = temp2.next;
			}
			temp1 = temp1.next;
			temp2 = head2;
		}
		
		return sum;
	}
	
	// This is O(n) solution
	
	public int p_2_2(Node head1, Node head2, int x) {
		Node temp1 = head1;
		Node temp2 = head2;
		int sum = 0;
		HashSet<Integer> set = new HashSet<>();
		
		while(temp1 != null) {
			set.add(temp1.data);
			temp1 = temp1.next;
		}
		
		while(temp2 != null) {
			if(set.contains(x-temp2.data)) {
				sum ++;
			}
			temp2 = temp2.next;
		}
		return sum;
	}
	
	/**
	 * You are given a pointer/ reference to 
	 * the node which is to be deleted from the linked 
	 * list of N nodes. The task is to delete the node. 
	 * Pointer/ reference to head node is not given. 
	 */
	
	public void p_3(Node deleteNode) {
		Node temp = deleteNode;
		
		if (temp == null || temp.next == null) {
			temp = null;
			return;
		}
		
			temp.data = temp.next.data;
			temp.next = temp.next.next;
		
	}
	
	public void p_4(Node head, int p) {
		int n = 1;
		
		Node temp = head;
		
		while(n != p) {
			n++;
			temp = temp.next;
		}
		Node x = temp;
		
		while(x.next != null) {
			x = x.next;
		}
		
		
		x.next = head;
		head = temp.next;
		temp.next = null;
		
	}
	
	/**
	 * Given two linked lists, your task is to complete the 
	 * function makeUnion, that returns the union of two linked 
	 * lists. This union should include all the distinct elements 
	 * only.
	 */
	
	public LinkedList p_5(Node n1, Node n2) {
		Node temp1 = n1;
		Node temp2 = n2;
		
		Set<Integer> set = new TreeSet<>();
		
		while(temp1 != null) {
			set.add(temp1.data);
			temp1 = temp1.next;
		}
		
		while (temp2 != null) {
			set.add(temp2.data);
			temp2 = temp2.next;
		}
		
		LinkedList linkList = new LinkedList();
		Iterator<Integer> iterator = set.iterator();
		
		while(iterator.hasNext()) {
		linkList.addElementFromTail(iterator.next());
		}
		return linkList;
	}
}
