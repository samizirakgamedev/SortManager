package dev.samiz.smanager;

import dev.samiz.smanager.controller.SortManagerController;
import dev.samiz.smanager.view.SortManagerView;

public class SortManagerMain {
    public static void main(String[] args){
        // Initialising the View.
        SortManagerView view = new SortManagerView();
        // Initialising the Controller.
        SortManagerController controller = new SortManagerController();
        // Generating a random array to use base of users input
        int[] toSort = controller.generateRandomArray(view.getDesiredArrayLength(), view.getDesiredValueBounds());
        // Outputting the generated array.
        view.outputInitialArray(toSort);
        // Outputting to the user the available sorts.
        view.outputAvailableSorts();
        // Getting the users input for the sort they would like to use.
        String sortOfChoice = view.getDesiredSort();
        // Asking the controller to initiate the sort algorithm of the users choice and return the result.
        int [] result = controller.initiateSort(sortOfChoice, toSort);
        // Using the view to output the result to the user.
        view.outputResults(result);
    }
}
