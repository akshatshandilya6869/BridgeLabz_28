import java.util.*;
class Q7{
public static void main(String[]args){
        //Create Scanner Object
        Scanner sc=new Scanner(System.in);
        //Get input for month and day
        int month=sc.nextInt();
	int day=sc.nextInt();
        //Check for correct month
        if(month>=3 && month <=6){
        //Check for day
	if(month >=20 && month <=31){
	System.out.println("It's a Spring Season");
	}
	else if(day >=1 && day<=20){
	System.out.println("It's a Spring Season");
	}
        }
        else{
	 System.out.println("Not Spring Season");
        }
}
}
