package geeks4geeks;

import java.util.Arrays;

public class ArraysMostDoQuestions {
	
	/**
	 * Quick sort algorithm
	 * @param args
	 */
	
	static void quickSort(int[] arr, int leftIndex, int rightIndex) {
		if(leftIndex<rightIndex) {
			int p = partition(arr, leftIndex, rightIndex);
			
			quickSort(arr, leftIndex, p-1);
			quickSort(arr, p+1, rightIndex);
		}
	}
	
	static int partition(int[] arr, int leftIndex, int rightIndex) {
		int partitionIndex = leftIndex;
		int pivot = arr[rightIndex];
		
		for(int i=leftIndex; i<=rightIndex; i++) {
			if(arr[i]<pivot) {
				swap(arr, i, partitionIndex);
				partitionIndex++;
			}
		}
		swap(arr, partitionIndex, rightIndex);
		return partitionIndex;
	}
	
	static void swap(int[] arr, int leftIndex, int rightIndex) {
		int temp = arr[leftIndex];
		arr[leftIndex] = arr[rightIndex];
		arr[rightIndex] = temp;
	}
	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = {2, 4, 1, 3,2, 5};
		String arrString = "468 335 1 170 225 479 359 463 465 206 146 282 328 462 492 496 443 328 437 392 105 403 154 293 383 422 217 219 396 448 227 272 39 370 413 168 300 36 395 204 312 323";
		
		int[] numbers = Arrays.stream(arrString.split(" ")).mapToInt(Integer::parseInt).toArray();  
		

		System.out.println("Given Array"); 
		printArray(arr); 
		quickSort(arr, 0, arr.length-1);
		System.out.println("\nSorted array"); 
		printArray(arr); 
		
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
