package String;

import java.util.HashMap;

public class FirstNonRepeatedChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static Character firstNonRepeatedCharacter1(String str) {
	    // Add your code below this line. Do not modify any other code.
	    if(str==null || str.length()==0) return null;
	    
	    int[] charQuantity = new int[256];
	    for(char currentCharacter : str.toCharArray()) {
	        charQuantity[currentCharacter] += 1;
	    }
	    for(char currentCharacter : str.toCharArray()) {
	        if(charQuantity[currentCharacter]==1) {
	            return currentCharacter;
	        }
	    }
	    return null;
	    // Add your code above this line. Do not modify any other code.
	}
	public static Character firstNonRepeatedCharacter2(String str) {
		  HashMap<Character, Integer> characterhashtable = new HashMap<Character, Integer>();
		  int i, length;
		  Character c;
		  length = str.length(); // Scan string and build hash table
		  for (i = 0; i < length; i++) {
		      c = str.charAt(i);
		      if (characterhashtable.containsKey(c)) {
		          // Increment count corresponding to c
		          characterhashtable.put(c, characterhashtable.get(c) + 1);
		      } else {
		          characterhashtable.put(c, 1);
		      }
		  }
		  // Search character hashtable in order of string str
		  for (i = 0; i < length; i++) {
		      c = str.charAt(i);
		      if (characterhashtable.get(c) == 1)
		          return c;
		  }
		  return null;
		}

}
