package dev.samiz.smanager;

import dev.samiz.smanager.controller.SortManager;
import dev.samiz.smanager.view.DisplayManager;

public class SortManagerMain {
    public static void main(String[] args){
        // Initialising the View and Controller
        DisplayManager display = new DisplayManager();
        SortManager controller = new SortManager();

        // Generating a random array to use based on users input
        int[] toSort = controller.generateRandomArray(
                display.getDesiredInt("Please enter the length of the array you want to generate (E.g. 8):"),
                display.getDesiredInt("Please enter the arrays value bounds (E.g. 400):"));
        // Outputting the generated array to the user.
        display.outputArray(toSort,
                "The generated array has the following values:");
        // Outputting to the user the available sorts.
        display.outputAvailableSorts();
        // Getting the users input for the sort they would like to use.
        String sortOfChoice = display.getDesiredString("Please enter the name of the algorithm you want to use to sort the array:");
        // Asking the controller to initiate the sort algorithm of the users choice and return the result.
        int [] result = controller.initiateSort(sortOfChoice, toSort);
        // Using the display to output the result to the user.
        display.outputArray(result,
                "The array has been sorted:");
    }
}
