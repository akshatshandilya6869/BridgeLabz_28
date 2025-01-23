import java.util.*;
class Q6{
public static void main(String[]args){
	//Create Scanner Object
        Scanner sc=new Scanner(System.in);
	//Get input for the number
        int n=sc.nextInt();
	//Check for positive
	if(n>0){
	System.out.println("Positive");
	}
	//Check for negative
	else if(n<0){
	System.out.println("Negative");
	}
	//number is zero if not positive or negative
	else{
	System.out.println("Zero");
	}
}
}

