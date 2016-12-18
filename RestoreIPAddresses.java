package String;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(restoreIpAddresses("25525511135"));
	}

	public static List<String> restoreIpAddresses(String s) 
	{
		List<String> list = new ArrayList<String>();
		if(s.length() < 4 || s.length() > 12)
			return list;
		dfs(list,s,"",0);
		
		return list;
    }
	
	public static void dfs(List<String> result,String s,String path,int start)
	{
		if(start == s.length() && path.length() == s.length()+3 )
		{
			System.out.println("Added");
			result.add(path);
			return;
		}
		for(int i=start+1;i<=start+3 && i<=s.length();++i)
		{
			String sub = s.substring(start, i);
			System.out.println(sub);
			if(isValid(sub))
			{
				System.out.println("inside loop "+path);
				dfs(result,s,(path.length()==0? "" : path+".")+sub,i);
			}
		System.out.println("End of for loop");
		}
	}
	public static boolean isValid(String s)
	{
		if(s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);
		return num >= 0 && num <= 255;
	}
}
