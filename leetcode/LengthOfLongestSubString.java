package handsone2.leetcode;

import java.util.HashMap;

public class LengthOfLongestSubString {
	
	
	static int solve(String s)
	{
		int ans = 0;
		
		HashMap<Character, Integer> hm =  new HashMap<>();
		
		String temp = "";
		
		for(int i = 0; i < s.length(); i++)
		{
			if(hm.containsKey(s.charAt(i)))
			{
				if(ans < temp.length())
					ans = temp.length();
				
				int idx = hm.get(s.charAt(i));
				i = idx + 1;
				
				temp = "";
				hm.clear();
			}
			
			hm.put(s.charAt(i), i);
			temp += s.charAt(i);
		}
		
		if(ans < temp.length())
			ans = temp.length();
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcaxebcbb";
		
		System.out.println(solve(s));

	}

}
