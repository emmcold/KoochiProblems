package otherProblems;

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
	public static void main(String[] args){
		int s=printCumulativeSum(14);
		System.out.println("The cumulative sum for n=14 is: "+s);
		int f=factorial(3);
		System.out.println("\nThe factorial for n=5 is: "+f);
	}
}
