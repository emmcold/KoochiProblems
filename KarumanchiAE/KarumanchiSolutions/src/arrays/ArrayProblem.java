package arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ArrayProblem {
	/**
	 * Find if in two arrays there is a pair with sum to k
	 * solution O(n)
	 */
	static boolean isThereK(int[] arr1, int[] arr2, int k) {
		HashMap<Integer, Boolean> hashMap = new HashMap<>();
		
		for(int i=0; i<arr1.length; i++) {
			hashMap.put(arr1[i], true);
		}
		
		for(int j=0; j<arr2.length; j++) {
			//look-up in hashmap is O(1)
			int element = k-arr2[j];
			if (hashMap.get(element) != null) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Find if in two arrays there is a pair with sum to k
	 * Solution O(n logn)
	 */
	static boolean isThereKVersion2(int[] arr1, int[] arr2, int k) {
		Arrays.sort(arr2);
		
		for(int i=0; i<arr1.length; i++) {
			int el = k-arr1[i];
			//O(logn)
			int index = Arrays.binarySearch(arr2, el);
			if(index>=0) {
				return true;
			}
		}
		
		return false;
	}
	/**
	 * Given an array of positive integers. 
	 * The task is to find inversion count of array.
	 * @param args
	 */
	
	static long inversionCount(int[] arr, int left, int right) {
		if(left<right) {
			int mid = left +((right-left)/2);
			
			long leftInversion = inversionCount(arr, left, mid);
			long rightInversion = inversionCount(arr, mid+1, right);
			
			long inversionMerge = inversionMerge(arr, left, right, mid);
			
			return leftInversion+rightInversion + inversionMerge;
		}
		return 0;
	}
	private static long inversionMerge(int[] arr, int left, int right, int mid) {
		int[] L = new int[mid-left+1];
		int[] R= new int[right-mid];
		// populate the arrays
		for(int i=0; i<L.length; i++) {
			L[i] = arr[i+left];
		}
		for(int j=0; j<R.length; j++) {
			R[j] = arr[mid+j+1];
		}
		
		int x=left;
		int leftIndex = 0;
		int rightIndex = 0;
		int count = 0;
		
		while(x<= right && leftIndex<L.length && rightIndex < R.length) {
			if(L[leftIndex]<=R[rightIndex]) {
				arr[x] = L[leftIndex];
				x++;
				leftIndex++;	
			}
			else {
				arr[x] = R[rightIndex];
				x++;
				rightIndex++;
				count += L.length - leftIndex;
			}
		}
		
		while(leftIndex<L.length) {
			arr[x] = L[leftIndex];
			leftIndex++;
			x++;
		}
		
		while(rightIndex<R.length) {
			arr[x] = R[rightIndex];
			rightIndex++;
			x++;
		}
		
		return count;
	}
	/**
	 * Problem 10) Karumanchi
	 * Given three arrays, find if a+b+c = k
	 * @param args
	 */
	// Same as above
	/**
	 * Count sort for 0s 1s and 2s
	 * @param args
	 */
	static void sortCount(int[] arr) {
		//Create a reference point array of size 3
		//where indexes are 0-> number 0, 1-> number 1 and
		// index 2 -> number 2
		int[] referenceArr = new int[3];
		
		for(int i=0; i<arr.length; i++) {
			referenceArr[arr[i]]++;
		}
		
		int leftIndexArr= 0;
		
		for(int i = 0; i<referenceArr.length; i++) {
			for(int j = 0; j<referenceArr[i]; j++) {
				arr[leftIndexArr++] = i;
			}
		}	
			
	}
	
	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = {2, 4, 1, 3, 5};
		int arr2[] = {3,10, 23, 5, 6,7};
		String arrString = "1 0 0 0 2 1 1 2 1 0";
		
		int[] numbers = Arrays.stream(arrString.split(" ")).mapToInt(Integer::parseInt).toArray();  
		
		int[] countArrEx = {2,2,4,1,3,5};
		System.out.println("Given Array"); 
		printArray(arr); 
		
		System.out.println("Is there a k: "+isThereK(arr, arr2, 5));
		
		System.out.println("Inversion count: "+inversionCount(countArrEx, 0, countArrEx.length-1));
		System.out.println("Before sorting array of 0s 1s and 2s: ");
		printArray(numbers);
		System.out.println("After sorting array of 0s 1s and 2s: ");
		sortCount(numbers);
		printArray(numbers);
	} 
	
	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 
}
