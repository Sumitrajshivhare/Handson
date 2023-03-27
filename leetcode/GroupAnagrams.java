package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	static HashMap<Character, Integer> createHashMap(String s)
	{
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++)
		{
			int val = 0;
			if(hm.containsKey(s.charAt(i)))
			{
				val = hm.get(s.charAt(i));
			}
			hm.put(s.charAt(i), val+1);
		}
		
		return hm;
	}
	
	static boolean isAnagram(String s1, String s2)
	{
		HashMap<Character, Integer> hm1 = createHashMap(s1);
		HashMap<Character, Integer> hm2 = createHashMap(s2);
		
//		System.out.println(hm1);
//		System.out.println(hm2);
		
		if(hm1.size() != hm2.size())
			return false;
		
		for(Map.Entry<Character, Integer> m : hm1.entrySet())
		{
			char key = m.getKey();
			int val = m.getValue();
			if(!hm2.containsKey(key) || hm2.get(key) != val)
				return false;
		}
		
		return true;
	}

	static List<List<String>> solve(String []strs)
	{
		List<List<String>> result = new ArrayList<>();
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0;  i < strs.length; i++)
		{
			List<String> r1 = new ArrayList<>();
			
			if(hs.contains(i))
				continue;
//			System.out.println(hs);
			r1.add(strs[i]);
			hs.add(i);
			for(int j = i + 1; j < strs.length; j++)
			{
				if(isAnagram(strs[i], strs[j]))
				{
//					r1.add(strs[i]);
					r1.add(strs[j]);
					hs.add(j);
				}
			}
			
			result.add(r1);
		}
		
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] strs = {"eat","tea","tan","ate","nat","bat"};
		
		System.out.println(solve(strs));
		
		String s[] = {"","b"};
//		System.out.println(solve(s));
		
		
	}

}
