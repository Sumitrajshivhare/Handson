package leetcode;

public class FirstAndLastPos_34 {
	
	static int[] solve(int nums[], int target) {
		int ans[] = {-1,-1};
		
		int l1 = 0;
		int l2 = 0;
		int h1 = nums.length-1;
		int h2 = nums.length-1;
		
//		int mid1 = l1 + (h1 - l1)/2;
		
//		int mid2 = l2 + (h2 - l2)/2;
		
		int start = -1;
		int end = -1;
		
		while(l1 <= h1)
		{
			int mid1 = l1 + (h1 - l1)/2;
			if(nums[mid1] == target)
			{
				start = mid1;
				h1 = mid1 -1;
			}
			if(nums[mid1] < target )
			{
				l1 = mid1 + 1;
			}
			else
			{
				h1 = mid1 -1;
			}
			
			
		}
		
		while(l2 <= h2)
		{
			int mid2 = l2 + (h2 - l2)/2;
//			System.out.println(mid2);
			if(nums[mid2] == target)
			{
				end = mid2;
				l2 = mid2 + 1;
			}
			if(nums[mid2] > target)
			{
				h2 = mid2 -1 ;
			}
			else
			{
				l2 = mid2 + 1;
			}
		}
	
		
		ans[0] = start;
		ans[1] = end;
		
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,4};
		
		int target = 4;
		
		int [] res = solve(nums,target);
		System.out.println(res[0] + ", " + res[1]);
		
		int nums2[] = {5,7,7,8,8,10};
		int target1 = 6;
		res = solve(nums2,target1);
		System.out.println(res[0] + ", " + res[1]);
	}

}
