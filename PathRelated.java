package String;

import java.util.Stack;

public class PathRelated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));

		System.out.println(simplifyPath("/home//foo/"));
	}
	public static int lengthLongestPath(String input) {
        
		if(input == null)
			return 0;
		
		String[] tokens = input.split("\n");
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int result = 0;
		int current = 0;
		for(String s:tokens)
		{
			int level = countLevel(s);
			
			while(stack.size() > level)
			{
				current -= stack.pop();
				
				System.out.println("current inside"+current);
			}
			
			int len = s.replaceAll("\t", "").length() + 1;
			System.out.println("level "+level+" len "+len);
			
			current = current + len;
			System.out.println("current "+current);
			if(s.contains("."))
			{
				if(current-1 > result)
				{
					result = current-1;
				}
			}
			stack.add(len);
			System.out.println("Stack "+stack);
			System.out.println("\n");
		}
		return result;
    }
	public static int countLevel(String s)
	{
		String str = s.replaceAll("\t", "");
		return s.length() - str.length(); 
	}
	
	
	//71. Simplify Path
	/* For example,
	path = "/home/", => "/home"
	path = "/a/./b/../../c/", => "/c"
	
	Corner Case-
	path = "/../"?
	In this case, you should return "/".
	Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
	In this case, you should ignore redundant slashes and return "/home/foo".
	*/
	
	 public static String simplifyPath(String path) 
	 {
		 String[] str = path.split("/");
		 
		 Stack<String> stack = new Stack<String>();
		 for(int i=0;i<str.length;i++)
		 {
			 if(str[i].equals(".") || str[i].length() == 0)
				 continue;
			 else if(!str[i].equals(".."))
			 {
				 stack.push(str[i]);
			 }
			 else
			 {
				 if(!stack.isEmpty())
					 stack.pop();
			 }
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 Stack<String> temp = new Stack<String>();
		 
		 while(!stack.isEmpty())
		 {
			 temp.push(stack.pop());
		 }
		 
		 while(!temp.isEmpty())
		 {
			 sb.append("/"+temp.pop());
		 }
		 if(sb.length() == 0)
			 sb.append("/");
		 
		 return sb.toString();
	 }
	
}
