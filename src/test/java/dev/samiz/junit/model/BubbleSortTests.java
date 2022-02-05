package dev.samiz.junit.model;

import dev.samiz.smanager.controller.SortManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortTests {
    // Creating a new variable to store an instance of the controller class.
    private static SortManager sortManager;
    // Random created for generating random ints.
    Random rand = new Random();
    // Before all tests make sure to instantiate an instance of the controller class.
    @BeforeAll
    static  void setUp(){ sortManager = new SortManager();}

    @Test
    @DisplayName("Given an array of ints the bubbleSort method returns the array sorted")
    public void bubbleSortWorksStandard(){
        int[] unsorted = {26,10,89,4,145,932,101};
        int[] expected = {4,10,26,89,101,145,932};
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of only 1 int element the bubbleSort method returns the array \"sorted\"")
    public void bubbleSortWorksWithOneElement(){
        int[] unsorted = {23};
        int[] expected = {23};
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of duplicate ints the bubbleSort method returns the array \"sorted\"")
    public void bubbleSortWorksWithAllDuplicates(){
        int[] unsorted = {42,42,42,42,42,42,42};
        int[] expected = {42,42,42,42,42,42,42};
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of duplicate ints bar one the bubbleSort method returns the array sorted")
    public  void bubbleSortWorksWithDuplicateElements(){
        int[] unsorted = {24,24,24,11,24,24,24};
        int[] expected = {11,24,24,24,24,24,24};
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of negative ints the bubbleSort method returns the array sorted")
    public void bubbleSortWorksWithNegativeInts(){
        int[] unsorted = {-12,-24,-1,-104,-56,-34,-1234};
        int[] expected = {-1234,-104,-56,-34,-24,-12,-1};
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of positive and negative ints the bubbleSort method returns the array sorted")
    public void bubbleSortWorksWithPositiveAndNegativeInts(){
        int[] unsorted = {-12,24,-1,192,-34,86,-1234};
        int[] expected = {-1234,-34,-12,-1,24,86,192};
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array containing no ints the bubbleSort method returns the empty array")
    public void bubbleSortWorksWithNoValues(){
        int[] unsorted = {};
        int[] expected = {};
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array which is null the bubbleSort method is expected to throw a \"NullPointerException\"")
    public void bubbleSortWithNullArray(){
        int[] unsorted = null;
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, () -> sortManager.initiateSort("bubble",unsorted),"An exception has not been thrown");
    }
    @Test
    @DisplayName("Given an array of 10 ints with RNG bounds for values the bubbleSort method returns the array sorted")
    public void bubbleSortWithRandomValues() {
        // Create a length and random value bounds variable to pass into our generateRandomArray() method.
        int length = 10;
        int randValueBounds = Math.abs(rand.nextInt());
        // Generate the array and make a copy of it.
        int[] unsorted = sortManager.generateRandomArray(length, randValueBounds);
        int[] expected = Arrays.copyOf(unsorted, length);
        // Sort both the original array (using bubble sort) and the copy (using "Arrays" built in sort function).
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, result);
    }
    @Test
    @DisplayName("Given an array with a random length containing random ints the bubbleSort method returns the array sorted")
    public void bubbleSortWithRandomArraySize() {
        // Create random ints and array of random size to pass into our generateRandomArray() method.
        int randLength = rand.nextInt(500);
        int randValueBounds = Math.abs(rand.nextInt());
        // Generate the array and make a copy of it.
        int[] unsorted = sortManager.generateRandomArray(randLength, randValueBounds);
        int[] expected = Arrays.copyOf(unsorted, randLength);
        // Sort both the original array (using bubble sort) and the copy (using "Arrays" built in sort function).
        int[] result = sortManager.initiateSort("bubble",unsorted);
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, result);
    }
}
