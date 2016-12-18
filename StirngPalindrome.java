package String;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StirngPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
//		System.out.println(isStringPalindrome("madam"));
//		
//		System.out.println(firstNonRepeatedCharacter("abab"));
//		String str = "ababc";
//		System.out.println(str.indexOf('c')+" "+str.lastIndexOf('c'));
//		
//		int[][]arr = {{1,2,3},{3,2,1}};
//		System.out.println(" len"+arr[0].length);
//		
		
		
	}

	public static boolean isStringPalindrome(String str){
	    
	    if(str == null)
	        return false;
	    
//	    char[] arr = str.toCharArray();
//	    int i1 = 0;
//	    int i2 = str.length() - 1;
//	    while(i2>i1)
//	    {
//	        if(arr[i2] != arr[i1])
//	            return false;
//	            
//	        i2--;
//	        i1++;
//	        
//	        
//	    }
//	    return true;

	    int length = str.length();
	    for(int i=0;i<str.length()/2;i++)
	    {
	        length--;
	        if(str.charAt(i) != str.charAt(length))
	            return false;
	    }

	return true;

	}
	
	
	
	public static Character firstNonRepeatedCharacter(String str) {
	    // Add your code below this line. Do not modify any other code.

	    for (char c : str.toCharArray()) {
	        if (str.indexOf(c) == str.lastIndexOf(c)) {
	            return c;
	        }
	    }

	    return null;


	    // Add your code above this line. Do not modify any other code.
	}
}
