import java.io.*;

public class ImageByteArray {
    public static void main(String[] args) {
        String sourceImage = "source.jpg";
        String destinationImage = "destination.jpg";
        
        try {
            // Read image file into a byte array
            FileInputStream fis = new FileInputStream(sourceImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            fis.close();
            byte[] imageBytes = baos.toByteArray();
            baos.close();
            
            // Write byte array to a new image file
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            FileOutputStream fos = new FileOutputStream(destinationImage);
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            bais.close();
            fos.close();
            
            System.out.println("Image successfully converted to byte array and written back to file.");
        } catch (IOException e) {
            System.out.println("Error processing image file: " + e.getMessage());
        }
    }
}