package dev.samiz.junitTests;

import dev.samiz.smanager.SortManagerMain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BubbleSortTests {
    // Creating a new variable to store an instance of the main program.
    private static SortManagerMain main;
    // Before all tests make sure to instantiate an instance of the main program.
    @BeforeAll
    static  void setUp(){ main = new SortManagerMain();}

    @Test
    @DisplayName("Given an array of ints the bubble sort works")
    public void bubbleSortWorksStandard(){
        int[] unsorted = {26,10,89,4,145,932,101};
        int[] expected = {4,10,26,89,101,145,932};
        int[] result = main.bubbleSort(unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of only 1 int element will it return the array with the individual element")
    public void bubbleSortWorksWithOneElement(){
        int[] unsorted = {23};
        int[] expected = {23};
        int[] result = main.bubbleSort(unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of duplicate ints it will return the ints")
    public void bubbleSortWorksWithAllDuplicates(){
        int[] unsorted = {42,42,42,42,42,42,42};
        int[] expected = {42,42,42,42,42,42,42};
        int[] result = main.bubbleSort(unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of duplicate ints bar one will it return the ints in order")
    public  void bubbleSortWorksWithDuplicateElements(){
        int[] unsorted = {24,24,24,11,24,24,24};
        int[] expected = {11,24,24,24,24,24,24};
        int[] result = main.bubbleSort(unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of negative ints will it return the ints in order")
    public void bubbleSortWorksWithNegativeInts(){
        int[] unsorted = {-12,-24,-1,-104,-56,-34,-1234};
        int[] expected = {-1234,-104,-56,-34,-24,-12,-1};
        int[] result = main.bubbleSort(unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array of positive and negative ints will it return the ints in order")
    public void bubbleSortWorksWithPositiveAndNegativeInts(){
        int[] unsorted = {-12,24,-1,192,-34,86,-1234};
        int[] expected = {-1234,-34,-12,-1,24,86,192};
        int[] result = main.bubbleSort(unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array containing no ints will it return the array")
    public void bubbleSortWorksWithNoValues(){
        int[] unsorted = {};
        int[] expected = {};
        int[] result = main.bubbleSort(unsorted);
        Assertions.assertArrayEquals(expected,result);
    }
    @Test
    @DisplayName("Given an array which is null, the bubble sort is expected to throw a \"NullPointerException\"")
    public void bubbleSortWithNullArray(){
        int[] unsorted = null;
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, () -> main.bubbleSort(unsorted),"An exception has not been thrown");
    }
}
