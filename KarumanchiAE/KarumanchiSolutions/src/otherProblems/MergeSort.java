package otherProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

class MergeSort 
{ 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(int arr[], int l, int m, int r) 
	{ 
		// Find sizes of two subarrays to be merged 
		int n1 = m - l + 1; 
		int n2 = r - m; 

		/* Create temp arrays */
		int L[] = new int [n1]; 
		int R[] = new int [n2]; 

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i) 
			L[i] = arr[l + i]; 
		for (int j=0; j<n2; ++j) 
			R[j] = arr[m + 1+ j]; 


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays 
		int i = 0, j = 0; 

		// Initial index of merged subarry array 
		int k = l; 
		while (i < n1 && j < n2) 
		{ 
			if (L[i] <= R[j]) 
			{ 
				arr[k] = L[i]; 
				i++; 
			} 
			else
			{ 
				arr[k] = R[j]; 
				j++; 
			} 
			k++; 
		} 

		/* Copy remaining elements of L[] if any */
		while (i < n1) 
		{ 
			arr[k] = L[i]; 
			i++; 
			k++; 
		} 

		/* Copy remaining elements of R[] if any */
		while (j < n2) 
		{ 
			arr[k] = R[j]; 
			j++; 
			k++; 
		} 
	} 

	// Main function that sorts arr[l..r] using 
	// merge() 
	void sort(int arr[], int l, int r) 
	{ 
		if (l < r) 
		{ 
			// Find the middle point 
			int m = (l+r)/2; 

			// Sort first and second halves 
			sort(arr, l, m); 
			sort(arr , m+1, r); 

			// Merge the sorted halves 
			merge(arr, l, m, r); 
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i=0; i<n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 
	
	private static int problem1(int[] arr) {
		Arrays.sort(arr);
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i]+1 != arr[i+1]) {
				return arr[i]+1;
			}
		}
		return Integer.MIN_VALUE;
	}
	
	private static int problem1fasterVersion(int[] arr) {
		if(arr[0]!=1) {
			return 1;
		}
		
		for(int i=0; i<arr.length; i++) {
			if(i != arr[i]-1) {
				return i+1;
			}
		}
		return Integer.MIN_VALUE;
	}
	//TODO fix this problem
	private static int count(int[] arr) {
		// copy the array
		int[] arrCopy = new int[arr.length];
		for (int i=0; i<arr.length; i++) {
			arrCopy[i] = arr[i];
		}
		
		Arrays.sort(arrCopy);
		int count = 0;
		HashMap<Integer, Integer> countDuplicateKey = new HashMap<>();
		
		for(int i=0; i< arr.length; i++) {
			int key = Arrays.binarySearch(arrCopy, arr[i]);	
			if(!countDuplicateKey.containsKey(key)) {
				countDuplicateKey.put(key, 1);
			}
			else{
				countDuplicateKey.put(key, countDuplicateKey.get(key)+1);
				key --;
			}
			if(i<key) {
				count+= (key-i);
			}
			else if(arr[i]> arr[key]) {
				count+= key;
			}
		}
		return count;
		
	}
	
	//k-th smallest element
	private static int smallestEl(int[] arr, int k) {
		
		TreeMap<Integer, Boolean> treeMap = new TreeMap<>();
		
		for(int i=0; i<arr.length; i++) {
			treeMap.put(arr[i], true);
		}
		
		int i=0;
		while(i!=k-1) {
			treeMap.pollFirstEntry();
			i++;
		}
		Entry<Integer, Boolean> kEntry= treeMap.pollFirstEntry();
		
		return kEntry.getKey();
	}
	//k-th smallest element using quick sort
	// l=0, r=arr.length-1 
	public int kthSmallest(int []a, int l, int r, int k) {
		while(l <= r) {
			int mid = partition(a, l, r);
			
			if(mid == k-1)
				return a[mid];
			else if(mid > k-1)
				r = mid - 1;
			else
				l = mid + 1;
		}
		
		return -1;
	}

	private int partition(int[]a, int l, int r) {
		
		int pivot = a[r];
		int i = l-1;
		
		for(int j = l;j < r;j++) {
			if(a[j] <= pivot)
				swap(a, ++i, j);
		}
		
		swap(a, ++i, r);
		return i;	
	}

	void swap(int []a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = {2, 4, 1, 3,2, 5};
		String arrString = "468 335 1 170 225 479 359 463 465 206 146 282 328 462 492 496 443 328 437 392 105 403 154 293 383 422 217 219 396 448 227 272 39 370 413 168 300 36 395 204 312 323";
		
		int[] numbers = Arrays.stream(arrString.split(" ")).mapToInt(Integer::parseInt).toArray();  
		int arr2[] = {10, 2, 6, 2, 4, 1};
		int arr3[] = {7, 10, 4, 3, 20, 15};
		

		System.out.println("Given Array"); 
		printArray(arr); 

		//MergeSort ob = new MergeSort(); 
		//ob.sort(arr, 0, arr.length-1); 

		System.out.println("\nSorted array"); 
		printArray(arr); 
		
		System.out.println("\nProblem with missing number");
		printArray(arr2);
		
		System.out.println("The missing number is: "+problem1fasterVersion(arr2));
		System.out.println("The count is: "+ count(numbers));
		System.out.println("The "+ 3+"-th smallest element is: "+ smallestEl(arr3, 3));
	} 
} 
