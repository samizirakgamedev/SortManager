package dev.samiz.smanager.controller;

import dev.samiz.smanager.model.AvailableSorts;
import dev.samiz.smanager.model.Sort;
import dev.samiz.smanager.model.SortTypeFactory;
import java.util.Random;

public class SortManager {
    // Gets the newly created sort type created by the factory which was determined by the user input and initiates the sort algorithm.
    public int[] initiateSort(String sort, int[] arrayToSort){
        Sort s = getSort(sort);
        return s.sort(arrayToSort);
    }
    // Based on the user's console input the method uses the string to determine which sort type it should ask the factory to create and return to the initiator.
    private Sort getSort(String sortType) {
        SortTypeFactory sft = new SortTypeFactory();
        String sortTypeStringFormatted = sortType.toUpperCase();
        AvailableSorts sort = switch (sortTypeStringFormatted){
            case "BUBBLE" -> AvailableSorts.BUBBLE;
            case "MERGE" -> AvailableSorts.MERGE;
            // Case For Binary Search Will Go Here
            default -> null;
        };
        return sft.getInstance(sort);
    }
    // Method for creating an array of random ints when passed an array length and bounds for the random number generator.
    public  int[] generateRandomArray(int length, int bounds){
        Random rand = new Random();
        int[] numbersToSort = new int[length];
        for(int i = 0; i < numbersToSort.length; i++){
            numbersToSort[i] = rand.nextInt(bounds);
        }
        return numbersToSort;
    }
}
