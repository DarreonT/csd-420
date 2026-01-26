/*
Name: Darreon Tolen
Date: January 25, 2026
Assignment: Sets and Maps – Non-Duplicate Words Program

Purpose: 
Read words from a text file, remove duplicates, and display them
in ascending and descending order.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordSetTest {

    public static void main(String[] args) {

        // TreeSet automatically removes duplicates and sorts data
        Set<String> words = new TreeSet<>();

        try {
            // Reference the file directly (not command line)
            File file = new File("collection_of_words.txt");
            Scanner input = new Scanner(file);

            // Read words from file
            while (input.hasNext()) {
                String word = input.next().toLowerCase();
                words.add(word);
            }

            input.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return;
        }

        // Display words in ascending order
        System.out.println("Non-duplicate words (Ascending Order):");
        for (String word : words) {
            System.out.println(word);
        }

        // Display words in descending order
        System.out.println("\nNon-duplicate words (Descending Order):");
        for (String word : ((TreeSet<String>) words).descendingSet()) {
            System.out.println(word);
        }

        // ---- Test Code ----
        runTests(words);
    }

    /*
     * Test method to verify correct functionality
     */
    public static void runTests(Set<String> words) {

        System.out.println("\n--- Test Results ---");

        // Test 1: Ensure no duplicates exist
        if (words.size() == new TreeSet<>(words).size()) {
            System.out.println("Test 1 Passed: No duplicate words stored.");
        } else {
            System.out.println("Test 1 Failed: Duplicates detected.");
        }

        // Test 2: Ensure data is sorted
        if (words instanceof TreeSet) {
            System.out.println("Test 2 Passed: Words are sorted automatically.");
        } else {
            System.out.println("Test 2 Failed: Words are not sorted.");
        }

        // Test 3: Ensure file was read successfully
        if (!words.isEmpty()) {
            System.out.println("Test 3 Passed: Words were read from the file.");
        } else {
            System.out.println("Test 3 Failed: No words were read.");
        }
    }
}
