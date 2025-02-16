
import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        String filePath = "output.txt"; // File to write user input

        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
             FileWriter fileWriter = new FileWriter(filePath, true);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {

            System.out.println("Enter text to write to the file (type 'exit' to stop):");

            String input;
            while (!(input = bufferedReader.readLine()).equalsIgnoreCase("exit")) {
                bufferedWriter.write(input);
                bufferedWriter.newLine(); // Add a new line after each input
            }

            System.out.println("User input successfully written to " + filePath);

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

