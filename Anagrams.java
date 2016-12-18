package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(checkAnagram("caghjkr", "kagjrch"));
		
		
		
String[] str = {"abc", "abelrt", "act", "aegt", "acb", "gorw", "cat"};
		
		String[] an = Anagram(str);
		for(String s:an)
		{	if(s!=null)
			System.out.println(s);
		}
		
		String[] strs={"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));
		
	}
	public static boolean checkAnagram(String str1, String str2)
	{
		char[] arr1 = str1.toLowerCase().toCharArray();
		char[] arr2 = str2.toLowerCase().toCharArray();
		if(arr1.length != arr2.length)
			return false;
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int[] arr = new int[26];
		
		for(int i=0; i<arr1.length;i++)
		{
			arr[arr1[i]-97]++;
			arr[arr2[i]-97]--;
		}
		for(int i=0; i< arr.length;i++)
		{
			if(arr[1]!=0)
				return false;
			
		}
		return true;
		
	}
	
	public static String[] Anagram(String[] str)
	{
		TreeMap<String, List<String>> tmap = new TreeMap<String, List<String>>();
		
		List<String> arr = new ArrayList<String>();
		
		String[] ans = new String[str.length];
		int index=0;
		for(int i=0;i<str.length;i++)
		{
			arr.add(str[i]);
		}
		Collections.sort(arr);
		
		for(String s:arr)
		{
			String sorted = sort(s);
			List<String> l = tmap.get(sorted);
			if(l == null)
			{
				tmap.put(sorted, l=new ArrayList<String>());
			}
			l.add(s);
			//ans[index] = s;
			//index++;
		}
		
//		System.out.println(tmap);
		

		
		List<String> ret = new ArrayList<String>();
		
		for(String s:tmap.keySet())
		{
			//System.out.println(tmap.get(s).size());
			if(tmap.get(s).size() > 1)
			{
				ans[index] = tmap.get(s).toString();
				index++;
			}

		}
		return ans;
		
	}

	public static String sort(String str)
	{
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}

	
	
	
	//49. Group Anagrams
	
	public static List<List<String>> groupAnagrams(String[] strs) 
	{
		 List<List<String>> result = new ArrayList<List<String>>();
		 
		 if(strs == null || strs.length == 0)
			 return result;
        Hashtable<String, List<String>> table = new Hashtable<String, List<String>>();
        for(String s:strs)
        {
        	String sorted = sort(s);
        	List<String> l = table.get(sorted);
        	if(l == null)
        		table.put(sorted, l=new ArrayList<String>());
        	l.add(s);
        }
        
       
        Set<String> keys = table.keySet();
        for(String key:keys)
        {
        	result.add(table.get(key));
        }
        return result;
    }
}
