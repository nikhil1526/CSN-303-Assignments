import java.util.*;


class Q4{



	public static void main(String args[])
	{
		long temp1,temp2;
		int i;
		for(i=2147483647;i>=1;i--)
		{
			temp1=i*(i+1);
			temp1=temp1/2;
			temp2=i*i;
			if(temp1==temp2)
				break;
		}

		if(i>=1)
			System.out.println(i);

		

	}
}