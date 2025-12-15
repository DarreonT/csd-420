import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DarreonDataWriter {
    public static void main(String[] args) {
        Random rand = new Random();
        String filename = "Darreon_datafile.dat"; // File name

        int[] intArray = new int[5];
        double[] doubleArray = new double[5];

        // Generate 5 random integers and doubles
        for (int i = 0; i < 5; i++) {
            intArray[i] = rand.nextInt(100) + 1; // 1 to 100
            doubleArray[i] = Math.round(rand.nextDouble() * 10000.0) / 100.0; // 1.0 to 100.0 with 2 decimals
        }

        try {
            // Open file in append mode ('true' means append)
            FileWriter writer = new FileWriter(filename, true);

            writer.write("Integers: ");
            for (int num : intArray) {
                writer.write(num + " ");
            }
            writer.write("\n");

            writer.write("Doubles: ");
            for (double num : doubleArray) {
                writer.write(num + " ");
            }
            writer.write("\n\n"); // extra line for readability

            writer.close();
            System.out.println("Data written to " + filename + " successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
