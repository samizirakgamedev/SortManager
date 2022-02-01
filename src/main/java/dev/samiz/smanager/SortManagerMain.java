package dev.samiz.smanager;

import java.util.Random;

public class SortManagerMain {
    public static void main(String[] args) {
        //Generate new array of ints;
        Random rand = new Random();
        int[] numbersToSort = new int[7];
        for(int i = 0; i < numbersToSort.length; i++){
            numbersToSort[i] = rand.nextInt(1000);
        }
        System.out.println("Our ints to sort are: ");
        printArray(numbersToSort);

        //Call bubble sort algorithm;
        bubbleSort(numbersToSort);

        System.out.println("Our sorted ints are: ");
        printArray(numbersToSort);
    }

    public static int[] bubbleSort(int[] arrayToSort){
        boolean swappedANumber = true;
        // While the algorithm is still swapping continue to sort.
        while (swappedANumber){
            // No confirmation that a number requires sorting yet.
            swappedANumber = false;
            // Iterates through every number in the array
            // NOTE: "-1" has been added to exclude the last number in the array that will be checked in the second to last loop anyway.
            for (int i = 0; i < arrayToSort.length -1; i++){
                // If the current number is larger than the next number in the array
                if(arrayToSort[i] > arrayToSort[i+1]){
                    // We confirm that a number will be swapped (we will need to iterate again)
                    swappedANumber = true;
                    // Temporarily store the int at the current index within the array
                    int temp = arrayToSort[i];
                    // Replace the number at the current index within the array with the next number in the array that has been identified as being smaller.
                    arrayToSort[i] = arrayToSort[i+1];
                    // Add the temp value back into the array one index ahead of its previous position.
                    arrayToSort[i +1] = temp;
                }
            }
        }
        return arrayToSort;
    }
    //Method for printing an array to the console.
    public static void printArray(int[] numbers){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            builder.append("Number " ).append(i+1).append(": ").append(numbers[i]).append(" | ");
        }
        System.out.println(builder);
    }
}
