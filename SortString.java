package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(frequencySort("Aabb"));
	}

	//451. LeetCode
	public static String frequencySort(String s) 
	{
		if(s==null)
			return null;
		Map<Character,Integer> hmap=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++)
		{
			char c = s.charAt(i);
			if(hmap.containsKey(c))
			{
				int count = hmap.get(c);
				hmap.put(c, count+=1);
			}
			else
				hmap.put(c, 1);
		}
		List<Map.Entry>list = new ArrayList<Map.Entry>(hmap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry>() 
		{
            public int compare(Map.Entry e1, Map.Entry e2) {
                Integer i1 = (Integer) e1.getValue();
                Integer i2 = (Integer) e2.getValue();
                return i2.compareTo(i1);
            }
        });
		System.out.println(list);
		StringBuilder sb = new StringBuilder();
		for(Map.Entry e:list)
		{
			int temp = (int) e.getValue();
			while(temp > 0)
			{
				sb.append(e.getKey());
				temp--;
			}
			
		}
		return sb.toString();
    }
}
