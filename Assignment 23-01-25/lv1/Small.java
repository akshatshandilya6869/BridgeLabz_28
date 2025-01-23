import java.util.*;
class Q3{
public static void main(String[]args){
	Scanner sc=new Scanner(System.in);
	int a=sc.nextInt();
	int b=sc.nextInt();
	int c=sc.nextInt();
	int ans=Math.max(a,(Math.max(b,c)));
	System.out.println("The smallest no is"+ans);
}
}
