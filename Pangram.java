package String;

import java.util.*;

public class Pangram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(checkPangram("Mr. Jock, TV quiz PhD, bags few lynx. Mr. Jock, TV quiz PhD, bags few lynx. Mr. Jock, TV quiz PhD, bags few lynx."));
		 
	
	}

	public static String checkPangram(String str)
	{
		char[] alphabets = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		char[] arr= str.toLowerCase().toCharArray();
		Set<Character> tree = new TreeSet<Character>();
		
		for(char c:arr)
		{
			tree.add(c);
		}
		
		StringBuffer buffer = new StringBuffer();
		
		for(char c:alphabets)
		{
			if(!tree.contains(c))
			{
				buffer.append(c);
			}
		}
		
		return buffer.toString();
	}
	
	
}
