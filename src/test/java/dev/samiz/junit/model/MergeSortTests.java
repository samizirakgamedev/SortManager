package dev.samiz.junit.model;

import dev.samiz.smanager.controller.SortManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class MergeSortTests {
    // Creating a new variable to store an instance of the controller class.
    private static SortManager sortManager;
    // Random created for generating random ints.
    Random rand = new Random();
    // Before all tests make sure to instantiate an instance of the controller class.
    @BeforeAll
    static  void setUp(){ sortManager = new SortManager();}

    @Test
    @DisplayName("Given an array of ints the MergeSort class returns the array sorted")
    public void mergeSortWorksStandard(){
        int[] unsorted = {26,10,89,4,145,932,101};
        int[] expected = {4,10,26,89,101,145,932};
        int[] result = sortManager.initiateSort("merge",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of only 1 int element the MergeSort class returns the array \"sorted\"")
    public void mergeSortWorksWithOneElement(){
        int[] unsorted = {23};
        int[] expected = {23};
        int[] result = sortManager.initiateSort("merge",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of duplicate ints the MergeSort class returns the array \"sorted\"")
    public void mergeSortWorksWithAllDuplicates(){
        int[] unsorted = {42,42,42,42,42,42,42};
        int[] expected = {42,42,42,42,42,42,42};
        int[] result = sortManager.initiateSort("merge",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of duplicate ints bar one the MergeSort class returns the array sorted")
    public  void mergeSortWorksWithDuplicateElements(){
        int[] unsorted = {24,24,24,11,24,24,24};
        int[] expected = {11,24,24,24,24,24,24};
        int[] result = sortManager.initiateSort("merge",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of negative ints the MergeSort class returns the array sorted")
    public void mergeSortWorksWithNegativeInts(){
        int[] unsorted = {-12,-24,-1,-104,-56,-34,-1234};
        int[] expected = {-1234,-104,-56,-34,-24,-12,-1};
        int[] result = sortManager.initiateSort("merge",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of positive and negative ints the MergeSort class returns the array sorted")
    public void mergeSortWorksWithPositiveAndNegativeInts(){
        int[] unsorted = {-12,24,-1,192,-34,86,-1234};
        int[] expected = {-1234,-34,-12,-1,24,86,192};
        int[] result = sortManager.initiateSort("merge",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array containing no ints the MergeSort class returns the empty array")
    public void mergeSortWorksWithNoValues(){
        int[] unsorted = {};
        int[] expected = {};
        int[] result = sortManager.initiateSort("merge",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array which is null the MergeSort class is expected to throw a \"NullPointerException\"")
    public void mergeSortWithNullArray(){
        int[] unsorted = null;
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, () -> sortManager.initiateSort("merge", unsorted),"An exception has not been thrown");
    }
    @Test
    @DisplayName("Given an array of 10 ints with RNG bounds for values the MergeSort class returns the array sorted")
    public void mergeSortWithRandomValues() {
        // Create a length and random value bounds variable to pass into our generateRandomArray() method.
        int length = 10;
        int randValueBounds = Math.abs(rand.nextInt());
        // Generate the array and make a copy of it.
        int[] unsorted = sortManager.generateRandomArray(length, randValueBounds);
        int[] expected = Arrays.copyOf(unsorted, length);
        // Sort both the original array (using merge sort) and the copy (using "Arrays" built in sort function).
        int[] result = sortManager.initiateSort("merge",unsorted);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    @DisplayName("Given an array with a random length containing random ints the MergeSort class returns the array sorted")
    public void mergeSortWithRandomArraySize() {
        // Create random ints and array of random size to pass into our generateRandomArray() method.
        int randLength = rand.nextInt(500);
        int randValueBounds = Math.abs(rand.nextInt());
        // Generate the array and make a copy of it.
        int[] unsorted = sortManager.generateRandomArray(randLength, randValueBounds);
        int[] expected = Arrays.copyOf(unsorted, randLength);
        // Sort both the original array (using merge sort) and the copy (using "Arrays" built in sort function).
        int[] result = sortManager.initiateSort("merge",unsorted);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, result);
    }
}
