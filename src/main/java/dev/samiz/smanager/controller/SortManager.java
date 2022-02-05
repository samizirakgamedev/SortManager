package dev.samiz.smanager.controller;

import dev.samiz.smanager.model.AvailableSorts;
import dev.samiz.smanager.model.Sort;
import dev.samiz.smanager.model.SortTypeFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;

public class SortManager {
    // Initialise logger for logging.
    private static Logger logger = LogManager.getLogger("Sort Manager Logger:");

    // Gets the newly created sort type created by the factory which was determined by the user input and initiates the sort algorithm.
    public int[] initiateSort(String sort, int[] arrayToSort){
        logger.info("The controller has been told to requested a new " + sort + " sort algorithm.");
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
        logger.info("The controller has requested a new instance of the " + sort + " algorithm from the factory");
        return sft.getInstance(sort);
    }
    // Method for creating an array of random ints when passed an array length and bounds for the random number generator.
    public  int[] generateRandomArray(int length, int bounds){
        if(length > 500){
            length = 500;
            logger.error("The controller was told to generate an array with a length greater than 500. The controller has set the array size to 500");
        }
        Random rand = new Random();
        int[] numbersToSort = new int[length];
        for(int i = 0; i < numbersToSort.length; i++){
            numbersToSort[i] = rand.nextInt(bounds);
        }
        logger.info("The controller was told to generate an array with a length of " + length + " and value bounds of " + bounds + ". This has been completed by the controller." );
        return numbersToSort;
    }
}
