package String;

import java.util.ArrayList;
import java.util.List;

public class MissingWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a="I am using hackerrank to improve programming";
		String b="am hackerrank to improve";
		
		String[] ans = missingWords(a, b);
		for(int i=0;i<ans.length;i++)
		{
			System.out.println("ans "+ans[i]);
		}
		
	}

	public static String[] missingWords(String a,String b)
	{
		String[] one = a.split(" ");
		String[] two = b.split(" ");
		
		List<String> result = new ArrayList<String>();
		int i,j;
		for(i=0,j=0;i<one.length && j<two.length;i++)
		{
		
				 if(!one[i].equals(two[j]))
					result.add(one[i]);
				 else
					 j++;
			
		}
		while(i<one.length)
		{
			result.add(one[i]);
			i++;
		}
		String[] res = result.toArray(new String[result.size()]);
		return res;
	}
}
