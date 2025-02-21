
import java.util.Scanner;

public class ArrayOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the number of elements in the array: ");
            int size = scanner.nextInt();
            Integer[] array = new Integer[size];
            
            System.out.println("Enter array elements:");
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
            }
            
            System.out.print("Enter index to retrieve value: ");
            int index = scanner.nextInt();
            
            System.out.println("Value at index " + index + ": " + array[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred.");
        } finally {
            scanner.close();
        }
    }
}

