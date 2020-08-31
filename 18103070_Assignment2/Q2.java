import java.util.*;


public class Q2
{		



public static void main(String[] args)
{
	Scanner input =new Scanner(System.in);

	System.out.println("Enter number of elements");

	int siz=input.nextInt();

	System.out.println("Enter "+siz+ " elements between 0 and 20");

	int count[]=new int[21];

	int i=0;
	for(i=0;i<siz;i++)
	{
		int a=input.nextInt();
		if(a<0||a>20)
		{
			System.out.println("Invalid input");
			break;
		}
		count[a]++;
	}


	if(i==siz)
	{
		System.out.println("After Sorting:");
	for(int j=0;j<=20;j++)
	{	
		while(count[j]>0)
		{
			count[j]--;
		System.out.print(j+" ");
		}
	}
	}


	


}


}