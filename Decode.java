package String;

import java.util.Stack;

public class Decode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "2[abc]3[cd]ef";
		System.out.println(decodeString(str));
		
		String str2 = "126";
		System.out.println(Decode.numDecodings(str2));
	}

	 public static String decodeString(String s) 
	 {
		 if(s == null)
			 return null;
		 
		Stack<Integer> counts = new Stack<Integer>();
		Stack<String> str = new Stack<String>();
		
		String result="";
		
		int i =0;
		while(i<s.length())
		{
			int num=0;
			if(Character.isDigit(s.charAt(i)))
			{
				while(Character.isDigit(s.charAt(i)))
				{
					// if number is two digit
					num=num*10+(s.charAt(i)-'0');
					i++;
				}
				counts.push(num);
			}
			
			else if(s.charAt(i)=='[')
			{
				str.push(result);
				result = "";
				i++;
			}
			else if(s.charAt(i) == ']')
			{
				StringBuffer sb = new StringBuffer(str.pop());
				int count = counts.pop();
				for(int j=0;j<count;j++)
				{
					sb.append(result);
				}
				result = sb.toString();
				i++;
			}
			else
			{
				result = result + s.charAt(i);
				i++;
				
			}
		}
	    return result;
	 }
	  public static int numDecodings(String s) 
	  {
	        
          if(s==null || s.length() == 0 || s.charAt(0) =='0')
              return 0;
	        if(s.length()==1)
	            return 1;
	        int[] dp = new int[s.length()];
	        dp[0] = 1;
	        int temp = Integer.parseInt(s.substring(0, 2));
	        if(temp > 26)
	        {
	        	if(s.charAt(1)!='0')
	        		dp[1] = 1;
	        	else
	        		dp[1] = 0;
	        }
	        else
	        {
	        	if(s.charAt(1)!='0')
	        		dp[1] = 2;
	        	else
	        		dp[1] = 1;
	        }
	        
	        for(int i=2;i<s.length();i++)
	        {
	        	if(s.charAt(i)!='0')
	        	{
	        		dp[i]+=dp[i-1];
	        	}
	        	int val=Integer.parseInt(s.substring(i-1, i+1));
	        	if(val <= 26 && val >= 10)
	        	{
	        		dp[i]+=dp[i-2];
	        	}
	        }
	        return dp[s.length()-1];
	    
      
  }
}
