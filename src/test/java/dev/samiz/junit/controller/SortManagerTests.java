package dev.samiz.junit.controller;

import dev.samiz.smanager.controller.SortManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SortManagerTests {
    // Creating a new variable to store an instance of the controller class.
    private static SortManager sortManager;

    // Before all tests make sure to instantiate an instance of the controller class.
    @BeforeAll
    static  void setUp(){ sortManager = new SortManager();}

    @Test
    @DisplayName("Given a length int and bounds int the generateRandomArray method returns a new array that meets the length specification")
    public void generateRandomArrayReturnsArrayToLengthSpecification(){
        int expectedlength = 10;
        int bounds = 100;
        int[] generatedArray = sortManager.generateRandomArray(expectedlength,bounds);
        int actualLength = generatedArray.length;
        Assertions.assertEquals(expectedlength,actualLength);
    }
    @Test
    @DisplayName("Given a length int and bounds int the generateRandomArray method returns a new array that contains values that arent greater or less than the bounds")
    public void generateRandomArrayReturnsBoundsToSpecification(){
        int length = 10;
        int expectedBounds = 100;
        int[] generatedArray = sortManager.generateRandomArray(length,expectedBounds);
        boolean actualBoundsMet = true;
        for (int i = 0; i< generatedArray.length; i++){
            if (generatedArray[i] < 0 || generatedArray[i] > expectedBounds){
                actualBoundsMet = false;
                break;
            }
        }
        Assertions.assertEquals(true,actualBoundsMet);
    }
    @Test
    @DisplayName("Given a length int of 0 and bounds int the the generateRandomArray method is expected to return an empty array")
    public void generateArrayWithLengthOfZero(){
        int[] expectedArray = {};
        int length = 0;
        int bounds = 100;
        int[] generatedArray = sortManager.generateRandomArray(length,bounds);
        Assertions.assertArrayEquals(expectedArray,generatedArray);
    }
    @Test
    @DisplayName("Given a length int and a negative int for the bounds the generateRandomArray method is expected to throw a \"IllegalArgumentException\"")
    public void generateArrayWithNegativeBounds(){
        int length = 10;
        int bounds = -1;
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () -> sortManager.generateRandomArray(length,bounds),"An exception has not been thrown");
    }
    @Test
    @DisplayName("Given a negative int for the length and a int for the bounds the generateRandomArray method is expected to throw a \"NegativeArraySizeException\"")
    public void generateArrayWithNegativeLength(){
        int length = -1;
        int bounds = 100;
        NegativeArraySizeException negativeArraySizeException = Assertions.assertThrows(NegativeArraySizeException.class, () -> sortManager.generateRandomArray(length,bounds),"An exception has not been thrown");
    }
    @Test
    @DisplayName("Given a length int > 500 and a bounds int the generateRandomArray method is expected to return an array of 500 values within the bounds")
    public void generateArrayWhenPassedValueGreaterThan500(){
        int expectedlength = 500;
        int testLength = 501;
        int bounds = 100;
        int[] generatedArray = sortManager.generateRandomArray(testLength,bounds);
        int actualLength = generatedArray.length;
        Assertions.assertEquals(expectedlength,actualLength);
    }

}
