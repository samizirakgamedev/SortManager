package dev.samiz.smanager.model;
// Product 2
public class MergeSort implements Sort{
    // Merge sort algorithm.
    @Override
    public int[] sort(int[] arrayToSort) {
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
        sort(leftArray);
        sort(rightArray);
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
        return arrayToSort;
    }
}
