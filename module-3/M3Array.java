import java.util.ArrayList; // Imports the tool to make Lists
import java.util.Random;    // Imports the tool to make Random numbers

public class Module3Assignment {

    public static void main(String[] args) {
        
        // --- STEP 1: SETUP ---
        // Create the empty list to hold our numbers
        ArrayList<Integer> originalList = new ArrayList<>();
        
        // Create the random number generator
        Random randomTool = new Random();

        // --- STEP 2: FILL THE LIST ---
        // We need 50 numbers [cite: 3]
        for (int i = 0; i < 50; i++) {
            // Generate a random number from 0-19, then add 1 to make it 1-20
            int randomNumber = randomTool.nextInt(20) + 1;
            
            // Add it to our list
            originalList.add(randomNumber);
        }

        // --- STEP 3: PRINT THE MESSY LIST ---
        System.out.println("Here is the list with duplicates:");
        System.out.println(originalList);

        // --- STEP 4: CLEAN THE LIST ---
        // We call our method 'removeDuplicates' and save the result in a new list
        ArrayList<Integer> cleanList = removeDuplicates(originalList);

        // --- STEP 5: PRINT THE CLEAN LIST ---
        System.out.println("\nHere is the list with NO duplicates:");
        System.out.println(cleanList);
    }

    // This is the method your assignment requires 
    // <E> just stands for "Element". It means this method works for Words, Numbers, or Anything.
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> messyList) {
        
        // 1. Create a brand new, empty list to hold the unique items
        ArrayList<E> uniqueList = new ArrayList<>();

        // 2. Loop through every single item in the messy list
        for (E item : messyList) {
            
            // 3. Ask: "Is this item ALREADY in our new unique list?"
            if (!uniqueList.contains(item)) {
                
                // 4. If the answer is NO, add it to the list.
                // (If the answer is YES, we skip it, effectively deleting the duplicate)
                uniqueList.add(item);
            }
        }

        // 5. Send the nice, clean list back to the main program [cite: 2]
        return uniqueList;
    }
}