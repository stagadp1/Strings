package String;

public class ReplaceallSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		replace("This is a Test","////");
	}

	
	public static void replace(String a, String b) {


	    char[] arr = a.toCharArray();
	    char[] sub = b.toCharArray();
	    
	    
	    int len = 0;

	    for(int i=0;i<arr.length;i++)
	    {
	        if(arr[i] == ' ')
	            len++;
	    }
	   
	    int newlength = a.length() + (len * b.length());
	    
	    char[] ans = new char[newlength];
	    for(int i=arr.length-1;i>=0;i--)
	    {
	    	int sublength = sub.length;
	    	if(arr[i] == ' ')
	    	{
	    		while(sublength > 0)
	    		{
	    			ans[newlength - 1] = sub[sublength-1];
	    			newlength--;
	    			sublength--;
	    		}
	    		
	    	}
	    	else
	    	{
	    		ans[newlength-1] = arr[i];
	    		newlength--;
	    	}
	    }
	    
	    System.out.println(ans);
//	    return new String(ans);



	}
	
	
	public static String replace1(String a, String b) {
		// Add your code below this line. Do not modify any other code.

		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < a.length(); i++){
		    char c = a.charAt(i);
		    if(c == ' ') builder.append(b);
		    else builder.append(c);
		}
		return builder.toString();

		// Add your code above this line. Do not modify any other code.
		}
}
