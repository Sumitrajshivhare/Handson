package leetcode;

public class MaxCountPosNegNums {

	static int solve(int []nums)
	{
		int target =0;
		
		int l = 0;
		int h = nums.length - 1;
		
		int mid = l + (h-l)/2;
		
		int pos = 0;
		int neg = 0;
		
		while(l < h)
		{
			
			if(mid > 0 && mid < nums.length && nums[mid] > 0 && nums[mid - 1] <= 0)
			{
				pos = nums.length - mid;
			}
			 if(mid > 0 && mid < nums.length && nums[mid -1] < 0 && nums[mid] >= 0)
			{
				neg = mid;
			}
			
			if(nums[mid] > target)
				h = mid ;
			else
				l = mid + 1;
			
			mid = l + (h-l)/2;
			
		}
		
		System.out.println("neg = " + neg);
		
		if(pos == 0 && neg == 0)
			return nums.length;
		
		return pos > neg ? pos : neg;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {-2,-1,-1,1,2,3};
		
//		System.out.println(solve(nums));
//		
//		int nums2[] = {-1563,-236,-114,-55,427,447,687,752,1021,1636};
//		System.out.println(solve(nums2));
//		
//		int nums3[] = {5,20,66,1314};
//		System.out.println(solve(nums3));
		
		int nums4[] = {0,0,0,0,0,0,0,0,0};
		System.out.println(solve(nums4));
	}

}
