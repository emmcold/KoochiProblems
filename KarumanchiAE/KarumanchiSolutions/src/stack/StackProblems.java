package stack;


import java.util.Stack;



public class StackProblems {
	/**
	 * Find if a string has balanced parenthesis.
	 */
	static boolean problem1 (String s) {
		if(s == null || s.isEmpty() == true) {
			return true;
		}
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == ']') {
				if(!stack.isEmpty() && stack.peek() =='[') {
					stack.pop();
				}
				else
					return false;
			}
			else if(s.charAt(i) == '}') {
				if(!stack.isEmpty() && stack.peek() == '{') {
					stack.pop();
				}
				else
					return false;
			}
			else if(s.charAt(i) == ')') {
				if(!stack.isEmpty() && stack.peek() == '(') {
					stack.pop();
				}
				else
					return false;
			}
			else if(s.charAt(i) == '[' || s.charAt(i) == '{' || s.charAt(i)== '('){
				stack.push(s.charAt(i));
			}
		}
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
	/**
	 * Design a stack such that the getMinimum is O(1)
	 * @param args
	 */
	private static int getMinimum(Stack<Integer> mainStack) {
		Stack<Integer> minStack = new Stack<>();
		minStack.push(mainStack.pop());
		
		while(!mainStack.isEmpty()) {
			if(minStack.peek()> mainStack.peek()) {
					minStack.push(mainStack.pop());
			}
			else {
				mainStack.pop();
			}
		}
		return minStack.pop();
	}
	
	/**
	 * Find if a string is palindrome or not using stack
	 * @param args
	 */
	private static boolean isPalindrome(String string) {
		//Stack<Character> stack = new Stack<>();
		CharStack stack = new CharStack();
		int index = 0;
		
		while(string.charAt(index)!='X') {
			stack.push(new Character(string.charAt(index)));
			index ++;
		}
		index++;
		while(index < string.length()) {
			if(new Character(string.charAt(index)) != stack.pop()) {
				return false;
			}
		}
		
		if(stack.isEmpty()) {
			return true;
		}
		return false;
	}
	/**
	 * Find if a string is palindrome or not using linked list
	 * @param args
	 * Reverse the second half of the string and then compare first half with second.
	 * if they are equal, it's a palindrome, if not. it is not.
	 * It needs to change the definition of LinkedList to hold char instead of int
	 */
	//TODO do this later
	
	/**
	 * Given a stack, how to reverse the content of the stack using only
	 * stack operation push and pop/
	 * @param args
	 */
	private static void reverseStack(Stack<Integer> s) {
		if(s.isEmpty()) {
			return;
		}
		Integer element = s.pop();
		reverseStack(s);
		pushElementInStackBottom(s, element);
	}
	
	private static void pushElementInStackBottom(Stack<Integer> stack, Integer i) {
		if(stack.isEmpty()) {
			stack.push(i);
			return;
		}
		int temp = stack.pop();
		pushElementInStackBottom(stack, i);
		stack.push(temp);
	}
	
	public static void main(String[] args){
		String string = "(A+B)-[C-D]";
		System.out.println("The string "+string+ "has balanced paranthesis: "
		+problem1(string));
		
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(3);
		stack.push(1);
		stack.push(15);
		stack.push(16);
		System.out.println("Finding the min: "+ getMinimum(stack));
		
		//Testing problem with palindrome
		
		String palindromeTest = "abaXaba";
		System.out.println("The following string is a palindrome: " 
		+ isPalindrome(palindromeTest));
		System.out.println("The stack before reverse: ");
		printStack(stack);
		
		System.out.println("Reverse stack: "); 
		reverseStack(stack);
		printStack(stack);
		
	}
	
	static void printStack(Stack<Integer> s) {
		Stack<Integer> tempStack = new Stack<>();
		
		while(!s.isEmpty()) {
			tempStack.push(s.pop());
		}
		
		while(!tempStack.isEmpty()) {
			System.out.print(tempStack.peek().intValue()+ "-");
			s.push(tempStack.pop());
		}
	}
}
