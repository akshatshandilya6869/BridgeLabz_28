import java.util.*;
public class handsake {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numberOfStudents = input.nextInt();
        int handshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
        System.out.printf("The maximum number of handshakes among %d students is %d\n\n",
                          numberOfStudents, handshakes);

        input.close();
    }
}
    

