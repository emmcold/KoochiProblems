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
	/**
	 * Finding of spans
	 * @param args
	 */
	
	static int[] findingOfSpans(int[] stockPrice, int n) {
		
		int[] span = new int[n];
		// The span value in the first day is always 1.
		span[0] = 1;
		
		for(int i=1; i<stockPrice.length; i++) {
			span[i] =1;
			
			for(int j=i-1; (j>=0) && (stockPrice[j]<=stockPrice[i]); j-- ) {
				span[i]++;
			}
		}
		
		return span;
	}
	
	/**
	 * Implementation of the span of stocks with stack.
	 * @param args
	 */
	 // A stack based efficient method to calculate 
    // stock span values 
    static void calculateSpan(int stockPrice[], int n) 
    { 
    	int[] spans = new int[n];
        // Create a stack and push index of first element 
        // to it 
        Stack<Integer> st = new Stack<>(); 
        int previous = 0;
        for(int i=0; i<stockPrice.length; i++) {
        	while(!st.isEmpty() && stockPrice[i]>= stockPrice[(Integer) st.peek()]) {
        		st.pop();
        	}
        	
        	if(st.isEmpty()) {
        		previous =-1;
        	}
        	else {
        		previous = (Integer) st.peek();
        	}
        	spans[i] = i -previous;
        	st.push(i);
        }
              
    } 
    
    private static int largestRectangleArea(int[] arr) {
    	// stack for storing the indexes
    	Stack<Integer> stack = new Stack<>();
    	stack.push(-1);
    	
    	int maxArea = 0;
    	
    	for(int i=0; i<arr.length; i++) {
    		int currentBarHeight = arr[i];
    		
    		while(stack.peek()!= -1 && currentBarHeight <= arr[stack.peek()]) {
    			int height = arr[stack.pop()];
    			int width = i-stack.peek()-1;
    			int area = height * width;
    			
    			if(area> maxArea) {
    				maxArea = area;
    			}
    		}
    		stack.push(i);
    	}
    	
    	while(stack.peek() != -1) {
    		int height = arr[stack.pop()];
    		int width = arr.length - stack.peek() - 1;
    		int area = height * width;
    		if(area> maxArea) {
    			maxArea = area;
    		}
    	}
    	return maxArea;
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
		
		int[] arr = new int [7];
		arr[0] = 100;
		arr[1] = 80;
		arr[2] = 60;
		arr[3] = 70;
		arr[4] = 60;
		arr[5] = 75;
		arr[6] = 85;
		
		int[] spanArr = findingOfSpans(arr, 7);
		System.out.println("\nThe span: ");
		for(int i=0; i<spanArr.length; i++) {
			System.out.print(spanArr[i]+ " ");
		}
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
