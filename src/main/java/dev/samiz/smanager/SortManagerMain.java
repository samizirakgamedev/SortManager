package dev.samiz.smanager;

import java.util.Random;

public class SortManagerMain {
    // Sort Managers main method.
    public static void main(String[] args){
        // Calling a method to create a random array of ints by passing in a length and RNG bound for the numbers being generated.
        int[] numbersToBubbleSort = generateRandomArray(7,100);
        int[] numbersToMergeSort = generateRandomArray(7,100);
        // 'View' element.
        System.out.println("| Ints prior to bubble sorting: |");
        printArray(numbersToBubbleSort);
        // Call bubble sort algorithm.
        bubbleSort(numbersToBubbleSort);
        // 'View' element.
        System.out.println("| Ints after being bubble sorted: |");
        printArray(numbersToBubbleSort);
        // 'View' element.
        System.out.println("| Ints prior to merge sorting: |");
        printArray(numbersToMergeSort);
        // Call merge sort algorithm.
        mergeSort(numbersToMergeSort);
        // 'View' element.
        System.out.println("| Ints after being merge sorted: |");
        printArray(numbersToMergeSort);
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
        // NOTE: The right side of the array will be the calculation of the array's length minus the array's midpoint.
        int[] rightArray = new int [arrayLength - indexSplit];
        // Storing the left half of the array were sorting into the new 'left' array.
        for (int i = 0; i <indexSplit; i++){
            leftArray[i] = arrayToSort[i];
        }
        // Storing the right half of the array were sorting into the new 'right' array.
        for (int i = indexSplit; i < arrayLength; i++){
            rightArray[i - indexSplit] = arrayToSort[i];
        }
        // We merge sort each half of the array were sorting by recursively calling the method.
        mergeSort(leftArray);
        mergeSort(rightArray);
        // Call our merge method to merge the arrays together again.
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
                // If the current number is larger than the next number in the array.
                if(arrayToSort[i] > arrayToSort[i+1]){
                    // We confirm that a number will be swapped (we will need to iterate again).
                    swappedANumber = true;
                    // Temporarily store the int at the current index within the array.
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
    // Method for merging two arrays back together as part of the merge sort algorithm.
    private static void merge(int[] arrayToSort, int[] leftArray, int[] rightArray){
        // Create ints to store the lengths of each half of the original array.
        int leftLength = leftArray.length, rightLength = rightArray.length;
        // Create 3 int iterator variables to be used during merging loops.
        int q = 0, w = 0, e = 0;
        // We then loop until we run out of elements in either the left or right array.
        while (q < leftLength && w < rightLength){
            // If the left element is less than or equal to the first element in the right array
            if(leftArray[q] <= rightArray[w]){
                // We add the left (smaller int) to original array were sorting starting from element 0.
                arrayToSort[e] = leftArray[q];
                q++;
            }
            // Else the number in the right array must be smaller than the number in the left array.
            else {
                // We add the right array int to the original array next instead.
                arrayToSort[e] = rightArray[w];
                w++;
            }
            e++;
        }
        // If we have any elements left in our left array we add them back to the original array.
        while (q < leftLength){
            arrayToSort[e] = leftArray[q];
            q++;
            e++;
        }
        // If we have any elements left in our right array we add them back to the original array.
        while (w < rightLength){
            arrayToSort[e] = rightArray[w];
            w++;
            e++;
        }
    }
    // Method for printing an array to the console using StringBuilder.
    private static void printArray(int[] numbers){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < numbers.length; i++){
            builder.append("Number " ).append(i+1).append(": ").append(numbers[i]).append(" | ");
        }
        System.out.println(builder);
    }
    // Method for creating an array of random ints when passed an array length and bounds for the random number generator.
    private static int[] generateRandomArray(int length, int bounds){
        Random rand = new Random();
        int[] numbersToSort = new int[length];
        for(int i = 0; i < numbersToSort.length; i++){
            numbersToSort[i] = rand.nextInt(bounds);
        }
        return numbersToSort;
    }
}
