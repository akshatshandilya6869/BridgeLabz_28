import java.io.*;

public class ConvertCase {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destinationFile = "destination.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))) {
            
            int character;
            while ((character = reader.read()) != -1) {
                writer.write(Character.toLowerCase(character));
            }
            
            System.out.println("File converted successfully.");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
