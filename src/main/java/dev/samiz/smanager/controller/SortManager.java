package dev.samiz.smanager.controller;

import dev.samiz.smanager.model.AvailableSorts;
import dev.samiz.smanager.model.Sort;
import dev.samiz.smanager.model.SortTypeFactory;
import dev.samiz.smanager.view.DisplayManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class SortManager {
    // Initialise logger for logging.
    private static Logger logger = LogManager.getLogger("Sort Manager Logger:");
    // Initialise the DisplayManager.
    DisplayManager display = new DisplayManager();

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
            case "BINARY" -> AvailableSorts.BINARY;
            default -> null;
        };
        logger.info("The controller has requested a new instance of the " + sort + " algorithm from the factory");
        return sft.getInstance(sort);
    }
    // Method for creating an array of random ints when passed an array length and bounds for the random number generator.
    public  int[] generateRandomArray(int length, int bounds){
        if(length > 500){
            length = 500;
            logger.warn("The controller was told to generate an array with a length greater than 500. The controller has set the array size to 500");
        }
        Random rand = new Random();
        int[] numbersToSort = new int[length];
        for(int i = 0; i < numbersToSort.length; i++){
            numbersToSort[i] = rand.nextInt(bounds);
        }
        logger.info("The controller was told to generate an array with a length of " + length + " and value bounds of " + bounds + ". This has been completed by the controller." );
        return numbersToSort;
    }
    // Method for calling the main program loop.
    public void executeProgramLoop() {
        int loopCommand;
        do {
            // Generating a random array to use based on users input
            int[] toSort = generateRandomArray(
                    display.getDesiredInt("Please enter the length of the array you want to generate (Max 500):"),
                    display.getDesiredInt("Please enter the arrays value bounds (E.g. 400):"));
            // Outputting the generated array to the user.
            display.outputArray(toSort,
                    "The generated array has the following values:");
            // Outputting to the user the available sorts.
            display.outputAvailableSorts();
            // Getting the users input for the sort they would like to use.
            String sortOfChoice = display.getDesiredString("Please enter the name of the algorithm you want to use to sort the array:");
            // Starts timing right before the sort executes.
            long start = System.nanoTime();
            // Asking the controller to initiate the sort algorithm of the users choice and return the result.
            int[] result = initiateSort(sortOfChoice, toSort);
            // Stops timing after the algorithms stopped executing and calculates the duration.
            long duration = System.nanoTime() - start;
            // Using the display to output the result to the user.
            display.outputArray(result,
                    "The array has been sorted:");
            // Using the display the time it took in nanoseconds for the selected sort algorithm to execute.
            display.outputStatistic("The sort algorithm executed in:", duration, "nanoseconds");
            // Using the display we ask the user if they wish to loop the program or close it.
            loopCommand = display.getDesireToLoop();
        } while (loopCommand % 2 == 0);
        logger.info("The user has chosen to exit the program.");
    }
}
