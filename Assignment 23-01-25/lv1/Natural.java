import java.util.*;
class Natural{
public static void main(String[]args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt(System.in);
if(n>0){
int ans=(n*(n+1))/2;
System.out.println(The sum of "+n+" natural numbers is "+ans);
}
else{
System.out.println("The number "+n+"is not a natural number");
}
}
}



