package String;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		 String[] str = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		  
		 String digits = "23";
		 int num = digits.charAt(0) - '2';
		// System.out.println("num"+num);
		
		 System.out.println(letterCombinations2(digits));
		
	}
	
	 public static List<String> letterCombinations(String digits) 
	 {
		 if(digits == null)
			 return null;
		 String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        LinkedList<String> list = new LinkedList<>();
	        list.add("");
	        for (int i = 0; i < digits.length(); i++) 
	        {
	        	// get the number from letter array
	            int num = digits.charAt(i) - '2';
	           
	            int size = list.size();
	         
	            for (int k = 0; k < size; k++) 
	            {
	            	//pop item and add character from another group. Ex - pop 'a' and add 'd'- ad
	                String tmp = list.pop();
	                for (int j = 0; j < letters[num].length(); j++)
	                {
	                	//character is added
	                    list.add(tmp + letters[num].charAt(j));
	                  
	                }
	                
	            }
	        }
	        List<String> rec = new LinkedList<>();
	        rec.addAll(list);
	        return rec;
	 }

	 public static List<String> letterCombinations2(String digits) 
	 {
		 
		 List<String> result = new LinkedList<>();
		 HashMap<Character,String> hmap = new HashMap<Character,String>();
		 hmap.put('2',"abc");
		 hmap.put('3', "def");
		 hmap.put('4', "ghi");
		 hmap.put('5', "jkl");
		 hmap.put('6', "mno");
		 hmap.put('7', "pqrs");
		 hmap.put('8', "tuv");
		 hmap.put('9', "wxyz");
		 
		 StringBuffer sb = new StringBuffer();
		 helper(digits,0,sb,hmap,result);
		 return result;
	 }
	 
	 public static void helper(String digits,int steps,StringBuffer sb,HashMap<Character,String> hmap,List<String> result)
	 {
		 if(digits.length() == steps)
		 {
			 result.add(sb.toString());
			 return;
		 }
		 Character c = digits.charAt(steps);
		 String s = hmap.get(c);
		 for(int i=0;i<s.length();i++)
		 {
			
			 sb.append(s.charAt(i));
			 helper(digits, steps+1, sb, hmap, result);
			 sb.deleteCharAt(sb.length()-1);
		 }
	 }
	 
	 
	 
}
