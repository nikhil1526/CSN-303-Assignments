import java.util.*;
public class Q2 {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the paragraph ");
		String para=input.nextLine();
		System.out.println("Enter the size of vector ");

		int sizeVec=input.nextInt();


		HashSet<String> vec=new HashSet<String>();


		System.out.println("Enter "+sizeVec+" words");


		for(int i=0;i<sizeVec;i++)
		{
			String s=input.next();
			vec.add(s);
		}
		input.close();
		int n=para.length();
		int index=0;

		System.out.println("Final Paragraph ");
		String formattedPara="";
		while(index<n)
		{
			String s="";
			while(index<n && para.charAt(index)!=' ')
			{
				s+=para.charAt(index);
				index++;
			}
			
			if(vec.contains(s))
			{
				formattedPara+=s.charAt(0);
				for(int i=1;i<s.length();i++)
				{
					formattedPara+='*';
				}
			}
			else
			{
				formattedPara+=s;
			}
			if(index<n && para.charAt(index)==' ')
			{
				formattedPara+=" ";
			}
			index++;
		}

		
		System.out.println(formattedPara);
	}

}
