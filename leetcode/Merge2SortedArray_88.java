package leetcode;

public class Merge2SortedArray_88 {

	public static void solve(int[] nums1, int m, int[] nums2, int n)
	{
		int i = 0;
		int j = 0;
		int temp[] = new int[m];
		int idx = 0;
		
		for(int k =0; k < m ; k++)
		{
			temp[k] = nums1[k];
		}
		
		while(i < m && j < n)
		{
			if(temp[i] <= nums2[j])
			{
				nums1[idx] = temp[i];
				i++;
				idx++;
			}
			else
			{
				nums1[idx] = nums2[j];
				j++;
				idx++;
			}
		}
		
		while(i < m)
		{
			nums1[idx] = temp[i];
			i++;
			idx++;
		}
		
		while(j < n)
		{
			nums1[idx] = nums2[j];
			j++;
			idx++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int nums1[] = {1,2,3,0,0,0};
		int nums2[] = {2,5,6};
		
		int m = 3;
		int n = 3;
		
		solve(nums1,m,nums2,n);
		
		PrintArray.print(nums1);

	}

}
