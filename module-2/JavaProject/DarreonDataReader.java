import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DarreonDataReader {
    public static void main(String[] args) {
        String filename = "Darreon_datafile.dat";
        File file = new File(filename);

        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                System.out.println("Data from file:\n");

                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }

                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                e.printStackTrace();
            }
        } else {
            System.out.println("The file " + filename + " does not exist.");
        }
    }
}
