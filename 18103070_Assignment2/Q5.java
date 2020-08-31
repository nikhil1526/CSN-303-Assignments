import java.util.*;



class Q5
{
	public static void union(int a[],int b[])
	{
		int a1=a.length;
		int b1=b.length;
		int result []=new int [a1+b1];

		int i=0,j=0,index=0;
		while(i<a1&&j<b1)
		{
			if(a[i]==b[j])
			{
				result[index++]=a[i++];
				
				j++;


			}
			else if(a[i]<b[j])
			{
				result[index++]=a[i++];
				
				
			}
			else
				result[index++]=b[j++];
				
		}

		while(i<a1)
			result[index++]=a[i++];

		while(j<b1)
			result[index++]=b[j++];

		System.out.println("Union:");
		for(int k=0;k<index;k++)
			System.out.print(result[k]+" ");

		System.out.println("");


	}


	public static void intersection(int a[],int b[])
	{
		int a1=a.length;
		int b1=b.length;
		int result []=new int [a1+b1];

		int i=0,j=0,index=0;
		while(i<a1&&j<b1)
		{
			if(a[i]==b[j])
			{
				result[index++]=a[i++];
				
				j++;


			}
			else if(a[i]<b[j])
			{
				i++;
								
				
			}
			else
				j++;
				
				
		}



		System.out.println("Intersection:");
		if(index>0)
		{
		for(int k=0;k<index;k++)
			System.out.print(result[k]+" ");
		}
		else
			System.out.println("NULL");

		System.out.println("");




	}

	public static void complement(int a[],int universe[])
	{	
			int a1=a.length;
			int u1=universe.length;

			int i=0,j=0,index=0;
			int result []=new int[u1];

			while(i<a1&&j<u1)
			{
				if(universe[j]<a[i])
					result[index++]=universe[j++];
				else
				{
					j++;
					i++;
				}


			}

			while(j<u1)
				result[index++]=universe[j++];

			System.out.println("Complement is:");
		if(index>0)
		{
		for(int k=0;k<index;k++)
			System.out.print(result[k]+" ");
		}
		else
			System.out.println("NULL");

		System.out.println("");





	}


	public static int[] modify(int a[])
	{
		int n=a.length;

		int count[]=new int[11];
		int index=0;
		for(int i=0;i<n;i++)
		{
			count[a[i]]++;
			if(count[a[i]]==1)
				index++;
		}

		int result[]=new int[index];
		index=0;
		for(int i=0;i<11;i++)
		{
			if(count[i]>0)
				result[index++]=i;
		}

		return result;

	}


	public static void main(String args[])
	{
		Scanner input=new Scanner(System.in);
		int [] universe={0,1,2,3,4,5,6,7,8,9,10};
		System.out.println("Enter size of set 1");
		int n1=input.nextInt();
		System.out.println("Enter elements of set 1");
		int [] A=new int[n1];

		for(int i=0;i<n1;i++)
		{
			A[i]=input.nextInt();
			while(A[i]<0||A[i]>10)
			{
				System.out.println("Not valid...Enter a valid value");
				A[i]=input.nextInt();
			}
		}
		System.out.println("Enter size of set 2");
		int n2=input.nextInt();
		int [] B=new int[n2];
		System.out.println("Enter elements of set 2");

		for(int i=0;i<n2;i++)
		{
			B[i]=input.nextInt();
			while(B[i]<0||B[i]>10)
			{
				System.out.println("Not valid...Enter a valid value");
				B[i]=input.nextInt();
			}
		}

		A=modify(A);
		B=modify(B);

		long start1 = System.currentTimeMillis();
		union(A,B);
		intersection(A,B);
		complement(A,universe);
		complement(B,universe);

		long end1 = System.currentTimeMillis();


		System.out.println("Time taken "+(end1-start1)+" milliseconds");


		long start2 = System.currentTimeMillis();
        Set<Integer> set_1=new HashSet<Integer>();
        Set<Integer> set_2=new HashSet<Integer>();
        Set<Integer> univ=new HashSet<Integer>();
        
        univ.addAll(Arrays.asList(new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
 
        for(int i = 0; i < A.length; i++) {
     
            set_1.add(A[i]);
        }
        
      
        
        for(int i=0; i<B.length; i++) {
            
            set_2.add(B[i]);
        }
        
        Set<Integer> union_ans=new HashSet<Integer>(set_1);
        union_ans.addAll(set_2);
        System.out.println("Union: "+union_ans);
        
        Set<Integer> int_ans= new HashSet<Integer>(set_1);
        int_ans.retainAll(set_2);
        System.out.println("Intersection: "+int_ans);
        
        Set<Integer> compset_1= new HashSet<Integer>(univ);
        compset_1.removeAll(set_1);
        System.out.println("Complement of set 1: "+compset_1);
        
        Set<Integer> compset_2= new HashSet<Integer>(univ);
        compset_2.removeAll(set_2);
        System.out.println("Complement of set 2: "+compset_2);
        
        long end2 = System.currentTimeMillis();
        System.out.println("Time taken: "+(end2-start2)+" milliseconds");

		




		




		
	}

}