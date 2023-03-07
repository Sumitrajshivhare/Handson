package leetcode;

public class BinarySearch_704 {
	
	static int solve(int []nums, int target)
	{
	
		int l = 0;
		int h = nums.length - 1;
		
		int mid = l + (h-l)/2;
		
		while(l < h)
		{
			if(nums[mid] == target)
				return mid;
			
			if(nums[mid] > target)
				h = mid ;
			else
				l = mid + 1;
			
			mid = l + (h-l)/2;
			
		}
		
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nums[] = {-1,0,3,5,9,12};
		
		int target1 = 9;
		
		
		int target2 = 4;
		
		System.out.println(solve(nums,target1));
		System.out.println(solve(nums,target2));
		
		
	}

}
