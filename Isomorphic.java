package String;

import java.util.*;

public class Isomorphic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		System.out.println(isIsomorphic("foo","bar")); // false
		System.out.println(isIsomorphic("abcd","aabd")); // false
		System.out.println(isIsomorphic("abcabc","xyxxyz")); // true
		System.out.println(isIsomorphic("add","egg")); // true
	}
	public static boolean isIsomorphic(String input1, String input2) {
		  // Write your code below this line. Do not modify any other part of the code.
		  
		    if (input1 == null || input2 == null || input1.length() != input2.length()) 
		    	return false;
		    
		    int charcount = 0;
		    HashMap<Character, Integer> h1 = new HashMap<>();
		    HashMap<Character, Integer> h2 = new HashMap<>();

		    for (int i = 0; i < input1.length(); i++) {
		        Character c1 = input1.charAt(i);
		        Character c2 = input2.charAt(i);
		        
		        if (h1.get(c1) != h2.get(c2)) return false;
		        if (h1.get(c1) == null) {
		            h1.put(c1, charcount);
		            h2.put(c2, charcount);
		            charcount++;
		        }
		    }
		    
		    return true;

		 
		}
	
	public static boolean isIsomorphic1(String input1, String input2) {
	    
	    
        if(input1.length() != input2.length())
            return false;
        HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();
        
        int count;
        for(int i=0;i<input1.length();i++)
        {
            if(map1.containsKey(input1.charAt(i)))
            {
                count = map1.get(input1.charAt(i));
                map1.put(input1.charAt(i),count++);
            }
            else
                map1.put(input1.charAt(i),1);
        }
        
        for(int i=0;i<input2.length();i++)
        {
            if(map2.containsKey(input2.charAt(i)))
            {
                count = map2.get(input2.charAt(i));
                map2.put(input2.charAt(i),count++);
            }
            else
                map2.put(input2.charAt(i),1);
        }
        
    
        if(map1.size() != map2.size())
            return false;
       Iterator it1 = map1.entrySet().iterator();
       
       Iterator it2 = map2.entrySet().iterator();
       
       while(it1.hasNext() && it2.hasNext())
       {
           Map.Entry c1 = (Map.Entry)it1.next();
           Map.Entry c2 = (Map.Entry)it2.next();
           if(c1.getValue() != c2.getValue())
            return false;
       }
       
       return true;
      

}
	
}