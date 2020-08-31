import java.util.*;


public class Q6
{		

public static void Halistone(int n){

	System.out.print(n+" ");
	if(n==1)
		return;
	if(n%2==1)
	{
		Halistone(n*3+1);
	}
	else
	{
		Halistone(n/2);
	}
}

public static void main(String[] args)
{
	Scanner input =new Scanner(System.in);

	System.out.println("Enter value of N");

	int n=input.nextInt();
	if(n<=0)
		System.out.println("Invalid Input");
	else
	{

	Halistone(n);

	}
	
	


}


}