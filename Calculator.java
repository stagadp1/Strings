package String;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(calculate("3+2*2"));
		
		System.out.println(reverseWords(""));
	}
	 public static int calculate(String s) 
	 {
		 s.replaceAll("\\s+","");
		 int num=0;
		 int ans = 0;
		 String temp="";
		 int md=-1; 	//	0 is m, 1 is d
		 int sign=1;	// 	1 is +, -1 is -
		 int prev=0;
		 for(int i=0;i<s.length();i++)
	        {
			 char c = s.charAt(i);
	            if(Character.isDigit(c))
	            {
	            	while(i<s.length() && Character.isDigit(s.charAt(i)))
	            	{
	            		temp+=s.charAt(i);
	            		i++;
	            	}
	            	num=Integer.parseInt(temp);
	            	i--;
	            	//System.out.println(num);
	            	temp="";
	            	// Multiplication and division is done here because of high preference
	            	if(md == 0)
	            	{
	            		prev = prev * num;
	            		md = -1;
	            	}
	            	else if(md == 1)
	            	{
	            		prev = prev / num;
	            		md = -1;
	            	}
	            	else
	            		prev = num;
	            	
	            }
	            else if(c=='/')
	            {
	            	md=1;
	      
	            }
	            else if(c=='*')
	            {
	            	md=0;
	            }
	            else if(c == '+')
	            {
	            	ans = ans + sign * prev;
	            	sign = 1;
	            }
	            else if(c == '-')
	            {
	            	ans = ans + sign * prev;
	            	sign = -1;
	            }
	            
	        }
		 ans+= sign * prev;
		 return ans;
	 }

	    public static String reverseWords(String s) {
	        
	    	 if(s.isEmpty())
		            return "";
	        String temp="";
	        List<String> list = new ArrayList<String>();
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<s.length();i++)
	        {
	            char c = s.charAt(i);
	            if(c == ' ')
	            {
	                list.add(temp);
	                temp=""; 
	               
	            }
	            else    
	            	temp+=c;    
	        }
	        System.out.println(list);
	        for(int i=list.size()-1;i>=0;i--)
	        {
	        	sb.append(list.get(i));
	        	sb.append(" ");
	        }
	       return sb.toString();
	    }

}
