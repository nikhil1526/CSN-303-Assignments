import java.util.Scanner;
public class Q1{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the original string ");    //only lowercase
		String str=input.next();
		System.out.println("Enter the substring ");
		String subString=input.next();
		int subLen=subString.length();
		int strLen=str.length();
		input.close();
		System.out.print("Number of occurences are: ");
		if(strLen<subLen)
		{
			System.out.println(0);
			return;
		}
		int[] count=new int[26];
		int result=0;
		for(int i=0;i<subLen;i++)
		{
			count[str.charAt(i)-'a']++;
			count[subString.charAt(i)-'a']--;
		}



		
		if(isnull(count))
		{
			result++;
		}


		for(int i=subLen;i<strLen;i++)
		{
			count[str.charAt(i-subLen)-'a']--;
			count[str.charAt(i)-'a']++;
			if(isnull(count))
				result++;
		}
		System.out.println(result);
	}
	public static boolean isnull(int[] count)
	{
		for(int i=0;i<26;i++)
		{
			if(count[i]!=0)
				return false;
		}
		return true;
	}
}