package dev.samiz.smanager.model;
// Product 1
public class BubbleSort implements Sort{
    // Bubble sort algorithm.
    @Override
    public int[] sort(int[] arrayToSort) {
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
}
