package dev.samiz.smanager;

import java.util.Random;

public class SortManagerMain {
    public static void main(String[] args){
        int[] numbersToSort = generateRandomArray(10,1000);

        System.out.println("Our ints to sort are: ");
        printArray(numbersToSort);
        // Call bubble sort algorithm
       //bubbleSort(numbersToSort);
        // Call merge sort algorithm
        mergeSort(numbersToSort);

        System.out.println("Our sorted ints are: ");
        printArray(numbersToSort);
    }
    // Merge sort algorithm
    private static int[] mergeSort(int[] arrayToSort){
        // Grabbing the length of the input array.
        int arrayLength = arrayToSort.length;
        // If the array has only one element it is already sorted and does not require sorting.
        if(arrayLength < 2)
            return arrayToSort;
        // Finding the halfway point in the randomly sized array to establish where it will need to be split to begin sorting.
        int indexSplit = arrayLength / 2;
        // Creating a new array to house the left half of the array we are sorting.
        int[] leftArray = new int [indexSplit];
        // Creating a new array to house the right half of the array we are sorting.
        // NOTE: The right side of the array
        int[] rightArray = new int [arrayLength - indexSplit];
        
        for (int i = 0; i <indexSplit; i++){
            leftArray[i] = arrayToSort[i];

        }
        for (int i = indexSplit; i < arrayLength; i++){
            rightArray[i - indexSplit] = arrayToSort[i];
        }
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(arrayToSort,leftArray,rightArray);

        return arrayToSort;
    }
    // Bubble sort algorithm.
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

    public static void merge(int[] arrayToSort, int[] leftArray, int[] rightArray){
        int leftLength = leftArray.length, rightLength = rightArray.length;

        int q = 0, w = 0, e = 0;

        while (q < leftLength && w < rightLength){
            if(leftArray[q] <= rightArray[w]){
                arrayToSort[e] = leftArray[q];
                q++;
            }
            else {
                arrayToSort[e] = rightArray[w];
                w++;
            }
            e++;
        }
        while (q < leftLength){
            arrayToSort[e] = leftArray[q];
            q++;
            e++;
        }
        while (w < rightLength){
            arrayToSort[e] = rightArray[w];
            w++;
            e++;
        }
    }
    // Method for printing an array to the console.
    public static void printArray(int[] numbers){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            builder.append("Number " ).append(i+1).append(": ").append(numbers[i]).append(" | ");
        }
        System.out.println(builder);
    }
    // Method for creating an array of random inputs when passed an array length and bounds for the random number generator.
    public static int[] generateRandomArray(int length, int bounds){
        //Generate new array of ints;
        Random rand = new Random();
        int[] numbersToSort = new int[length];
        for(int i = 0; i < numbersToSort.length; i++){
            numbersToSort[i] = rand.nextInt(bounds);
        }
        return numbersToSort;
    }
}
