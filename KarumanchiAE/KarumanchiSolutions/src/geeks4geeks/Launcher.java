package geeks4geeks;



public class Launcher {
	public static void main(String[] args){
		int[] arr = {2,3,4,5,7,6,2};
		
		LinkedList l = new LinkedList();
		
		l.createLinkeListsFromArray(arr);
		
		Questions q = new Questions();
		System.out.println("The number of nodes in linked list is: "+q.p_1(l.head));
	
		int[] arr2 = {3,2,5,6,5,7,-1};
		
		LinkedList l2 = new LinkedList();
		l2.createLinkeListsFromArray(arr2);
		
		System.out.println("The number of sum of pairs: "+q.p_2_2(l.head, l2.head, 5));
		
		LinkedList unionLinkedList = q.p_5(l.head, l2.head);
		
		unionLinkedList.printLinkedList();
	
	}
}
