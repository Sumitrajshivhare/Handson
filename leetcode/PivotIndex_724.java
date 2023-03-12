package leetcode;

public class PivotIndex_724 {
	
	static int solve(int[] nums)
	{
		int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];

        suffix[nums.length -1] = nums[nums.length -1];
        for(int i = nums.length - 2; i >= 0; i--)
        {
            suffix[i] = nums[i] + suffix[i+1];
        }

        if(suffix[1] == 0)
         return 0;

        PrintArray.print(suffix);
         prefix[0] = nums[0];
         
         for(int i =1, j = nums.length - 1; i < nums.length -1; i++, j--)
         {
        	 System.out.println(prefix[i -1] + ", " + suffix[i+1] );
             if(prefix[i -1] == suffix[i+1])
                  return i;
             
             prefix[i] = nums[i] + prefix[i - 1];
         }
       if(prefix[nums.length -2] == 0)
    	   return nums.length -1;
         
         return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums[] = {-1,-1,0,1,1,0};
		
		System.out.println(solve(nums));

	}

}
