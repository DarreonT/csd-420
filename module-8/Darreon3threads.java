/*
Name: Darreon Tolen
Date: 02/15/2026
Assignment: ThreeThreads
Purpose: This program creates three threads that print 10,000 random letters,
         numbers, and symbols, and verifies that each thread runs correctly.
*/

import java.util.Random;

public class DarreonThreeThreads {

    // Counters to verify that each thread prints 10,000 characters
    static int letterCounter = 0;
    static int numberCounter = 0;
    static int symbolCounter = 0;

    public static void main(String[] args) throws InterruptedException {

        // Create thread to generate random letters
        Runnable letterTask = () -> {
            Random randomGenerator = new Random();

            for (int i = 0; i < 10000; i++) {
                char randomLetter = (char) ('a' + randomGenerator.nextInt(26));
                System.out.print(randomLetter);
                letterCounter++;
            }
        };

        // Create thread to generate random numbers
        Runnable numberTask = () -> {
            Random randomGenerator = new Random();

            for (int i = 0; i < 10000; i++) {
                int randomNumber = randomGenerator.nextInt(10);
                System.out.print(randomNumber);
                numberCounter++;
            }
        };

        // Create thread to generate random symbols
        Runnable symbolTask = () -> {
            char[] symbolArray = {'!', '@', '#', '$', '%', '&', '*'};
            Random randomGenerator = new Random();

            for (int i = 0; i < 10000; i++) {
                char randomSymbol = symbolArray[randomGenerator.nextInt(symbolArray.length)];
                System.out.print(randomSymbol);
                symbolCounter++;
            }
        };

        // Create thread objects
        Thread letterThread = new Thread(letterTask);
        Thread numberThread = new Thread(numberTask);
        Thread symbolThread = new Thread(symbolTask);

        // Start all threads
        letterThread.start();
        numberThread.start();
        symbolThread.start();

        // Wait for all threads to finish before testing
        letterThread.join();
        numberThread.join();
        symbolThread.join();

        // Display test results
        System.out.println("\n\n--- TEST RESULTS ---");
        System.out.println("Letters printed: " + letterCounter);
        System.out.println("Numbers printed: " + numberCounter);
        System.out.println("Symbols printed: " + symbolCounter);

        // Verify correct execution
        if (letterCounter == 10000 &&
            numberCounter == 10000 &&
            symbolCounter == 10000) {

            System.out.println("All threads executed successfully.");
        } else {
            System.out.println("Error: One or more threads did not complete correctly.");
        }
    }
}
