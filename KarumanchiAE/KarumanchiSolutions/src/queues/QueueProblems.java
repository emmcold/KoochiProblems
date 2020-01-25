package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueProblems {
	/**
	 * Problem 1: Reverse a queue Q
	 * @param args
	 */
	private static Queue<String> reverseQueue(Queue<String> queue) {
		Stack<String> stack = new Stack<>();
		
		while(!queue.isEmpty()) {
			stack.push(queue.poll());
		}
		
		while(!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		
		return queue;
	}
	
	public static void main(String[] args){
		Queue<String> queue = new LinkedList<>();
		queue.offer("a");
		queue.offer("b");
		queue.offer("c");
		
		Queue<String> reverseQueue = new LinkedList<>();
		reverseQueue = reverseQueue(queue);
		printQueue(reverseQueue);
		
	}
	
	static private void printQueue(Queue<String> queue) {
		System.out.println("Queue printing: ----------------");
		
		while(!queue.isEmpty()) {
			System.out.print(queue.poll()+ "--");
		}
	}
}
