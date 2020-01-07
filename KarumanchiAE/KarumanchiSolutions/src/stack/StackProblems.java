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
	
	public static void main(String[] args){
		String string = "(A+B)-[C-D]";
		System.out.println("The string "+string+ "has balanced paranthesis: "
		+problem1(string));
		
	}
}
