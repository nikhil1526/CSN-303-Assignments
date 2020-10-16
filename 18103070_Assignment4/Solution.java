import java.util.Scanner;
import java.util.*;
import java.lang.Math.*;


class Solution {
public static void main(String[] args)
{
int n,m;
Scanner in = new Scanner(System.in);
n = in.nextInt();
m=in.nextInt();
in.nextLine();
String[] crops = new String[n];
for (int i=0;i<n;i++){
crops[i]=in.nextLine().trim();
}

System.out.print(replant(crops));
}


public static int replant(String[] crops){

int n=crops.length;
int m=crops[0].length();

char[][] matrix=new char[n][m];

// int[][] visited=new int[n][m];

for(int i=0;i<n;i++)
	for(int j=0;j<m;j++)
	{
		matrix[i][j]=crops[i].charAt(j);
	}







int ans=replanting(matrix,0,0,n,m);









return ans;
}

public static int replanting(char[][] matrix,int row,int col,int n,int m)
{
	if(row>=n-1&&col==m)
		return 0;

	if(col==m)
	{
		col=0;
		row=row+1;
	}


	int left=0,right=0,top=0,bottom=0;
	if(row-1>=0&&matrix[row][col]==matrix[row-1][col])
		top=1;

	if(col-1>=0&&matrix[row][col]==matrix[row][col-1])
		left=1;

	if(row+1<=n-1&&matrix[row][col]==matrix[row+1][col])
		bottom=1;

	if(col+1<=m-1&&matrix[row][col]==matrix[row][col+1])
		right=1;



	if(left==1||top==1)
	{	
		matrix[row][col]='#';
		return replanting(matrix,row,col+1,n,m)+1;
	}
	else if(right==1&&bottom==1)
	{
		char temp=matrix[row][col];
		matrix[row][col]='#';
		int ans1=replanting(matrix,row,col+1,n,m)+1;
		matrix[row][col]=temp;
		int ans2=replanting(matrix,row,col+1,n,m);

		return Math.min(ans1,ans2);
		
	}
	else
		return replanting(matrix,row,col+1,n,m);






}
}