/**
 * 
 */
package linkedList;

import java.util.HashMap;
import java.util.HashSet;

import linkedList.LinkedList.Node;
import linkedList.LinkedList;
//Read problem 42 from the book of Karumanchi pdf 
//Read & Solve problem 44 from the book 
//Read the question about ordering the linked list (Snake solution)
//Read Question 51 from the book of Karumanchi pdf
/**
 * @author emira
 *
 */
public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//question1();
		//question2b();
		//System.out.println("Linked List has a loop : " + question3());
		//System.out.println("The start of the loop is: " + question3b());
		//System.out.println("The size of the loop is: "+question14());
		//question15(12);
		//System.out.println("The intersectio is: "+ question17().data);
		//System.out.println("The intersectio is: "+ question23().data);
		//System.out.println("The element in the middle of the ll is: "+question24().data);;
		//System.out.println("The linked list size is even: "+question29());
		//System.out.println("The merged linked lists: ");
		//question31().printLinkedList();
		//question36();
		//question44();
		//question46b(3);
		//question48(3);
		//question50();
		//question53();
		//testReverseRec();
		//CTCIprob21b();
		//CTCIprob22(23);
		//CTCIprob23();
		//CTCIprob25();
		//System.out.println(CTCIprob26());
		//System.out.println(CTCIprob27());
		System.out.println(CTCIprob28());
	}



	public static void question1(){
		Stack s=new Stack(5);
		int i=1;
		while(!s.isFull()){
			//s.push(i);
			i+=2;
		}
		s.printStack();
		//s.push(6);
		//int sPeak=s.peak();
		System.out.println("This is the peak: "+s.peak());
		System.out.println("The popped element is: " + s.pop().data);
		System.out.println("The stack after poping one element: ");
		s.printStack();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.peak();
		s.pop();
	}
	public static void question2(){
		LinkedList ll = new LinkedList();
		int n=5;

		int elements=4;
		while(elements!=14){
			ll.insertNodeAtHead(elements);
			elements++;
		}
		ll.printLinkedList();
		int length=ll.lengthOfLinkedList();
		//thanks for this. I always forget that :( . :D Koochi. Run this

		if(n>=length){
			System.out.println("The value is incorrect! Insert smaller n.");
			return;
		}
		int position=length-n;
		int currentPosition=1;
		Node temp=ll.head;
		while(currentPosition!=position){
			temp=temp.next;
			currentPosition++;
		}
		System.out.println("The returned " + n+"-th position number"
				+ " is: "+temp.data);
	}
	/**
	 * question2b() is an efficient solution to question2()
	 * question2b() is in O(n) by making use of two pointers
	 */
	public static void question2b(){
		LinkedList ll = new LinkedList();
		int n=5;

		int elements=4;
		while(elements!=14){
			ll.insertNodeAtHead(elements);
			elements++;
		}
		ll.printLinkedList();
		Node temp=ll.head;
		Node tempSpecial=ll.head;
		for(int i=1;i<=n;i++){
			tempSpecial=tempSpecial.next;
		}
		while(tempSpecial.next!=null){
			temp=temp.next;
			tempSpecial=tempSpecial.next;
		}
		System.out.println("The returned " + n+"-th position number"
				+ " is: "+temp.data);
	}

	public static boolean question3(){
		LinkedList ll = new LinkedList();

		ll.insertNodeAtHead(100);
		//13->12->11->10->9->8->7->6->5->4->(100) temp

		Node temp = ll.head;
		int elements=4;
		while(elements!=14){
			ll.insertNodeAtHead(elements);
			if(elements == 8)
			{
				temp.next = ll.head;
			}
			elements++;

		}
		//ll.printLinkedList();


		Node slowPointer=ll.head;
		Node fastPointer=ll.head;
		if(ll.head==null || ll.head.next==null || ll.head.next.next==null){
			return false;
		}
		while(fastPointer!=null){
			slowPointer=slowPointer.next;
			if(fastPointer.next!=null){
				fastPointer=fastPointer.next.next;
			}
			if(fastPointer==slowPointer){
				return true;
			}
		}
		return false;
	}
	/**
	 * Return the beginning of the loop in a linked list
	 * @return
	 */
	public static int question3b(){
		LinkedList ll = new LinkedList();

		ll.insertNodeAtHead(100);
		//13->12->11->10->9->8->7->6->5->4->(100) temp

		Node temp = ll.head;
		int elements=4;
		while(elements!=14){
			ll.insertNodeAtHead(elements);
			if(elements == 8)
			{
				temp.next = ll.head;
			}
			elements++;

		}
		if(ll.head==null || ll.head.next==null){
			return -1;
		}
		Node head = ll.head;

		Node slowPointer=head;
		Node fastPointer=head.next.next;

		while(fastPointer!=null){

			if(slowPointer==fastPointer){
				fastPointer=head;
				while(fastPointer!=slowPointer){
					fastPointer=fastPointer.next;
					slowPointer=slowPointer.next;
				}
				return fastPointer.data;
			}
			slowPointer=slowPointer.next;
			if(fastPointer.next != null)
				fastPointer=fastPointer.next.next;	
		}
		return -1;
	}
	//if false-there is no loop
	public static Node  questionF(){
		LinkedList ll = new LinkedList();

		ll.insertNodeAtHead(100);
		//13->12->11->10->9->8->7->6->5->4->(100) temp

		Node temp = ll.head;
		int elements=4;
		while(elements!=14){
			ll.insertNodeAtHead(elements);
			if(elements == 8)
			{
				temp.next = ll.head;
			}
			elements++;
		}

		HashMap<Node, Integer> hm=new HashMap<Node, Integer>();

		Node temp2=ll.head;

		while(temp2!=null){
			if(hm.containsKey(temp2)){
				return temp2;
			}
			hm.put(temp2, temp2.data);
			temp2=temp2.next;
		}
		return null;
	}

	/**
	 * Find the length of the loop (if exists) in the linked lists
	 * @return
	 */
	public static int question14(){
		LinkedList ll = new LinkedList();

		ll.insertNodeAtHead(100);
		//13->12->11->10->9->8->7->6->5->4->(100) temp

		Node temp = ll.head;
		int elements=4;
		while(elements!=14){
			ll.insertNodeAtHead(elements);
			if(elements == 8)
			{
				temp.next = ll.head;
			}
			elements++;
		}
		if(ll.head==null || ll.head.next==null){
			return -1;
		}

		Node slowP=ll.head, fastP=ll.head.next.next;
		int counter=1;
		while(fastP!=null){
			if(fastP==slowP){
				fastP=fastP.next;
				while(fastP!=slowP){
					fastP=fastP.next;
					counter++;
				}
				return counter;
			}
			if(slowP!=null){
				slowP=slowP.next;}
			if(fastP.next!=null){
				fastP=fastP.next.next;}
		}
		return 0;
	}
	/**
	 * Insert a node in the sorted linked list
	 * @param data
	 */
	public static void question15(int data){
		LinkedList ll = new LinkedList();

		int elements=14;
		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}
		ll.printLinkedList();
		Node temp = ll.head;
		Node newN=ll.new Node(data);
		if(ll.head==null || data<temp.data ){
			newN.next=temp;
			ll.head=newN;
			ll.printLinkedList();
			return;
		}

		while(temp.next!=null){
			if(data>=temp.data && data<=temp.next.data){
				newN.next=temp.next;
				temp.next=newN;
				ll.printLinkedList();
				return;
			}	
			temp=temp.next;
		}
		if(data>=temp.data){
			temp.next=newN;
		}
		ll.printLinkedList();
	}

	//This code doesn't work. Fix it
	public static void problem15Aman(int data){
		LinkedList ll = new LinkedList();

		int elements=14;
		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements++;
		}
		ll.printLinkedList();
		//1 -> 2 -> 3 -> 4 -> 6 
		Node temp = ll.head;
		Node prev = ll.head;
		Node newN = ll.new Node(data);
		while(temp!=null){
			if(data <= temp.data){
				prev.next = newN;
				newN.next = temp;
				return;
			}
			prev = temp;
			temp = temp.next;
		}
		if(temp == ll.head && temp == null){
			ll.head = newN;
		}
		else{
			prev.next = newN;
		}
	}
	/**
	 * Reverse a linked list
	 */
	public static void question16(){
		LinkedList ll = new LinkedList();

		int elements=14;
		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}
		ll.printLinkedList();
		if(ll.head==null || ll.head.next==null){
			ll.printLinkedList();
			return;
		}
		Node prev=null;
		Node current=ll.head;
		Node temp=current.next;

		while(temp!=null){
			current.next=prev;
			prev=current;
			current=temp;
			temp=temp.next;	
		}
		current.next=prev;
		ll.head=current;
		ll.printLinkedList();
	}
	public static Node question17(){
		LinkedList ll = new LinkedList();

		int elements=14;
		Node temp = null;
		while(elements!=1){
			ll.insertNodeAtHead(elements);
			if(elements == 7)
			{
				temp = ll.head;
			}
			elements--;
		}
		ll.printLinkedList();

		LinkedList ll1 = new LinkedList();

		elements=100;
		ll1.head = temp;
		while(elements!=96){
			ll1.insertNodeAtHead(elements);
			elements--;
		}
		ll1.printLinkedList();
		if(ll==null || ll1==null){
			return null;
		}
		HashMap<Node, Boolean> hm=new HashMap<Node, Boolean>();

		Node tempN=ll.head;
		while(tempN!=null){
			hm.put(tempN, true);
			tempN=tempN.next;
		}
		Node temp2=ll1.head;
		while(temp2!=null){
			if(hm.containsKey(temp2)){
				return temp2;
			}
			temp2=temp2.next;
		}
		return null;
	}
	public static Node question23(){
		LinkedList ll = new LinkedList();

		int elements=14;
		Node temp = null;
		while(elements!=1){
			ll.insertNodeAtHead(elements);
			if(elements == 7)
			{
				temp = ll.head;
			}
			elements--;
		}
		ll.printLinkedList();

		LinkedList ll1 = new LinkedList();

		elements=100;
		ll1.head = temp;
		while(elements!=96){
			ll1.insertNodeAtHead(elements);
			elements--;
		}
		ll1.printLinkedList();
		if(ll.head==null || ll1.head==null){
			return null;
		}
		int lList1=ll.lengthOfLinkedList();
		int lList2=ll1.lengthOfLinkedList();
		int dif=Math.abs(lList1-lList2);

		Node tempshortLl=ll1.head;
		Node tempLongLl=ll.head;

		int minLl=Math.min(lList1,lList2);

		if(minLl==lList1){
			tempshortLl=ll.head;
			tempLongLl=ll1.head;
		}


		for(int i=0;i<dif;i++){
			tempLongLl=tempLongLl.next;
		}

		while(tempshortLl!=null){
			if(tempLongLl==tempshortLl){
				return tempLongLl;
			}
			tempLongLl=tempLongLl.next;
			tempshortLl=tempshortLl.next;
		}
		return null;
	}
	/**
	 * Find the middle of the linked list using the efficient approach.
	 */
	public static Node question24(){
		LinkedList ll = new LinkedList();

		int elements=13;
		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}
		ll.printLinkedList();
		if(ll.head==null || ll.head.next==null){
			return ll.head;
		}

		Node sP=ll.head;
		Node fP=ll.head;
		while(fP!=null && fP.next!=null){
			sP=sP.next;
			fP=fP.next.next;
		}
		return sP;
	}
	public static void question28(){
		LinkedList ll = new LinkedList();

		int elements=13;
		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}
		ll.printLinkedList();
		ll.printLinkedListReverse(ll.head);

	}
	/**
	 * This checks if the length of the linked list
	 * is either even or odd. If even return true, if odd return false
	 * @return
	 */
	public static boolean question29(){
		LinkedList ll = new LinkedList();

		int elements=13;
		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}
		ll.printLinkedList();
		if(ll.head==null){
			return true;
		}
		Node fastPointer=ll.head;
		while(fastPointer!=null && fastPointer.next!=null){
			fastPointer=fastPointer.next.next;
		}
		return fastPointer == null ? true : false;
	}
	/**
	 * Merge two sorted linked lists in a new linked list.
	 * @return
	 */
	public static LinkedList question31(){
		LinkedList ll1=new LinkedList();
		int elements=50;
		while(elements!=39){
			ll1.insertNodeAtHead(elements);
			elements--;
		}
		LinkedList ll2=new LinkedList();
		int elements2=45;
		while(elements2!=30){
			ll2.insertNodeAtHead(elements2);
			elements2--;
		}

		if(ll1.head==null && ll2.head!=null){
			return ll2;
		}
		if(ll2.head==null && ll1.head!=null){
			return ll1;
		}
		LinkedList ll3 = new LinkedList();
		Node newNode=ll3.new Node(4);
		Node temp=newNode;
		Node temp1=ll1.head;
		Node temp2=ll2.head;
		ll1.printLinkedList();
		ll2.printLinkedList();
		while((temp1!=null) && (temp2!=null)){
			if(temp1.data<=temp2.data){
				temp.next=temp1;
				temp1=temp1.next;
			}
			else{
				temp.next=temp2;
				temp2=temp2.next;
			}
			temp=temp.next;
		}
		if(temp1!=null){
			temp.next=temp1;
		}
		if(temp2!=null){
			temp.next=temp2;
		}
		temp=newNode.next;
		ll3.head = temp;
		return ll3;
	}
	/**
	 * Problem 36-split a circular linked list into two separate
	 * circular linked lists
	 */
	public static void question36(){
		LinkedList ll1=new LinkedList();
		int elements=50;
		ll1.insertNodeAtHead(51);
		Node ll1Temp=ll1.head;
		while(elements!=38){
			ll1.insertNodeAtHead(elements);
			elements--;
			//ll1Temp=ll1Temp.next;
		}
		ll1Temp.next=ll1.head;
		ll1.printCircularLinkedList();

		Node fastPointer=ll1.head;
		Node slowPointer=ll1.head;

		while(fastPointer.next!=ll1.head){
			fastPointer=fastPointer.next.next;
			slowPointer=slowPointer.next;
			if(fastPointer.next.next == ll1.head){
				fastPointer = fastPointer.next;
			}
		}
		fastPointer.next=slowPointer.next;
		LinkedList ll2 = new LinkedList(slowPointer.next);
		slowPointer.next=ll1.head;
		ll1.printCircularLinkedList();
		ll2.printCircularLinkedList();
	}
	public static boolean question37(){
		LinkedList ll = new LinkedList();

		ll.insertNodeAtHead(1);
		ll.insertNodeAtHead(1);
		ll.insertNodeAtHead(2);
		ll.insertNodeAtHead(1);
		ll.insertNodeAtHead(1);
		ll.printLinkedList();
		if(ll.head==null || ll.head.next==null){
			return true;
		}

		Node fastP=ll.head;
		Node slowP=ll.head;
		Node prevSlowP=ll.head;

		while(fastP!=null && fastP.next!=null){
			prevSlowP=slowP;
			slowP=slowP.next;
			fastP=fastP.next.next;
		}

		Node middle;

		if(fastP!=null){
			middle=slowP;
		}

		//Node prev=null; prevSlow
		//Node current=ll.head; slowP
		Node temp=slowP.next;

		while(temp!=null){
			slowP.next=prevSlowP;
			prevSlowP=slowP;
			slowP=temp;
			temp=temp.next;	
		}
		slowP.next=prevSlowP;
		//ll.head=slowP;
		temp=ll.head;
		while(temp!=null || slowP!=null){
			if(temp.data!=slowP.data){
				return false;
			}
			temp=temp.next;
			slowP=slowP.next;
		}
		return true;
	}

	public static void question44(){
		LinkedList ll = new LinkedList();

		int elements=13;

		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}

		ll.printLinkedList();

		if(ll.head==null || ll.head.next==null){
			return;
		}
		Node temp=ll.head;
		Node temp1=null;
		Node temp2=null;
		Node temp2Head=null;
		Node temp1Head=null;
		while(temp!=null){
			if(temp.data%2==1){
				//Create/Snake linked list with temp1
				if(temp1Head == null){
					temp1Head = temp;
					temp1 = temp1Head;
				}
				else{
					temp1.next = temp;
					temp1 = temp1.next;
				}
			}
			else{
				//Create/Snake linked list with temp2
				if(temp2Head == null){
					temp2Head = temp;
					temp2 = temp2Head;
				}
				else{
					temp2.next = temp;
					temp2 = temp2.next;
				}
			}
			temp = temp.next;
		}
		temp2.next = null;
		temp1.next = null;
		temp2.next = temp1Head;
		ll.head = temp2Head;

		ll.printLinkedList();

	}
	public static void question46(int k){
		LinkedList ll = new LinkedList();

		int elements=13;

		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}
		//print linked list
		ll.printLinkedList();

		Node temp1=ll.head;
		Node temp2=ll.head;
		//n is the length of the linked list
		int n=ll.lengthOfLinkedList();

		//find the nNode element from 
		//the end of the linked list

		int nNode=n%k;

		for(int i=1;i<=nNode;i++){
			temp1=temp1.next;
		}

		while(temp1.next!=null){
			temp1=temp1.next;
			temp2=temp2.next;
		}

		System.out.println("The node with k="+k+" and n="+n+" is: "+temp2.data);
	}

	public static void question46b(int k){
		LinkedList ll = new LinkedList();

		int elements=13;

		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}
		//print linked list
		ll.printLinkedList();
		Node temp = ll.head;
		int pos = 1;
		Node moduloNode = null;
		while(temp!=null){
			if(pos%k == 0){
				moduloNode = temp;
			}
			pos++;
			temp = temp.next;
		}
		System.out.println("The node is: "+moduloNode.data);

	}

	public static void question48(int k){
		LinkedList ll = new LinkedList();

		int elements=13;

		while(elements!=1){
			ll.insertNodeAtHead(elements);
			elements--;
		}
		//print linked list
		ll.printLinkedList();

		Node tempk=ll.head;
		Node temp2=ll.head;

		for(int i=0;i<k;i++){
			tempk=tempk.next;
		}

		while(tempk!=null){
			temp2=temp2.next;
			for(int i=1;i<=k && tempk!=null;++i){
				tempk=tempk.next;
			}
		}

		System.out.println("The n/k-th node is: "+temp2.data);

	}
	public static void question50(){
		LinkedList ll1=new LinkedList();
		int elements=50;
		while(elements!=39){
			ll1.insertNodeAtHead(elements);
			elements--;
		}
		ll1.printLinkedList();

		LinkedList ll2=new LinkedList();
		int elements2=45;
		while(elements2!=30){
			ll2.insertNodeAtHead(elements2);
			elements2--;
		}

		ll2.printLinkedList();

		Node tempFirst=ll1.head;
		Node tempSecond=ll2.head;
		Node movingTemp=null;
		Node returnHead=null;


		while(tempFirst!=null && tempSecond!=null){
			if(tempFirst.data<=tempSecond.data){
				if(tempFirst==ll1.head && returnHead==null){
					returnHead=tempFirst;
					movingTemp=tempFirst;
				}
				else{
					movingTemp.next=tempFirst;
					movingTemp=movingTemp.next;
				}

				tempFirst=tempFirst.next;
			}
			else{
				if(tempSecond==ll2.head && returnHead==null){
					returnHead=tempSecond;
					movingTemp=tempSecond;
				}
				else{
					movingTemp.next=tempSecond;
					movingTemp=movingTemp.next;}
				tempSecond=tempSecond.next;
			}

		}

		if(tempFirst!=null){
			movingTemp.next=tempFirst;
		}
		if(tempSecond!=null){
			movingTemp.next=tempSecond;
		}
		System.out.println("The head of the new linked list is: "+returnHead.data);
		// LinkedList ll3 = new LinkedList();
		// ll3.head = returnHead;
		// ll3.printLinkedList();
		System.out.println();
		Node tempPrint=returnHead;
		while(tempPrint!=null){
			System.out.print(tempPrint.data + "->");
			tempPrint=tempPrint.next;
		}

	}

	/**
	 * Given two linked lists, each list node with one integer digit, 
	 * add these two linked lists. 
	 * The result should be stored in the third linked list. 
	 * Also note that the head node contains the most significant 
	 * digit of the number.
	 */

	public static void question53(){
		LinkedList ll1=new LinkedList();
		int elements=1;
		while(elements!=8){
			ll1.insertNodeAtHead(elements);
			elements++;
		}
		ll1.printLinkedList();

		LinkedList ll2=new LinkedList();
		int elements2=9;
		while(elements2!=1){
			ll2.insertNodeAtHead(elements2);
			elements2--;
		}

		ll2.printLinkedList();

		Node firstLlNode=ll1.reverseLinkedList();
		Node secondLLNode=ll2.reverseLinkedList();
		ll1.printLinkedList();
		ll2.printLinkedList();

		Node temp1=firstLlNode;
		Node temp2=secondLLNode;

		int carry=0;
		int sum=0;

		if(ll1.lengthOfLinkedList()<ll2.lengthOfLinkedList()){
			temp1=secondLLNode;
			temp2=firstLlNode;}

		LinkedList newLl=new LinkedList();
		Node tempNew=null;

		while(temp2!=null){
			sum=(temp1.data+temp2.data+carry)%10;
			carry=(temp1.data+temp2.data+carry)/10;
			Node nNode=newLl.new Node(sum);
			//if it is the head
			if (tempNew==null){
				newLl.head=nNode;
				tempNew=nNode;
			}
			else{
				tempNew.next=nNode;
				tempNew=tempNew.next;
			}
			temp1=temp1.next;
			temp2=temp2.next;
		}

		while(temp1!=null){
			sum=(temp1.data+carry)%10;
			Node nNode=newLl.new Node(sum);
			carry=(temp1.data+carry)/10;
			tempNew.next=nNode;
			tempNew=tempNew.next;
			temp1=temp1.next;
		}
		if(carry>0){
			Node nNode=newLl.new Node(carry);
			tempNew.next=nNode;
			tempNew=tempNew.next;
		}
		//reverse & print the new linked list
		newLl.printLinkedList();
		newLl.reverseLinkedList();
		newLl.printLinkedList();


	}
	/**Question 55
	 * Given a list, List1={1,2,3,4,5,6} with data, reorder it to {1,6,2,5,3,4}
	 *
	 */
	public static void question55(){
		LinkedList ll=new LinkedList();
		int elements=1;
		while(elements!=8){
			ll.insertNodeAtHead(elements);
			elements++;
		}
		ll.printLinkedList();

		if(ll.head==null || ll.head.next==null){
			System.out.println("The linked list is: ");
			ll.printLinkedList();
		}

		Node fastP=ll.head;
		Node slowP=ll.head;
		Node preSlowP=slowP;

		while(fastP.next!=null){
			preSlowP=slowP;
			fastP=fastP.next.next;
			slowP=slowP.next;
		}
		preSlowP.next=null;

		LinkedList reversedLinkedList=new LinkedList();
		reversedLinkedList.head=slowP;
		reversedLinkedList.printLinkedList();
		reversedLinkedList.reverseLinkedList();
		reversedLinkedList.printLinkedList();

		ll.printLinkedList();
		//check after here
		Node tempFirst=ll.head;
		Node tempSecond=reversedLinkedList.head;
		Node connectingTemp=ll.head;
		Node newHead=null;
		int k=1;

		while(tempFirst!=null && tempSecond!=null){
			if (k==1){
				newHead=ll.head;
			}
			if(k%2!=0){
				tempFirst=tempFirst.next;
				connectingTemp.next=tempSecond;
				connectingTemp=connectingTemp.next;
			}
			else{
				tempSecond=tempSecond.next;
				connectingTemp.next=tempFirst;
				connectingTemp=connectingTemp.next;

			}

			k++;
		}
		LinkedList newLl=new LinkedList();
		newLl.head=newHead;
		newLl.printLinkedList();
	}
	
	/**
	 * Given two sorted linked lists, given an algorithm 
	 * for the printing common
	 * elements of them
	 */
	public static void question56(){
		
	}

	/**
	 * Given a value k, reverse the linked list after every K elements.
	 */
	public static void question38(){
		LinkedList ll = new LinkedList();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		ll.createLinkeListsFromArray(arr);
		ll.printLinkedList();
		Node start = ll.head;
		Node startPrev = ll.head;
		int K = 2;
		if(K == 1){
			ll.printLinkedList();
			return;
		}
		while(start!=null){
			Node end = ll.findEnd(start, K);
			Node toLink = ll.reverseKElemenetsLinkedList(start, end);
			if(startPrev != start){
				startPrev.next = toLink;
			}
			else{
				ll.head = toLink;
			}
			startPrev = start;
			if(start!=null)
				start = start.next;
			//Node end = ll.reverseKElemenetsLinkedList(start, end);

		}
		ll.printLinkedList();

	}
	/**
	 * Test the function of reversing a linked list using recursion.
	 */
	public static void testReverseRec(){
		LinkedList ll = new LinkedList();
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		ll.createLinkeListsFromArray(arr);
		ll.printLinkedList();
		Node start = ll.head;
		Node rev=ll.reverseLlRecur(start);
		
		LinkedList llRev=new LinkedList();
		llRev.head=rev;
		System.out.println("The recursive linked list is: ");
		llRev.printLinkedList();
		
	}
	
	/**
	 * These are the solutions from the cracking the coding
	 * interview. I am doing them all now with the name
	 * CTCIprob21 ...prob21b ...prob22..
	 */
	
	/**
	 * Remove dups: Write code to remove duplicates from an 
	 * unsorted linked list.
	 */
	public static void CTCIprob21a(){
		LinkedList ll1=new LinkedList();
		int elements=50;
		while(elements!=39){
			ll1.insertNodeAtHead(elements);
			elements--;
		}
		ll1.insertNodeAtHead(42);
		ll1.printLinkedList();
		
		HashSet<Integer> setNode=new HashSet<>();
		
		Node temp=ll1.head;
		Node prev=temp;
		
		while(temp!=null){	
			if(!setNode.contains(temp.data)){
				setNode.add(temp.data);
			}
			else{
				prev.next=temp.next;
				}
			prev=temp;
			temp=temp.next;	
		}
		
		System.out.println("\nThe linked list after duplicates: ");
		ll1.printLinkedList();
	}
	/**
	 * Without temporary buffer
	 */
	public static void CTCIprob21b(){
		LinkedList ll1=new LinkedList();
		int elements=50;
		while(elements!=39){
			ll1.insertNodeAtHead(elements);
			elements--;
		}
		ll1.insertNodeAtHead(42);
		ll1.printLinkedList();
		
		Node temp1=ll1.head;
		Node temp2=ll1.head.next;
		Node prevTemp2=ll1.head;
		
		while(temp1.next!=null){
			while(temp2!=null){
				if(temp1.data==temp2.data){
					prevTemp2.next=temp2.next;
				}
				prevTemp2=temp2;
				temp2=temp2.next;
			}
			temp1=temp1.next;
			temp2=temp1.next;
			prevTemp2=temp1;
		}
		System.out.println("\nThe linked list after duplicates: ");
		ll1.printLinkedList();
	}
	
	/**
	 * Return the kth element from the back
	 */
	public static void CTCIprob22(int k){
		LinkedList ll1=new LinkedList();
		int elements=50;
		while(elements!=39){
			ll1.insertNodeAtHead(elements);
			elements--;
		}
		ll1.insertNodeAtHead(42);
		ll1.printLinkedList();
		if(k<1 || k>ll1.lengthOfLinkedList()){
			System.out.println("Wrong number!");
			return;
		}
		Node temp1=ll1.head;
		
		Node temp2=ll1.head;
		
		for(int i=0;i<k;i++){
			temp2=temp2.next;
		}
		while(temp2!=null){
			temp1=temp1.next;
			temp2=temp2.next;
		}
		System.out.println("The "+k+ "-th element is:  "+temp1.data);
	}
	/**
	 * Delete the middle node without having access to no node except that
	 */
	public static void CTCIprob23(){
		LinkedList ll1=new LinkedList();
		int elements=50;
		while(elements!=39){
			ll1.insertNodeAtHead(elements);
			elements--;
		}
		ll1.insertNodeAtHead(42);
		System.out.println("\nThe linked list before deleting: ");
		ll1.printLinkedList();
		
		Node temp=ll1.head.next.next.next.next.next.next;
		
		//delete temp (assuming is the middle node)
		
		temp.next.data=temp.data;
		temp.next=temp.next.next;
		ll1.printLinkedList();
	}
	
	/**
	 * Problem 2.4 Partition
	 */
	
	/**
	 * Sum lists (first the backward version) 
	 * e.g. 7+1+6 and 5+9+2 to 2+1+9
	 */
	public static void CTCIprob25(){
		LinkedList ll1=new LinkedList();
		int elements=1;
		while(elements!=8){
			ll1.insertNodeAtHead(elements);
			elements++;
		}
		ll1.printLinkedList();

		LinkedList ll2=new LinkedList();
		int elements2=9;
		while(elements2!=1){
			ll2.insertNodeAtHead(elements2);
			elements2--;
		}

		ll2.printLinkedList();
		
		Node temp1=ll1.head;
		Node temp2=ll2.head;
		LinkedList ll3=new LinkedList();
		Node temp3=ll3.head;
		int sum=0;
		int carry=0;
		int sumNew=0;
		while(temp1!=null && temp2!=null){
			sum=temp1.data+temp2.data+carry;
			carry=sum/10;
			sumNew=sum%10;
			
			Node newN=ll3.new Node(sumNew);
			if(temp3==null){
				ll3.head=newN;
				temp3=newN;
			}
			else{
			temp3.next=newN;
			temp3=temp3.next;}
			
			temp1=temp1.next;
			temp2=temp2.next;
		}
		while(temp1!=null){
			sum=temp1.data+carry;
			carry=sum/10;
			sumNew=sum%10;
			
			Node newNode=ll3.new Node(sumNew);
			
			temp3.next=newNode;
			temp3=temp3.next;
			temp1=temp1.next;
		}
		while(temp2!=null){
			sum=temp2.data+carry;
			carry=sum/10;
			sumNew=sum%10;
			
			Node newNode=ll3.new Node(sumNew);
			
			temp3.next=newNode;
			temp3=temp3.next;
			temp2=temp2.next;
		}
		ll3.printLinkedList();
	}
	/**
	 * Sum lists (the forward version) 
	 * e.g. 7+1+6 and 5+9+2 to 2+1+9
	 * Solution: Reverse the two linked list and use the above approach.
	 * Solution 2: USe a stack.
	 */
	
	/**
	 * Implement a function to check if a linked list is a palindrome.
	 */
	public static boolean CTCIprob26(){
		LinkedList ll1=new LinkedList();
		int elements=1;
		while(elements!=8){
			ll1.insertNodeAtHead(elements);
			elements++;
		}
		//to test for odd/even comment/uncomment the line below:
		ll1.insertNodeAtHead(4);
		int el=7;
		while(el!=0){
			ll1.insertNodeAtHead(el);
			el--;
		}
		ll1.printLinkedList();
		
		if(ll1.head.next==null || ll1.head==null) return true;
		
		Node fastP=ll1.head.next;
		Node slowP=ll1.head;
		Node preSlowP=null;
		
		while(fastP!=null && fastP.next!=null){
			preSlowP=slowP;
			if(slowP.next!=null){
			slowP=slowP.next;}
			if(fastP.next!=null){
			fastP=fastP.next.next;}
			
		}
		
		preSlowP.next=null;
		
		LinkedList ll2=new LinkedList();
		ll2.head=slowP;
		
		ll2.head=ll2.reverseLinkedList();
		
		Node temp2=ll2.head;
		Node temp1=ll1.head;
		
		while(temp1!=null && temp2!=null){
			if(temp1.data!=temp2.data){
				return false;
			}
			temp1=temp1.next;
			temp2=temp2.next;
		}
		
		return true;
	}
	/**
	 * FInd if two linked lists intersect 
	 * e.g. Node-> they intersect, null-> they don't intersect
	 */
	public static Node CTCIprob27(){
		LinkedList ll1=new LinkedList();
		LinkedList ll2=new LinkedList();
		int elements=1;
		while(elements!=8){
			if(elements>=5){
				ll2.insertNodeAtHead(elements);
			}
			ll1.insertNodeAtHead(elements);
			elements++;
		}
		ll1.printLinkedList();

		
		int elements2=9;
		while(elements2!=1){
			ll2.insertNodeAtHead(elements2);
			elements2--;
		}

		ll2.printLinkedList();
		
		HashSet<Node> set=new HashSet<Node>();
		
		Node temp1=ll1.head;
		while(temp1!=null){
			set.add(temp1);
			temp1=temp1.next;
		}
		
		Node temp2=ll2.head;
		
		while(temp2!=null){
			if(set.contains(temp2)){
				return temp2;
			}
			temp2=temp2.next;
		}
		return null;
		
		
	}
	/**
	 * Given a circular linked list, find the beginning of the loop.
	 */
	public static int CTCIprob28(){
		LinkedList ll1 = new LinkedList();

		ll1.insertNodeAtHead(100);
		//13->12->11->10->9->8->7->6->5->4->(100) temp

		Node temp = ll1.head;
		int elements=4;
		while(elements!=14){
			ll1.insertNodeAtHead(elements);
			if(elements == 8)
			{
				temp.next = ll1.head;
			}
			elements++;

		}
		//ll1.printLinkedList();
		Node slowP=ll1.head.next;
		Node fastP=slowP.next;
		while(slowP!=fastP){
			slowP=slowP.next;
			fastP=fastP.next.next;
		}
		fastP=ll1.head;
		while(fastP!=slowP){
			fastP=fastP.next;
			slowP=slowP.next;
		}
		return slowP.data;
	}
	
}



