package test;

import java.util.HashSet;
import java.util.Stack;

import leetcode.PrintArray;

public class maxPartitions {
	
	 static int findPartitions(int A[], int n)
	    {
	        int ans = 0, cnt = 0,max =0;
	        for (int i = 0; i < n; ++i) {
	 
	          
	        	max = Math.max(max, A[i]);
	 
	         
	            if (cnt == i)
	                ans++;
	        }
	        return ans;
	    }
	 
	 static int solve(int[] A)
	 {
		 int prefixMax[] =  new int[A.length];
		 int max = Integer.MIN_VALUE;
		 int cnt =0;
		 for(int i =0; i < A.length; i++)
		 {
			 if(A[i] > max)
			 {
				 max = A[i];
				 prefixMax[i] = A[i];
//				 cnt++;
			 }
			 else
				 prefixMax[i] = max;
		 }
		 
		 PrintArray.print(prefixMax);
		 HashSet<Integer> hs = new HashSet<>();
		for(int i =0; i < prefixMax.length; i++)
		{
			hs.add(prefixMax[i]);
		}
		
		 
		 return hs.size();
	 }
	 
	 static int solveUsingStack(int[] A)
	 {
		 int max = A[0];
		 int cnt = 0;
		 
		 Stack<Integer> stack = new Stack<>();
		 
		 for(int i = 1; i < A.length; i++)
		 {
			 if(A[i] < max)
			 {
				 max = A[i];
				 if(stack.size() > 0)
				 {
					 if(stack.peek() > max)
					 {
						 stack.pop();
						
					 }
					 
				 }
				 stack.add(max);
			 }
		 }
		 System.out.println(stack);
		 cnt = stack.size();
		 return cnt;
	 }
	 
	 static int solve_2(int[]A)
	 {
		int ans = 0;
		
		int prefixMax[] =  new int[A.length];
		int suffixMin[] = new int[A.length];
		
		int max = A[0];
		for(int i =0; i < A.length; i++)
		{
			max = Math.max(max, A[i]);
			prefixMax[i] = max;
		}
		
		
		int min = A[A.length -1];
		for(int i = A.length - 1; i >= 0; i--)
		{
			min = Math.min(max, A[i]);
			suffixMin[i] = min;
		}
		
		PrintArray.print(A);
		PrintArray.print(prefixMax);
		PrintArray.print(suffixMin);
		
		for(int i = 0 ; i < A.length - 1; i++)
		{
			if(prefixMax[i] <= suffixMin[i + 1])
				ans++;
		}
		
		 return ans;
	 }
	 
	 static int solve_3(int[] A)
	 {
		 int cnt = 0;
		 
		 int premax[] = new int[A.length];
		 int sufmin[] = new int[A.length];
		 int max = A[0]; int min = A[A.length -1];
		 premax[0] = max; sufmin[A.length -1] = min; 
		 
		 for(int i = 1; i < A.length ; i++)
		 {
			 max =  Math.max(max, A[i]);
			 premax[i] = max;
		 }
		 
		 for(int i = A.length -2 ; i >= 0; i--)
		 {
			 min = Math.min(min, A[i]);
			 sufmin[i] =  min;
		 }
		 
		 PrintArray.print(A);
		 PrintArray.print(premax);
		 PrintArray.print(sufmin);
		 
		 HashSet<Integer> hs = new HashSet<>();
		 HashSet<Integer> hsmin = new HashSet<>();
		 for(int i = 0; i < A.length; i++)
		 {
//			 if(premax[i] < premax[i + 1] && sufmin[i] < sufmin[i + 1])
			 {
				 hs.add(premax[i]);
				 hsmin.add(sufmin[i]);
			 }
				 
		 }
		 
		 cnt =Math.min(hs.size(), hsmin.size()) ;
		 return cnt ;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int A[] = { 2, 1, 6, 4, 3, 7};
//		int A[] = { 2, 1, 4, 3, 6, 5};
//		int A[] = { 2, 1, 4, 3, 5, 6};
		int A[] = { 2, 4, 3, 5, 1, 6};
        int n = A.length;
//        System.out.println(findPartitions(A, n));
//        System.out.println(solve(A));
//        System.out.println(solveUsingStack(A));
        System.out.println(solve_3(A));
	}

}
