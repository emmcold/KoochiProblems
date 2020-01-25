package hashing;

import java.util.HashMap;

public class HashingKarumanchi {
	
	/**
	 * Given an array give an algorithm for removing the duplicates.
	 * @param array to check
	 */
	private static void problem1(int[] arr) {
		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			if(!hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], true);
			}
			else {
				arr[i] =Integer.MIN_VALUE;
			}
		}
	}
	public static void main(String[] args){
		// main program
		// Create an array
		int[] arr =  {1,2,3,3,4,2};
		printArray(arr);
		problem1(arr);
		
		printArray(arr);
		
	}
	
	private static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " - ");
		}
		System.out.println();
	}
}
