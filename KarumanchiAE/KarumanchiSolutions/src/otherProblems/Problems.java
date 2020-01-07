package otherProblems;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Objects;

public class Problems {
	
	private static int printCumulativeSum(int n){
        if(n==0) return 0;
        int sum=printCumulativeSum(n-1)+n;
        System.out.println(sum);
        return sum;
    }
	
	private static int factorial(int n){
		if(n==0) 
			return 1;
			
		return n*factorial(n-1);
		
	}
	
	void sort(int[] arr, int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			sort(arr, l, m);
			sort(arr,m+1,r);
			
			mergeSort(arr, l, m, r);
			}
	}
	
	private void mergeSort(int[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
		int n1 = m-l+1;
		int n2 = r-m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int i = 0; i<n1; i++) {
			L[i] = arr[l+1];
		}
		for(int j=0; j<n2; j++) {
			R[j] = arr[m+l+j];
		}
		
		int i = 0, j = 0;
		int k = l;
		
		while(i<n1 && j<n2) {
			
		}
	}
	/**
	 * Problem 18 Maximum number of times a number appears in an array.
	 * 
	 * @param args
	 */
	
	private static int problem18 (int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i=0; i<arr.length; i++) {
			Integer key = map.get(arr[i]);
			if(key!=null) {
			map.put(arr[i], ++key);}
			else {
				map.put(arr[i],1);
			}
		}
		
		int max = 0;
		int maxValue = 0;
		
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if(max<entry.getValue()) {
				max = entry.getValue();
				maxValue = entry.getKey();
			}
	    }		
		return maxValue;
	}
	
	private static int[] mergeProblem_33(int[] a, int[] b) {
		int[] aClone = new int[a.length+b.length];
		aClone = a.clone();
		
		int aLength = a.length;
		int bLength = b.length;
		
		while(aLength >= 0) {
			if(a[aLength]> b[bLength]) {
				aClone[aLength + bLength - 1] = a[--aLength];
			}
			else {
				aClone[aLength + bLength - 1] = b[--bLength];
			}
		}
		return aClone;
	}
	
	public static void main(String[] args){
		int arr[] = {2, 4, 1, 3,2, 5,4 , 4, 4};
		String arrString = "2 4 6 8 10 13 14";
		String arrString2 = "8 10 15 18 19";
		
		int[] numbers = Arrays.stream(arrString.split(" ")).mapToInt(Integer::parseInt).toArray();  
		

		System.out.println("Given Array"); 
		int s=printCumulativeSum(14);
		System.out.println("The cumulative sum for n=14 is: "+s);
		int f=factorial(3);
		System.out.println("\nThe factorial for n=5 is: "+f);
		
		System.out.println("The maximum number of times appears this number: "+ problem18(arr));
		
		System.out.println("The new array is: ");
	}
}
