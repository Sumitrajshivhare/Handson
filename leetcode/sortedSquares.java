package leetcode;

public class sortedSquares {
	
	
	public static int[] solve(int [] nums)
	{
	
		int res[] = new int[nums.length];
		
		int l = 0;
		int r = nums.length -1;
		
		int idx = nums.length -1;
		
		while(l <= r)
		{
			
			int a = nums[l] * nums[l];
			
			int b = nums[r] * nums[r];
			
			if(a < b)
			{
				res[idx] = b;
				idx--;
				r--;
			}
			else
			{
				res[idx] = a;
				idx--;
				l++;
			}
			
			
		}
		
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-4,-1,0,3,10};
		PrintArray.print(solve(nums));
	}

}
