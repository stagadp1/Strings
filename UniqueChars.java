package String;
import java.util.*;
public class UniqueChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		
	}

	public static boolean areAllCharactersUnique(String str){
	    if(str == null) return true;
	    HashSet<Character> hs = new HashSet<Character>();
	    for(int i = 0; i < str.length(); i++) {
	        if(!hs.add(str.charAt(i))) {
	            return false;
	        }
	    }
	    return true;
	}
	public static boolean areAllCharactersUnique1(String str){
	    
	    if(str == null)
	        return true;
	    
	    boolean[] arr = new boolean[256];
	    char[] ch = str.toCharArray();
	    
	    for(int i=0;i<ch.length;i++)
	    {
	        int val = str.charAt(i);
	        if(arr[val])
	            return false;
	        
	        arr[val] = true;    
	    }
	    return true;

	}
}
