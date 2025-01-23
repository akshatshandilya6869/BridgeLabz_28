import java.util.*;
class Q17{
public static void main(String[]args){
        //Create Scanner Object
        Scanner sc=new Scanner(System.in);
        //Get input for the salary and year of service 
        int salary=sc.nextInt();
	int year=sc.nextInt();
        double bonus=0.0;
        if(year>5){
	bonus=(salary*5)/100;
	}
	else{
	System.out.println("Slary is :"+salary);
	}
	System.out.println("Bonus AAmount is :" +bonus);
}
}



