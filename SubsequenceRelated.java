package String;

public class SubsequenceRelated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isSubsequence("axe", "abcde"));
		
		int inputforNLogN[] = {3,4,-1,5,8,2,3,12,7,9,10};
		//System.out.println(longestIncreasingSubSequenceNLogN(inputforNLogN));
		
		int[] wiggleSequence = {1,2,3,4,5,6,7,8,9};
		System.out.println("WiggleSequence Length- "+wiggleMaxLength(wiggleSequence));
		
	}

	 public static boolean isSubsequence(String s, String txt) 
	 {
		 if(s== null || txt == null)
			 return false;
		
		 int j=0;
		 for(int i=0;i<txt.length()&&j<s.length();i++)
		 {
			 if(txt.charAt(i) == s.charAt(j))
				 j++;
			 
		 }
		 if(j==s.length())
			 return true;
		 return false;
	 }
	 
	 // Explanation-https://youtu.be/S9oUiVYEq7E
	 public static int longestIncreasingSubSequenceNLogN(int input[])
	 {
		 
		 int T[] = new int[input.length]; // temp intermediate results
		 int R[] = new int[input.length];// final results
		 for(int i=0; i < R.length ; i++) 
		 {
			 R[i] = -1;
		 }
		 T[0] = 0;
		 int len = 0; // length of increasing subsequence till now
		 
		 for(int i=1; i < input.length; i++)
		 {
			 if(input[T[0]] > input[i])
			 { //if input[i] is less than 0th value of T then replace it there.
				 T[0] = i;
		     }
			 else if(input[T[len]] < input[i])
			 { //if input[i] is greater than last value of T then append it in T
				 len++;
				 T[len] = i;
				 R[T[len]] = T[len-1];
		     }
			 else
			 { //do a binary search to find ceiling of input[i] and put it there.
				 int index = ceiling(input, T, len,input[i]);
				 System.out.println("index "+index);
				 T[index] = i;
				 R[T[index]] = T[index-1];
		      }
		 }
		 
		 //this prints increasing subsequence in reverse order.
		 System.out.print("Longest increasing subsequence ");
		 int index = T[len];
		//System.out.println("len "+index);
		 while(index != -1) 
		 {
			 System.out.print(input[index] + " ");
		     index = R[index];
		 }
		 System.out.println();
		 return len+1;
	 }
	 public static int ceiling(int[] input,int[] T, int end,int item)
	 {
		 int start = 0;
		 int middle;
		 int len = end;
		 while(start <= end)
		 {
			 middle = (start + end)/2;
			 if(middle < len && input[T[middle]] < item && item <= input[T[middle+1]])
			 {
				 return middle+1;
		     }
			 else if(input[T[middle]] < item)
			 {
				 start = middle+1;
		     }
			 else
			 {
				 end = middle-1;
		     }
		 }	 
			 return -1;
		 }
	 

	 // Wiggle Subsequence
	 // A sequence of numbers is called a wiggle sequence if the differences between 
	 //successive numbers strictly alternate between positive and negative.
	 public static int wiggleMaxLength(int[] nums) 
	 {
		 if(nums == null || nums.length==0)
		        return 0;
		 if(nums.length<2)
		 {
		        return nums.length;
		 }    
		 
		 int count=1;
		
		 
		 for(int i=1, j=0; i<nums.length; j=i, i++)
		 {
		        if(nums[j]<nums[i])
		        {
		            count++;
		            while(i<nums.length-1 && nums[i]<=nums[i+1])
		            {
		                i++;
		            }
		        }
		        else if(nums[j]>nums[i])
		        {
		            count++;
		            while(i<nums.length-1 && nums[i]>=nums[i+1])
		            {
		                i++;
		            }
		        }
		 }
		 
		 return count;
	 }
	 
	 
	 
}

	 