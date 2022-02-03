package dev.samiz.smanager.view;

import dev.samiz.smanager.model.AvailableSorts;
import java.util.Scanner;

public class SortManagerView {
    // For Output.
    StringBuilder builder = new StringBuilder();
    // For Input.
    Scanner scanner = new Scanner(System.in);

    public void outputAvailableSorts(){
        System.out.println("The available sort algorithms are:");
        for (AvailableSorts sorts : AvailableSorts.values()) {
            builder.setLength(0);
            System.out.println(builder.append("> ").append(sorts));
        }
        System.out.println("==========================================");
    }
    public String getDesiredSort(){
        System.out.println("Please enter your desired sort algorithm:");
        String desiredSort = scanner.next().toLowerCase();
        System.out.println("==========================================");
        return desiredSort;
    }
    public int getDesiredArrayLength(){
        System.out.println("Please enter your desired array length as a whole number (E.g. 8):");
        int desiredArrayLength = scanner.nextInt();
        System.out.println("==========================================");
        return desiredArrayLength;
    }
    public int getDesiredValueBounds(){
        System.out.println("Please enter the largest possible value you want to see in the array as a whole number (E.g. 400):");
        int desiredValueBounds = scanner.nextInt();
        System.out.println("==========================================");
        return desiredValueBounds;
    }
    public void outputInitialArray(int[] initialArray){
        System.out.println("The array you have generated is:");
        outputArray(initialArray);
        System.out.println("==========================================");
    }
    public void outputResults(int[] sortedArray) {
        System.out.println("The results of the sort are:");
        outputArray(sortedArray);
        System.out.println("==========================================");
    }
    private void outputArray(int[] numbers){
        builder.setLength(0);
        for(int i = 0; i < numbers.length; i++){
            builder.append("Number " ).append(i+1).append(": ").append(numbers[i]).append(" | ");
        }
        System.out.println(builder);
    }
}
