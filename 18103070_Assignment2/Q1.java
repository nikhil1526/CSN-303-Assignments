import java.util.*;


public class Q1
{		

public static int lexicographically(String s1,String s2)
{
	for(int i=0;i<Math.min(s1.length(),s2.length());i++)
	{
		if((int)s1.charAt(i)!=(int)s2.charAt(i))
			return (int)s1.charAt(i)-(int)s2.charAt(i);

	}

	
		return s1.length()-s2.length();

}

public static void main(String[] args)
{
	Scanner input =new Scanner(System.in);

	System.out.println("Enter two strings");
	String s1=input.nextLine();
	String s2=input.nextLine();
	int result=lexicographically(s1,s2);
	
	if(result>0)
		System.out.println(s2+" is lexicographically greater than "+s1 );
	else if(result<0)
		System.out.println(s1+" is lexicographically greater than "+s2 );
	else
		System.out.println(s1+" is lexicographically equal to "+s2);


}


}
