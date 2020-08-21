import java.util.*;
public class Q4 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the first String");   //only lowercase
		String s1=input.next();
		System.out.println("Enter the second String");
		String s2=input.next();
		input.close();
		if(s1.length()!=s2.length())
		{
			System.out.println("Not Anagram");
			return;
		}
		int[] count=new int[26];
		for(int i=0;i<s1.length();i++)
		{
			count[s1.charAt(i)-'a']++;
			count[s2.charAt(i)-'a']--;
		}
		for(int i=0;i<26;i++)
		{
			if(count[i]!=0)
			{
				System.out.println("Not Anagram");
				return;
			}
		}
		System.out.println("Anagram");
	}

}
